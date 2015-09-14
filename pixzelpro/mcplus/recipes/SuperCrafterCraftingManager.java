package net.pixzelpro.mcplus.recipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.pixzelpro.mcplus.crafting.ModCraftingManager;

public class SuperCrafterCraftingManager {

    private static final SuperCrafterCraftingManager instance = new SuperCrafterCraftingManager();
    private List recipes = new ArrayList();

    public static final SuperCrafterCraftingManager getInstance() {
        return instance;
    }

    private SuperCrafterCraftingManager() {
    	recipes = new ArrayList();
    	
    	ModCraftingManager.registerSuperRecipes(this);
    	
    	this.addShapedRecipe(new ItemStack(Items.paper, 3), new Object[] {"###", '#', Items.reeds});
        this.addShapelessRecipe(new ItemStack(Items.book, 1), new Object[] {Items.paper, Items.paper, Items.paper, Items.leather});
        this.addShapelessRecipe(new ItemStack(Items.writable_book, 1), new Object[] {Items.book, new ItemStack(Items.dye, 1, 0), Items.feather});
        this.addShapedRecipe(new ItemStack(Blocks.fence, 2), new Object[] {"###", "###", '#', Items.stick});
        this.addShapedRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 0), new Object[] {"###", "###", '#', Blocks.cobblestone});
        this.addShapedRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 1), new Object[] {"###", "###", '#', Blocks.mossy_cobblestone});
        this.addShapedRecipe(new ItemStack(Blocks.nether_brick_fence, 6), new Object[] {"###", "###", '#', Blocks.nether_brick});
        this.addShapedRecipe(new ItemStack(Blocks.fence_gate, 1), new Object[] {"#W#", "#W#", '#', Items.stick, 'W', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Blocks.jukebox, 1), new Object[] {"###", "#X#", "###", '#', Blocks.planks, 'X', Items.diamond});
        this.addShapedRecipe(new ItemStack(Items.lead, 2), new Object[] {"~~ ", "~O ", "  ~", '~', Items.string, 'O', Items.slime_ball});
        this.addShapedRecipe(new ItemStack(Blocks.noteblock, 1), new Object[] {"###", "#X#", "###", '#', Blocks.planks, 'X', Items.redstone});
        this.addShapedRecipe(new ItemStack(Blocks.bookshelf, 1), new Object[] {"###", "XXX", "###", '#', Blocks.planks, 'X', Items.book});
        this.addShapedRecipe(new ItemStack(Blocks.snow, 1), new Object[] {"##", "##", '#', Items.snowball});
        this.addShapedRecipe(new ItemStack(Blocks.snow_layer, 6), new Object[] {"###", '#', Blocks.snow});
        this.addShapedRecipe(new ItemStack(Blocks.clay, 1), new Object[] {"##", "##", '#', Items.clay_ball});
        this.addShapedRecipe(new ItemStack(Blocks.brick_block, 1), new Object[] {"##", "##", '#', Items.brick});
        this.addShapedRecipe(new ItemStack(Blocks.glowstone, 1), new Object[] {"##", "##", '#', Items.glowstone_dust});
        this.addShapedRecipe(new ItemStack(Blocks.quartz_block, 1), new Object[] {"##", "##", '#', Items.quartz});
        this.addShapedRecipe(new ItemStack(Blocks.wool, 1), new Object[] {"##", "##", '#', Items.string});
        this.addShapedRecipe(new ItemStack(Blocks.tnt, 1), new Object[] {"X#X", "#X#", "X#X", 'X', Items.gunpowder, '#', Blocks.sand});
        this.addShapedRecipe(new ItemStack(Blocks.stone_slab, 6, 3), new Object[] {"###", '#', Blocks.cobblestone});
        this.addShapedRecipe(new ItemStack(Blocks.stone_slab, 6, 0), new Object[] {"###", '#', Blocks.stone});
        this.addShapedRecipe(new ItemStack(Blocks.stone_slab, 6, 1), new Object[] {"###", '#', Blocks.sandstone});
        this.addShapedRecipe(new ItemStack(Blocks.stone_slab, 6, 4), new Object[] {"###", '#', Blocks.brick_block});
        this.addShapedRecipe(new ItemStack(Blocks.stone_slab, 6, 5), new Object[] {"###", '#', Blocks.stonebrick});
        this.addShapedRecipe(new ItemStack(Blocks.stone_slab, 6, 6), new Object[] {"###", '#', Blocks.nether_brick});
        this.addShapedRecipe(new ItemStack(Blocks.stone_slab, 6, 7), new Object[] {"###", '#', Blocks.quartz_block});
        this.addShapedRecipe(new ItemStack(Blocks.wooden_slab, 6, 0), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 0)});
        this.addShapedRecipe(new ItemStack(Blocks.wooden_slab, 6, 2), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 2)});
        this.addShapedRecipe(new ItemStack(Blocks.wooden_slab, 6, 1), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 1)});
        this.addShapedRecipe(new ItemStack(Blocks.wooden_slab, 6, 3), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 3)});
        this.addShapedRecipe(new ItemStack(Blocks.wooden_slab, 6, 4), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 4)});
        this.addShapedRecipe(new ItemStack(Blocks.wooden_slab, 6, 5), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 5)});
        this.addShapedRecipe(new ItemStack(Blocks.ladder, 3), new Object[] {"# #", "###", "# #", '#', Items.stick});
        this.addShapedRecipe(new ItemStack(Items.wooden_door, 1), new Object[] {"##", "##", "##", '#', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[] {"###", "###", '#', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Items.iron_door, 1), new Object[] {"##", "##", "##", '#', Items.iron_ingot});
        this.addShapedRecipe(new ItemStack(Items.sign, 3), new Object[] {"###", "###", " X ", '#', Blocks.planks, 'X', Items.stick});
        this.addShapedRecipe(new ItemStack(Items.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.wheat, 'E', Items.egg});
        this.addShapedRecipe(new ItemStack(Items.sugar, 1), new Object[] {"#", '#', Items.reeds});
        this.addShapedRecipe(new ItemStack(Blocks.planks, 4, 0), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 0)});
        this.addShapedRecipe(new ItemStack(Blocks.planks, 4, 1), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 1)});
        this.addShapedRecipe(new ItemStack(Blocks.planks, 4, 2), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 2)});
        this.addShapedRecipe(new ItemStack(Blocks.planks, 4, 3), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 3)});
        this.addShapedRecipe(new ItemStack(Blocks.planks, 4, 4), new Object[] {"#", '#', new ItemStack(Blocks.log2, 1, 0)});
        this.addShapedRecipe(new ItemStack(Blocks.planks, 4, 5), new Object[] {"#", '#', new ItemStack(Blocks.log2, 1, 1)});
        this.addShapedRecipe(new ItemStack(Items.stick, 4), new Object[] {"#", "#", '#', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Blocks.torch, 4), new Object[] {"X", "#", 'X', Items.coal, '#', Items.stick});
        this.addShapedRecipe(new ItemStack(Blocks.torch, 4), new Object[] {"X", "#", 'X', new ItemStack(Items.coal, 1, 1), '#', Items.stick});
        this.addShapedRecipe(new ItemStack(Items.bowl, 4), new Object[] {"# #", " # ", '#', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Items.glass_bottle, 3), new Object[] {"# #", " # ", '#', Blocks.glass});
        this.addShapedRecipe(new ItemStack(Blocks.rail, 16), new Object[] {"X X", "X#X", "X X", 'X', Items.iron_ingot, '#', Items.stick});
        this.addShapedRecipe(new ItemStack(Blocks.golden_rail, 6), new Object[] {"X X", "X#X", "XRX", 'X', Items.gold_ingot, 'R', Items.redstone, '#', Items.stick});
        this.addShapedRecipe(new ItemStack(Blocks.activator_rail, 6), new Object[] {"XSX", "X#X", "XSX", 'X', Items.iron_ingot, '#', Blocks.redstone_torch, 'S', Items.stick});
        this.addShapedRecipe(new ItemStack(Blocks.detector_rail, 6), new Object[] {"X X", "X#X", "XRX", 'X', Items.iron_ingot, 'R', Items.redstone, '#', Blocks.stone_pressure_plate});
        this.addShapedRecipe(new ItemStack(Items.minecart, 1), new Object[] {"# #", "###", '#', Items.iron_ingot});
        this.addShapedRecipe(new ItemStack(Items.cauldron, 1), new Object[] {"# #", "# #", "###", '#', Items.iron_ingot});
        this.addShapedRecipe(new ItemStack(Items.brewing_stand, 1), new Object[] {" B ", "###", '#', Blocks.cobblestone, 'B', Items.blaze_rod});
        this.addShapedRecipe(new ItemStack(Blocks.lit_pumpkin, 1), new Object[] {"A", "B", 'A', Blocks.pumpkin, 'B', Blocks.torch});
        this.addShapedRecipe(new ItemStack(Items.chest_minecart, 1), new Object[] {"A", "B", 'A', Blocks.chest, 'B', Items.minecart});
        this.addShapedRecipe(new ItemStack(Items.furnace_minecart, 1), new Object[] {"A", "B", 'A', Blocks.furnace, 'B', Items.minecart});
        this.addShapedRecipe(new ItemStack(Items.tnt_minecart, 1), new Object[] {"A", "B", 'A', Blocks.tnt, 'B', Items.minecart});
        this.addShapedRecipe(new ItemStack(Items.hopper_minecart, 1), new Object[] {"A", "B", 'A', Blocks.hopper, 'B', Items.minecart});
        this.addShapedRecipe(new ItemStack(Items.boat, 1), new Object[] {"# #", "###", '#', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Items.bucket, 1), new Object[] {"# #", " # ", '#', Items.iron_ingot});
        this.addShapedRecipe(new ItemStack(Items.flower_pot, 1), new Object[] {"# #", " # ", '#', Items.brick});
        this.addShapelessRecipe(new ItemStack(Items.flint_and_steel, 1), new Object[] {new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.flint, 1)});
        this.addShapedRecipe(new ItemStack(Items.bread, 1), new Object[] {"###", '#', Items.wheat});
        this.addShapedRecipe(new ItemStack(Blocks.oak_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 0)});
        this.addShapedRecipe(new ItemStack(Blocks.birch_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 2)});
        this.addShapedRecipe(new ItemStack(Blocks.spruce_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 1)});
        this.addShapedRecipe(new ItemStack(Blocks.jungle_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 3)});
        this.addShapedRecipe(new ItemStack(Blocks.acacia_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 4)});
        this.addShapedRecipe(new ItemStack(Blocks.dark_oak_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 5)});
        this.addShapedRecipe(new ItemStack(Items.fishing_rod, 1), new Object[] {"  #", " #X", "# X", '#', Items.stick, 'X', Items.string});
        this.addShapedRecipe(new ItemStack(Items.carrot_on_a_stick, 1), new Object[] {"# ", " X", '#', Items.fishing_rod, 'X', Items.carrot}).func_92100_c();
        this.addShapedRecipe(new ItemStack(Blocks.stone_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.cobblestone});
        this.addShapedRecipe(new ItemStack(Blocks.brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.brick_block});
        this.addShapedRecipe(new ItemStack(Blocks.stone_brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.stonebrick});
        this.addShapedRecipe(new ItemStack(Blocks.nether_brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.nether_brick});
        this.addShapedRecipe(new ItemStack(Blocks.sandstone_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.sandstone});
        this.addShapedRecipe(new ItemStack(Blocks.quartz_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.quartz_block});
        this.addShapedRecipe(new ItemStack(Items.painting, 1), new Object[] {"###", "#X#", "###", '#', Items.stick, 'X', Blocks.wool});
        this.addShapedRecipe(new ItemStack(Items.item_frame, 1), new Object[] {"###", "#X#", "###", '#', Items.stick, 'X', Items.leather});
        this.addShapedRecipe(new ItemStack(Items.golden_apple, 1, 0), new Object[] {"###", "#X#", "###", '#', Items.gold_ingot, 'X', Items.apple});
        this.addShapedRecipe(new ItemStack(Items.golden_apple, 1, 1), new Object[] {"###", "#X#", "###", '#', Blocks.gold_block, 'X', Items.apple});
        this.addShapedRecipe(new ItemStack(Items.golden_carrot, 1, 0), new Object[] {"###", "#X#", "###", '#', Items.gold_nugget, 'X', Items.carrot});
        this.addShapedRecipe(new ItemStack(Items.speckled_melon, 1), new Object[] {"###", "#X#", "###", '#', Items.gold_nugget, 'X', Items.melon});
        this.addShapedRecipe(new ItemStack(Blocks.lever, 1), new Object[] {"X", "#", '#', Blocks.cobblestone, 'X', Items.stick});
        this.addShapedRecipe(new ItemStack(Blocks.tripwire_hook, 2), new Object[] {"I", "S", "#", '#', Blocks.planks, 'S', Items.stick, 'I', Items.iron_ingot});
        this.addShapedRecipe(new ItemStack(Blocks.redstone_torch, 1), new Object[] {"X", "#", '#', Items.stick, 'X', Items.redstone});
        this.addShapedRecipe(new ItemStack(Items.repeater, 1), new Object[] {"#X#", "III", '#', Blocks.redstone_torch, 'X', Items.redstone, 'I', Blocks.stone});
        this.addShapedRecipe(new ItemStack(Items.comparator, 1), new Object[] {" # ", "#X#", "III", '#', Blocks.redstone_torch, 'X', Items.quartz, 'I', Blocks.stone});
        this.addShapedRecipe(new ItemStack(Items.clock, 1), new Object[] {" # ", "#X#", " # ", '#', Items.gold_ingot, 'X', Items.redstone});
        this.addShapedRecipe(new ItemStack(Items.compass, 1), new Object[] {" # ", "#X#", " # ", '#', Items.iron_ingot, 'X', Items.redstone});
        this.addShapedRecipe(new ItemStack(Items.map, 1), new Object[] {"###", "#X#", "###", '#', Items.paper, 'X', Items.compass});
        this.addShapedRecipe(new ItemStack(Blocks.stone_button, 1), new Object[] {"#", '#', Blocks.stone});
        this.addShapedRecipe(new ItemStack(Blocks.wooden_button, 1), new Object[] {"#", '#', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Blocks.stone_pressure_plate, 1), new Object[] {"##", '#', Blocks.stone});
        this.addShapedRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[] {"##", '#', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Blocks.heavy_weighted_pressure_plate, 1), new Object[] {"##", '#', Items.iron_ingot});
        this.addShapedRecipe(new ItemStack(Blocks.light_weighted_pressure_plate, 1), new Object[] {"##", '#', Items.gold_ingot});
        this.addShapedRecipe(new ItemStack(Blocks.dispenser, 1), new Object[] {"###", "#X#", "#R#", '#', Blocks.cobblestone, 'X', Items.bow, 'R', Items.redstone});
        this.addShapedRecipe(new ItemStack(Blocks.dropper, 1), new Object[] {"###", "# #", "#R#", '#', Blocks.cobblestone, 'R', Items.redstone});
        this.addShapedRecipe(new ItemStack(Blocks.piston, 1), new Object[] {"TTT", "#X#", "#R#", '#', Blocks.cobblestone, 'X', Items.iron_ingot, 'R', Items.redstone, 'T', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Blocks.sticky_piston, 1), new Object[] {"S", "P", 'S', Items.slime_ball, 'P', Blocks.piston});
        this.addShapedRecipe(new ItemStack(Items.bed, 1), new Object[] {"###", "XXX", '#', Blocks.wool, 'X', Blocks.planks});
        this.addShapedRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[] {" B ", "D#D", "###", '#', Blocks.obsidian, 'B', Items.book, 'D', Items.diamond});
        this.addShapedRecipe(new ItemStack(Blocks.anvil, 1), new Object[] {"III", " i ", "iii", 'I', Blocks.iron_block, 'i', Items.iron_ingot});
        this.addShapelessRecipe(new ItemStack(Items.ender_eye, 1), new Object[] {Items.ender_pearl, Items.blaze_powder});
        this.addShapelessRecipe(new ItemStack(Items.fire_charge, 3), new Object[] {Items.gunpowder, Items.blaze_powder, Items.coal});
        this.addShapelessRecipe(new ItemStack(Items.fire_charge, 3), new Object[] {Items.gunpowder, Items.blaze_powder, new ItemStack(Items.coal, 1, 1)});
        this.addShapedRecipe(new ItemStack(Blocks.daylight_detector), new Object[] {"GGG", "QQQ", "WWW", 'G', Blocks.glass, 'Q', Items.quartz, 'W', Blocks.wooden_slab});
        this.addShapedRecipe(new ItemStack(Blocks.hopper), new Object[] {"I I", "ICI", " I ", 'I', Items.iron_ingot, 'C', Blocks.chest});
        this.addShapedRecipe(new ItemStack(Blocks.crafting_table), new Object[] {"PP", "PP", 'P', Blocks.planks});
    	
        Collections.sort(this.recipes, new SuperCrafterRecipeSorter(this));
    }

    public SuperCrafterShapedRecipes addShapedRecipe(ItemStack itemStack, Object ... objects) {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (objects[i] instanceof String[]) {
            String[] astring = (String[])((String[])objects[i++]);

            for (int l = 0; l < astring.length; ++l) {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        } else {
            while (objects[i] instanceof String) {
                String s2 = (String)objects[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < objects.length; i += 2) {
            Character character = (Character)objects[i];
            ItemStack itemstack1 = null;

            if (objects[i + 1] instanceof Item) {
                itemstack1 = new ItemStack((Item)objects[i + 1]);
            } else if (objects[i + 1] instanceof Block) {
                itemstack1 = new ItemStack((Block)objects[i + 1], 1, 32767);
            } else if (objects[i + 1] instanceof ItemStack) {
                itemstack1 = (ItemStack)objects[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1) {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0))) {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            } else {
                aitemstack[i1] = null;
            }
        }

        SuperCrafterShapedRecipes shapedrecipes = new SuperCrafterShapedRecipes(j, k, aitemstack, itemStack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack itemStack, Object ... objects) {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = objects;
        int i = objects.length;

        for (int j = 0; j < i; ++j) {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack) {
                arraylist.add(((ItemStack)object1).copy());
            } else if (object1 instanceof Item) {
                arraylist.add(new ItemStack((Item)object1));
            } else {
                if (!(object1 instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new ShapelessRecipes(itemStack, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting inventoryCrafting, World world) {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < inventoryCrafting.getSizeInventory(); ++j) {
            ItemStack itemstack2 = inventoryCrafting.getStackInSlot(j);

            if (itemstack2 != null) {
                if (i == 0) {
                    itemstack = itemstack2;
                }

                if (i == 1) {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()) {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0) {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        } else {
            for (j = 0; j < this.recipes.size(); ++j) {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(inventoryCrafting, world)) {
                    return irecipe.getCraftingResult(inventoryCrafting);
                }
            }

            return null;
        }
    }

    public List getRecipeList() {
        return this.recipes;
    }
}