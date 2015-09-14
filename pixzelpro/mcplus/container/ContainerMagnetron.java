package net.pixzelpro.mcplus.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.pixzelpro.mcplus.recipes.MagnetronRecipes;
import net.pixzelpro.mcplus.tileentity.TileEntityMagnetron;

public class ContainerMagnetron extends Container {

	private TileEntityMagnetron tileMagnetron;
	private int lastMagTime; // lastCookTime
	private int lastMagnetizationTime; // lastBurnTime
	private int lastItemMagTime; // lastItemBurnTime
	
	public ContainerMagnetron(InventoryPlayer player, TileEntityMagnetron magnetron)
	{
	    this.tileMagnetron = magnetron;
	    this.addSlotToContainer(new Slot(magnetron, 0, 56, 35)); // Bar slot
	    this.addSlotToContainer(new Slot(magnetron, 1, 8, 62)); // Coil Slot
	    this.addSlotToContainer(new SlotFurnace(player.player, magnetron, 2, 116, 35));
	    int i;
	
	    for (i = 0; i < 3; ++i)
	    {
	        for (int j = 0; j < 9; ++j)
	        {
	            this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	        }
	    }
	
	    for (i = 0; i < 9; ++i)
	    {
	        this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
	    }
	}
	
	public void addCraftingToCrafters(ICrafting icrafting)
	{
	    super.addCraftingToCrafters(icrafting);
	    icrafting.sendProgressBarUpdate(this, 0, this.tileMagnetron.magnetronCurrentMagTime);
	    icrafting.sendProgressBarUpdate(this, 1, this.tileMagnetron.magnetronMagTime);
	    icrafting.sendProgressBarUpdate(this, 2, this.tileMagnetron.magnetronCurrentMagTime);
	}
	
	/** Looks for changes made in the container, sends them to every listener. */
	public void detectAndSendChanges()
	{
	    super.detectAndSendChanges();
	
	    for (int i = 0; i < this.crafters.size(); ++i)
	    {
	        ICrafting icrafting = (ICrafting)this.crafters.get(i);
	
	        if (this.lastMagTime != this.tileMagnetron.magnetronCurrentMagTime)
	        {
	            icrafting.sendProgressBarUpdate(this, 0, this.tileMagnetron.magnetronCurrentMagTime);
	        }
	
	        if (this.lastMagnetizationTime != this.tileMagnetron.magnetronMagTime)
	        {
	            icrafting.sendProgressBarUpdate(this, 1, this.tileMagnetron.magnetronMagTime);
	        }
	
	        if (this.lastItemMagTime != this.tileMagnetron.magnetronCurrentMagTime)
	        {
	            icrafting.sendProgressBarUpdate(this, 2, this.tileMagnetron.magnetronCurrentMagTime);
	        }
	    }
	
	    this.lastMagTime = this.tileMagnetron.magnetronCurrentMagTime;
	    this.lastMagnetizationTime = this.tileMagnetron.magnetronMagTime;
	    this.lastItemMagTime = this.tileMagnetron.magnetronCurrentMagTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2)
	{
	    if (par1 == 0)
	    {
	        this.tileMagnetron.magnetronCurrentMagTime = par2;
	    }
	
	    if (par1 == 1)
	    {
	        this.tileMagnetron.magnetronMagTime = par2;
	    }
	
	    if (par1 == 2)
	    {
	        this.tileMagnetron.magnetronCurrentMagTime = par2;
	    }
	}
	
	public boolean canInteractWith(EntityPlayer player)
	{
	    return this.tileMagnetron.isUseableByPlayer(player);
	}
	
	/** Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that. */
	public ItemStack transferStackInSlot(EntityPlayer player, int i)
	{
	    ItemStack itemstack = null;
	    Slot slot = (Slot)this.inventorySlots.get(i);
	
	    if (slot != null && slot.getHasStack())
	    {
	        ItemStack itemstack1 = slot.getStack();
	        itemstack = itemstack1.copy();
	
	        if (i == 2)
	        {
	            if (!this.mergeItemStack(itemstack1, 3, 39, true))
	            {
	                return null;
	            }
	
	            slot.onSlotChange(itemstack1, itemstack);
	        }
	        else if (i != 1 && i != 0)
	        {
	            if (MagnetronRecipes.magnetizing().getMagnetizationResult(itemstack1) != null)
	            {
	                if (!this.mergeItemStack(itemstack1, 0, 1, false))
	                {
	                    return null;
	                }
	            }
	            else if (TileEntityMagnetron.isItemFuel(itemstack1))
	            {
	                if (!this.mergeItemStack(itemstack1, 1, 2, false))
	                {
	                    return null;
	                }
	            }
	            else if (i >= 3 && i < 30)
	            {
	                if (!this.mergeItemStack(itemstack1, 30, 39, false))
	                {
	                    return null;
	                }
	            }
	            else if (i >= 30 && i < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
	            {
	                return null;
	            }
	        }
	        else if (!this.mergeItemStack(itemstack1, 3, 39, false))
	        {
	            return null;
	        }
	
	        if (itemstack1.stackSize == 0)
	        {
	            slot.putStack((ItemStack)null);
	        }
	        else
	        {
	            slot.onSlotChanged();
	        }
	
	        if (itemstack1.stackSize == itemstack.stackSize)
	        {
	            return null;
	        }
	
	        slot.onPickupFromSlot(player, itemstack1);
	    }
	
	    return itemstack;
	}
}