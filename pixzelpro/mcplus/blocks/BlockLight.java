package net.pixzelpro.mcplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.pixzelpro.mcplus.reference.RefStrings;

public class BlockLight extends Block {

	public BlockLight() {
		super(Material.glass);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setHardness(0.3F);
		this.setStepSound(soundTypeGlass);
		this.setLightLevel(1.0F);		
	}
}