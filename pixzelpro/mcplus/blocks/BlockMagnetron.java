package net.pixzelpro.mcplus.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.pixzelpro.mcplus.init.ModBlocks;
import net.pixzelpro.mcplus.main.MainRegistry;
import net.pixzelpro.mcplus.reference.RefStrings;
import net.pixzelpro.mcplus.tabs.ModTabs;
import net.pixzelpro.mcplus.tileentity.TileEntityMagnetron;

public class BlockMagnetron extends BlockContainer {

	private final Random rand = new Random();
    private final boolean isActive;
    private static boolean keepInventory;
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;

    public BlockMagnetron(boolean active) {
        super(Material.rock);
        this.isActive = active;
        if (active == false) {
        	this.setCreativeTab(ModTabs.machineTab);
        }
        this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeMetal);
    }

    /** Defines the block which will be dropped when the block is broken */
    public Item getItemDropped(int par1, Random random, int par2)  {
        return Item.getItemFromBlock(ModBlocks.block_magnetron_idle);
    }

    /** Called whenever the block is added into the world. Args: world, x, y, z */
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    /** Sets the direction of the block when placed so that it faces the player */
    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j()) {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j()) {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j()) {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j()) {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    /** Gets the block's texture */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? this.top : (side == 0 ? this.top : (side != meta ? this.blockIcon : this.front));
    }

    /** Registers the block's texture */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":" + "block_magnetizer_side");
        this.front = iconRegister.registerIcon(this.isActive ? RefStrings.MODID + ":" + "block_magnetizer_front_active" : RefStrings.MODID + ":" + "block_magnetizer_front_idle");
        this.top = iconRegister.registerIcon(RefStrings.MODID + ":" + "block_magnetizer_top");
    }

    /** Called upon block activation (right click on the block.) */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4)
    {
    	if (!world.isRemote && !player.isSneaking()) {
			player.openGui(MainRegistry.instance, ModBlocks.gui_id_magnetron, world, x, y, z);
			return true;
		} else {
			return false;
		}
    }

    /** Update which block the magnetron is using depending on whether or not it is running */
    public static void updateMagnetronBlockState(boolean active, World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        keepInventory = true;

        if (active)
        {
            world.setBlock(x, y, z, ModBlocks.block_magnetron_active);
        }
        else
        {
            world.setBlock(x, y, z, ModBlocks.block_magnetron_idle);
        }

        keepInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    /** Returns a new instance of a block's tile entity class. Called on placing the block. */
    public TileEntity createNewTileEntity(World world, int par1)
    {
        return new TileEntityMagnetron();
    }

    /** Called when the block is placed in the world. */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack)
    {
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemstack.hasDisplayName())
        {
            ((TileEntityMagnetron)world.getTileEntity(x, y, z)).setName(itemstack.getDisplayName());
        }
    }

    /** When the block is broken, spew out all the items onto the ground */
    public void breakBlock(World world, int x, int y, int z, Block block, int par1)
    {
        if (!keepInventory)
        {
            TileEntityMagnetron tileentitymagnetron = (TileEntityMagnetron)world.getTileEntity(x, y, z);

            if (tileentitymagnetron != null)
            {
                for (int i1 = 0; i1 < tileentitymagnetron.getSizeInventory(); ++i1)
                {
                    ItemStack itemstack = tileentitymagnetron.getStackInSlot(i1);

                    if (itemstack != null)
                    {
                        float f = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int j1 = this.rand.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize)
                            {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, par1);
    }

    /** A randomly called display update to be able to add particles or other items for display */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (this.isActive)
        {
            int facing = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;

            if (facing == 4)
            {
                world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (facing == 5)
            {
                world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (facing == 2)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (facing == 3)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /** If this returns true, then comparators facing away from this block will use the value from getComparatorInputOverride instead of the actual redstone
        signal strength. */
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /** If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal strength when this block inputs to a
        comparator. */
    public int getComparatorInputOverride(World world, int x, int y, int z, int par1)
    {
        return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
    }

    /** Gets an item for the block being called on. Args: world, x, y, z  */
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(ModBlocks.block_magnetron_idle);
    }
}