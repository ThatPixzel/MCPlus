package net.pixzelpro.mcplus.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.pixzelpro.mcplus.init.ModBlocks;
import net.pixzelpro.mcplus.recipes.SuperCrafterCraftingManager;

public class ContainerSuperCrafter extends Container {
	
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerSuperCrafter (InventoryPlayer invPlayer, World world, int x, int y, int z) { // "Coordinates... truth!"
		craftMatrix = new InventoryCrafting(this, 5, 5);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		
		// Add the output slot
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 141, 43));
		
		// Add 5x5 crafting slots
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 5; k++) {
				this.addSlotToContainer(new Slot(craftMatrix, k + i * 5, 8 + k * 18, 7 + i * 18));
			}
		}
		
		// Add player inventory slots
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 106 + i * 18));
			}
		}
		
		// Add the hotbar slots
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 164));
		}
		
		onCraftMatrixChanged(craftMatrix);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int int1)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(int1);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (int1 == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (int1 >= 10 && int1 < 37) {
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                    return null;
                }
            } else if (int1 >= 37 && int1 < 46) {
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
	
	public void onCraftMatrixChanged (IInventory iInventory) {
		craftResult.setInventorySlotContents(0, SuperCrafterCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (worldObj.getBlock(posX, posY, posZ) != ModBlocks.block_super_crafter) {
			return false;
		} else {
			return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
		}
	}
	
	public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);

        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 25; ++i) { // NOTE !! Changed to 25 from 9
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null) {
                    player.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
}