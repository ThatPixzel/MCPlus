package net.pixzelpro.mcplus.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.pixzelpro.mcplus.blocks.BlockMagnetron;
import net.pixzelpro.mcplus.recipes.MagnetronRecipes;

public class TileEntityMagnetron extends TileEntity implements ISidedInventory {

	private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    private ItemStack[] magnetronItemStacks = new ItemStack[3]; // The ItemStacks that hold the items currently being used in the magnetron
    public static int magnetronMagTime; // (furnaceBurnTime) The number of ticks that the magnetron will keep running
    public static int currentItemMagTime; // (currentItemBurnTime) The number of ticks that a fresh copy of the currently-burning item would keep the magnetron running for
    public static int magnetronCurrentMagTime; // (furnaceCookTime) The number of ticks that the current item has been cooking for
    private String name;

    /** Returns the number of slots in the inventory. */
    public int getSizeInventory()
    {
        return this.magnetronItemStacks.length;
    }

    /** Returns the stack in slot i */
    public ItemStack getStackInSlot(int i)
    {
        return this.magnetronItemStacks[i];
    }

    /** Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a new stack. */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.magnetronItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.magnetronItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.magnetronItemStacks[par1];
                this.magnetronItemStacks[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.magnetronItemStacks[par1].splitStack(par2);

                if (this.magnetronItemStacks[par1].stackSize == 0)
                {
                    this.magnetronItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    /** When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem - like when you close a workbench GUI. */
    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (this.magnetronItemStacks[i] != null)
        {
            ItemStack itemstack = this.magnetronItemStacks[i];
            this.magnetronItemStacks[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /** Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).  */
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        this.magnetronItemStacks[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
        {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    /** Returns the name of the inventory  */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.name : "container.magnetron";
    }

    /** Returns if the inventory is named */
    public boolean hasCustomInventoryName()
    {
        return this.name != null && this.name.length() > 0;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.magnetronItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.magnetronItemStacks.length)
            {
                this.magnetronItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.magnetronMagTime = nbt.getShort("MagTime");
        this.magnetronCurrentMagTime = nbt.getShort("CurrentMagTime");
        this.currentItemMagTime = getItemMagnetizationTime(this.magnetronItemStacks[1]);

        if (nbt.hasKey("CustomName", 8))
        {
            this.name = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setShort("MagTime", (short)this.magnetronMagTime);
        nbt.setShort("CurrentMagTime", (short)this.magnetronCurrentMagTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.magnetronItemStacks.length; ++i)
        {
            if (this.magnetronItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.magnetronItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            nbt.setString("CustomName", this.name);
        }
    }

    /** Returns the maximum stack size for a inventory slot. */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /** Returns an integer between 0 and the passed value representing how close the current item is to being completely cooked */
    @SideOnly(Side.CLIENT)
    public int getMagnetizeProgressScaled(int i)
    {
        return this.magnetronCurrentMagTime * i / 200;
    }

    /** Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel item, where 0 means that the item is
     * exhausted and the passed value means that the item is fresh */
    @SideOnly(Side.CLIENT)
    public int getMagnetizeTimeRemainingScaled(int i)
    {
        if (this.currentItemMagTime == 0)
        {
            this.currentItemMagTime = 200;
        }

        return this.magnetronMagTime * i / this.currentItemMagTime;
    }

    /**  isBurning */
    public boolean isMagnetizing()
    {
        return this.magnetronMagTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.magnetronMagTime > 0;
        boolean flag1 = false;

        if (this.magnetronMagTime > 0)
        {
        	if (magnetronItemStacks[0] != null) { // Freeze the fuel countdown when no item is being magnetized
        		this.magnetronMagTime--;
        	}
        }

        if (!this.worldObj.isRemote)
        {
            if (this.magnetronMagTime != 0 || this.magnetronItemStacks[1] != null && this.magnetronItemStacks[0] != null)
            {
                if (this.magnetronMagTime == 0 && this.canMagnetize())
                {
                    this.currentItemMagTime = this.magnetronMagTime = getItemMagnetizationTime(this.magnetronItemStacks[1]);

                    if (this.magnetronMagTime > 0)
                    {
                        flag1 = true;

                        if (this.magnetronItemStacks[1] != null)
                        {
                            this.magnetronItemStacks[1].stackSize--;

                            if (this.magnetronItemStacks[1].stackSize == 0)
                            {
                                this.magnetronItemStacks[1] = magnetronItemStacks[1].getItem().getContainerItem(magnetronItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isMagnetizing() && this.canMagnetize())
                {
                    this.magnetronCurrentMagTime ++;

                    if (this.magnetronCurrentMagTime == 200)
                    {
                        this.magnetronCurrentMagTime = 0;
                        this.magnetizeItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.magnetronCurrentMagTime = 0;
                }
            }

            if (flag != this.magnetronMagTime > 0)
            {
                flag1 = true;
                BlockMagnetron.updateMagnetronBlockState(this.magnetronMagTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    /** Returns true if the magnetron can mag an item, i.e. has a source item, destination stack isn't full, etc. */
    private boolean canMagnetize()
    {
        if (this.magnetronItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = MagnetronRecipes.magnetizing().getMagnetizationResult(this.magnetronItemStacks[0]);
            if (itemstack == null) return false;
            if (this.magnetronItemStacks[2] == null) return true;
            if (!this.magnetronItemStacks[2].isItemEqual(itemstack)) return false;
            int result = magnetronItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.magnetronItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /** Turn one item from the magnetron source stack into the appropriate smelted item in the magnetron result stack */
    public void magnetizeItem()
    {
        if (this.canMagnetize())
        {
            ItemStack itemstack = MagnetronRecipes.magnetizing().getMagnetizationResult(this.magnetronItemStacks[0]);

            if (this.magnetronItemStacks[2] == null)
            {
                this.magnetronItemStacks[2] = new ItemStack(itemstack.getItem(), 1).copy();
            }

            this.magnetronItemStacks[0].stackSize--; // TODO : Find out what the fuck is wrong with this
            System.out.println("Decreasing stack");

            if (this.magnetronItemStacks[0].stackSize <= 0)
            {
                this.magnetronItemStacks[0] = null;
            }
        }
    }

    /** Returns the number of ticks that the supplied fuel item will keep the magnetron working, or 0 if the item isn't fuel */
    public static int getItemMagnetizationTime(ItemStack itemstack)
    {
        if (itemstack == null)
        {
            return 0;
        }
        else
        {
            Item item = itemstack.getItem();

            String UN = itemstack.getUnlocalizedName();
			
			switch (UN) {
				case "item.item_coil_normal": return 1600;
				case "item.item_coil_magnetic": return 6400;
				default: return 0;
			}
        }
    }

    /** Returns the number of ticks that the supplied fuel item will keep the magnetron running, or 0 if the item isn't fuel */
    public static boolean isItemFuel(ItemStack itemstack)
    {
        return getItemMagnetizationTime(itemstack) > 0;
    }

    /** Do not make give this method the name canInteractWith because it clashes with Container */
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /** Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. */
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return i == 2 ? false : (i == 1 ? isItemFuel(itemstack) : true);
    }

    /** Returns an array containing the indices of the slots that can be accessed by automation on the given side of this block. */
    public int[] getAccessibleSlotsFromSide(int i)
    {
        return i == 0 ? slotsBottom : (i == 1 ? slotsTop : slotsSides);
    }

    /** Returns true if automation can insert the given item in the given slot from the given side. */
    public boolean canInsertItem(int slot, ItemStack itemstack, int side)
    {
        return this.isItemValidForSlot(slot, itemstack);
    }

    /** Returns true if automation can extract the given item in the given slot from the given side. */
    public boolean canExtractItem(int slot, ItemStack itemstack, int side)
    {
        return side != 0 || slot != 1;
    }
}