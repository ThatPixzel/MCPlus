package net.pixzelpro.mcplus.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.pixzelpro.mcplus.blocks.BlockLight;
import net.pixzelpro.mcplus.blocks.BlockMagnetron;
import net.pixzelpro.mcplus.blocks.BlockReversalTable;
import net.pixzelpro.mcplus.blocks.BlockSuperCrafter;
import net.pixzelpro.mcplus.reference.RefStrings;

public class ModBlocks {

	public static Block block_reversal_table;
	public static final int gui_id_reversal_table = 0;
	
	public static Block block_super_crafter;
	public static final int gui_id_super_crafter = 1;
	
	public static Block block_magnetron_idle;
	public static Block block_magnetron_active;
	public static final int gui_id_magnetron = 2;
	
	public static Block block_light_oak;
	public static Block block_light_birch;
	public static Block block_light_spruce;
	public static Block block_light_bigoak;
	public static Block block_light_jungle;
	public static Block block_light_acacia;
	
	public static void initializeBlocks () {
		block_reversal_table = new BlockReversalTable().setBlockName("block_reversal_table");
		block_super_crafter = new BlockSuperCrafter().setBlockName("block_super_crafter");
		block_light_oak = new BlockLight().setBlockName("block_light_oak").setBlockTextureName(RefStrings.MODID + ":" + "block_light_oak");
		block_light_birch = new BlockLight().setBlockName("block_light_birch").setBlockTextureName(RefStrings.MODID + ":" + "block_light_birch");
		block_light_spruce = new BlockLight().setBlockName("block_light_spruce").setBlockTextureName(RefStrings.MODID + ":" + "block_light_spruce");
		block_light_bigoak = new BlockLight().setBlockName("block_light_bigoak").setBlockTextureName(RefStrings.MODID + ":" + "block_light_bigoak");
		block_light_jungle = new BlockLight().setBlockName("block_light_jungle").setBlockTextureName(RefStrings.MODID + ":" + "block_light_jungle");
		block_light_acacia = new BlockLight().setBlockName("block_light_acacia").setBlockTextureName(RefStrings.MODID + ":" + "block_light_acacia");
		
		block_magnetron_idle = new BlockMagnetron(false).setBlockName("block_magnetron_idle");
		block_magnetron_active = new BlockMagnetron(true).setBlockName("block_magnetron_active");
	}
	
	public static void registerBlocks () {
		GameRegistry.registerBlock(block_reversal_table, block_reversal_table.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_super_crafter, block_super_crafter.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_light_oak, block_light_oak.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_light_birch, block_light_birch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_light_spruce, block_light_spruce.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_light_bigoak, block_light_bigoak.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_light_jungle, block_light_jungle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_light_acacia, block_light_acacia.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_magnetron_idle, block_magnetron_idle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block_magnetron_active, block_magnetron_active.getUnlocalizedName().substring(5));
	}
}