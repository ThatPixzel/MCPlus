package net.pixzelpro.mcplus.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.pixzelpro.mcplus.init.ModBlocks;
import net.pixzelpro.mcplus.main.MainRegistry;
import net.pixzelpro.mcplus.reference.RefStrings;

public class BlockSuperCrafter extends Block {
	
	@SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;

	public BlockSuperCrafter() {
		super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockTextureName(RefStrings.MODID + ":block_super_crafter");
		this.setHardness(3.5F);
		this.setResistance(5.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
	    return side == 1 ? this.top : (side == 0 ? Blocks.planks.getBlockTextureFromSide(side) : (side != 2 && side != 4 ? this.blockIcon : this.front));
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iIconRegister)
	{
	    this.blockIcon = iIconRegister.registerIcon(this.getTextureName() + "_side");
	    this.top = iIconRegister.registerIcon(this.getTextureName() + "_top");
	    this.front = iIconRegister.registerIcon(this.getTextureName() + "_side");
	}
	
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
		if (!world.isRemote && !player.isSneaking()) {
			player.openGui(MainRegistry.instance, ModBlocks.gui_id_super_crafter, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}
}