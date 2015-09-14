package net.pixzelpro.mcplus.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.pixzelpro.mcplus.init.ModItems;

public class MagnetronRecipes {

	private static final MagnetronRecipes magnetizingBase = new MagnetronRecipes();
    private Map magnetizingList = new HashMap(); // The list of magnetization results
    private Map experienceList = new HashMap();

    /** Used to call methods addSmelting and getMagnetizationResult.*/
    public static MagnetronRecipes magnetizing()
    {
        return magnetizingBase;
    }

    private MagnetronRecipes()
    {
        this.addItemRecipe(ModItems.item_bar, new ItemStack(ModItems.item_magnet, 1), 0.35F);
    }

    public void addBlockRecipe(Block block, ItemStack itemstack, float par1)
    {
        this.addItemRecipe(Item.getItemFromBlock(block), itemstack, par1);
    }

    public void addItemRecipe(Item item, ItemStack itemstack, float par1)
    {
        this.addToList(new ItemStack(item, 1, 32767), itemstack, par1);
    }

    public void addToList(ItemStack itemstack, ItemStack itemstack2, float par1)
    {
        this.magnetizingList.put(itemstack, itemstack2);
        this.experienceList.put(itemstack2, Float.valueOf(par1));
    }

    /** Returns the magnetization result of an item. */
    public ItemStack getMagnetizationResult(ItemStack itemstack)
    {
        Iterator iterator = this.magnetizingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.compareItems(itemstack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean compareItems(ItemStack itemstack, ItemStack itemstack2)
    {
        return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
    }

    public Map getMagnetizingList()
    {
        return this.magnetizingList;
    }

    public float getExp(ItemStack itemstack)
    {
        float ret = itemstack.getItem().getSmeltingExperience(itemstack);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.compareItems(itemstack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}