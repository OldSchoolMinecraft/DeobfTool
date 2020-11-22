# DeobfTool
Quick and dirty way of deobfuscating a list of class names.

## Example Usage

<code>java -jar DeobfTool.jar classes.csv conversions.txt</code>

conversions.txt (modified classes for OptiFine 1.1 HD D6):
<pre>
aby
ajo
cm
hh
jk
kz
l
ld
mq
mv
uc
ur
xt
yz
</pre>

Output:
<pre>
Mappings: classes.csv
Conversion list: conversions.txt
Name, Notch, Supername, Package, Side
RenderGlobal, l, , net/minecraft/src, 0
FontRenderer, mq, , net/minecraft/src, 0
WorldRenderer, cm, , net/minecraft/src, 0
RenderBlocks, uc, , net/minecraft/src, 0
EntityRenderer, kz, , net/minecraft/src, 0
ClippingHelper, ur, , net/minecraft/src, 0
GuiVideoSettings, jk, GuiScreen, net/minecraft/src, 0
EnumOptions, xt, , net/minecraft/src, 0
Profiler, ld, , net/minecraft/src, 0
ICamera, ajo, , net/minecraft/src, 0
RenderEngine, yz, , net/minecraft/src, 0
Tessellator, aby, , net/minecraft/src, 0
GameSettings, hh, , net/minecraft/src, 0
Frustrum, mv, , net/minecraft/src, 0
InventoryCrafting, mq, , net/minecraft/src, 1
Packet100OpenWindow, jk, Packet, net/minecraft/src, 1
BlockPistonMoving, uc, BlockContainer, net/minecraft/src, 1
ComponentStrongholdChestCorridor, hh, ComponentStronghold, net/minecraft/src, 1
EntityMoveHelper, l, , net/minecraft/src, 1
RecipeSorter, kz, , net/minecraft/src, 1
EnchantmentModifierDamage, ld, , net/minecraft/src, 1
NetworkWriterThread, xt, , net/minecraft/src, 1
ItemSign, ur, Item, net/minecraft/src, 1
ItemAppleGold, yz, ItemFood, net/minecraft/src, 1
EntityFireball, cm, Entity, net/minecraft/src, 1
EntityBlaze, mv, EntityMob, net/minecraft/src, 1
</pre>

If you only want it to show client classes, you can specify 0 as a third argument. Using 1 will do the same but for server classes.
