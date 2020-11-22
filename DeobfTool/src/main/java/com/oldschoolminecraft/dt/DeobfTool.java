package com.oldschoolminecraft.dt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class DeobfTool
{
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Missing arguments");
            return;
        }
        
        String mappings = args[0];
        String conversionList = args[1];
        
        File mapFile = new File(mappings);
        File conListFile = new File(conversionList);
        
        System.out.println("Mappings: " + mapFile.getName());
        System.out.println("Conversion list: " + conListFile.getName());
        
        if (!mapFile.exists())
        {
            System.out.println("Mappings file doesn't exist");
            return;
        }
        
        if (!conListFile.exists())
        {
            System.out.println("Conversion list doesn't exist");
            return;
        }
        
        boolean bothSides = true;
        String side = null;
        
        if (args.length >= 3)
        {
            bothSides = false;
            side = args[2];
            
            System.out.println("Side: " + side);
        }
        
        try
        {
            ArrayList<String> conList = new ArrayList<String>();
            
            BufferedReader b = new BufferedReader(new FileReader(new File(conversionList)));
            String readLine = "";
            while ((readLine = b.readLine()) != null)
                conList.add(readLine);
            
            Reader in = new FileReader(mappings);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
            
            System.out.println("Name, Notch, Supername, Package, Side");
            for (CSVRecord record : records)
            {
                String rec_name = record.get("name");
                String rec_notch = record.get("notch");
                String rec_supername = record.get("supername");
                String rec_package = record.get("package");
                String rec_side = record.get("side");
                
                if (!bothSides)
                    if (!rec_side.equals(side))
                        continue;
                
                for (String con : conList)
                {
                    boolean printRec = false;
                    
                    if (rec_name.equalsIgnoreCase(con))
                    {
                        printRec = true;
                    } else if (rec_notch.equalsIgnoreCase(con)) {
                        printRec = true;
                    } else if (rec_supername.equalsIgnoreCase(con)) {
                        printRec = true;
                    } else if (rec_package.equalsIgnoreCase(con)) {
                        printRec = true;
                    } else if (rec_side.equalsIgnoreCase(con)) {
                        printRec = true;
                    }
                    
                    if (printRec)
                        System.out.println(String.format("%s, %s, %s, %s, %s", rec_name, rec_notch, rec_supername, rec_package, rec_side));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
