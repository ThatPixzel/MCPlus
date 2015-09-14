package net.pixzelpro.mcplus.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SuperCrafterShapedRecipes implements IRecipe {
	
	public final int recipeWidth;
    public final int recipeHeight;
    public final ItemStack[] recipeItems;
    private ItemStack recipeOutput;
    private boolean bool1;

    public SuperCrafterShapedRecipes(int int1, int int2, ItemStack[] itemStack1, ItemStack itemStack2) {
        this.recipeWidth = int1;
        this.recipeHeight = int2;
        this.recipeItems = itemStack1;
        this.recipeOutput = itemStack2;
    }

    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    public boolean matches(InventoryCrafting inventoryCrafting, World world)  {
        for (int i = 0; i <= 5 - this.recipeWidth; ++i) {
            for (int j = 0; j <= 5 - this.recipeHeight; ++j) {
                if (this.checkMatch(inventoryCrafting, i, j, true)) {
                    return true;
                }

                if (this.checkMatch(inventoryCrafting, i, j, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkMatch(InventoryCrafting inventoryCrafting, int int1, int int2, boolean bool1) {
        for (int k = 0; k < 5; ++k) {
            for (int l = 0; l < 5; ++l) {
                int i1 = k - int1;
                int j1 = l - int2;
                ItemStack itemstack = null;

                if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight) {
                    if (bool1) {
                        itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
                    } else {
                        itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
                    }
                }

                ItemStack itemstack1 = inventoryCrafting.getStackInRowAndColumn(k, l);

                if (itemstack1 != null || itemstack != null) {
                    if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null) {
                        return false;
                    }

                    if (itemstack.getItem() != itemstack1.getItem()) {
                        return false;
                    }

                    if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        ItemStack itemstack = this.getRecipeOutput().copy();

        if (this.bool1) {
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
                ItemStack itemstack1 = inventoryCrafting.getStackInSlot(i);

                if (itemstack1 != null && itemstack1.hasTagCompound()) {
                    itemstack.setTagCompound((NBTTagCompound)itemstack1.stackTagCompound.copy());
                }
            }
        }

        return itemstack;
    }

    public int getRecipeSize() {
        return this.recipeWidth * this.recipeHeight;
    }

    public SuperCrafterShapedRecipes func_92100_c() {
        this.bool1 = true;
        return this;
    }
}