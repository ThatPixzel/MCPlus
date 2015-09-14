package net.pixzelpro.mcplus.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.pixzelpro.mcplus.init.ModBlocks;
import net.pixzelpro.mcplus.init.ModItems;
import net.pixzelpro.mcplus.recipes.SuperCrafterCraftingManager;

public class ModCraftingManager {
	
	public static void registerRecipes () {
		// Quiver
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.item_quiver, 1), new Object[]{
				"LAL", "SAS", "LLL",
				'L', Items.leather,
				'S', Items.string,
				'A', Items.arrow});
		// Super Crafter
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.block_super_crafter, 1), new Object[]{
				"RLR", "CCC", "PPP",
				'R', Items.redstone,
				'L', new ItemStack(Items.dye, 1, 6),
				'C', Blocks.crafting_table,
				'P', Blocks.planks});
		// Lights
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.block_light_oak, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 0),
				'G', Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.block_light_birch, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 2),
				'G', Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.block_light_bigoak, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 5),
				'G', Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.block_light_spruce, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 1),
				'G', Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.block_light_jungle, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 3),
				'G', Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.block_light_acacia, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 4),
				'G', Blocks.glowstone});
		// Metal Rod
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.item_rod, 2), new Object[]{
				"I", "I",
				'I', Items.iron_ingot});
		// Electric Wire
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.item_wire, 3, 0), new Object[]{
				"I", "R", "I",
				'I', Items.gold_nugget,
				'R', Items.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.item_wire, 3, 1), new Object[]{ // Red wire
				new ItemStack(Items.dye, 1, 1),
				new ItemStack(ModItems.item_wire, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.item_wire, 3, 2), new Object[]{ // Black wire
				new ItemStack(Items.dye, 1, 0),
				new ItemStack(ModItems.item_wire, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.item_wire, 3, 3), new Object[]{ // Green wire
				new ItemStack(Items.dye, 1, 2),
				new ItemStack(ModItems.item_wire, 1, 0)});
		// Bar
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.item_bar, 2), new Object[]{
				"R", "R",
				'R', ModItems.item_rod});
	}
	
	public static void registerSuperRecipes (SuperCrafterCraftingManager manager) {
		// Quiver
		manager.addShapedRecipe(new ItemStack(ModItems.item_quiver, 1), new Object[]{
				"LAL", "SAS", "LLL",
				'L', Items.leather,
				'S', Items.string,
				'A', Items.arrow});
		// Super Crafter
		manager.addShapedRecipe(new ItemStack(ModBlocks.block_super_crafter, 1), new Object[]{
				"RLR", "CCC", "PPP",
				'R', Items.redstone,
				'L', new ItemStack(Items.dye, 1, 6),
				'C', Blocks.crafting_table,
				'P', Blocks.planks});
		// Lights
		manager.addShapedRecipe(new ItemStack(ModBlocks.block_light_oak, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 0),
				'G', Blocks.glowstone});
		manager.addShapedRecipe(new ItemStack(ModBlocks.block_light_birch, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 2),
				'G', Blocks.glowstone});
		manager.addShapedRecipe(new ItemStack(ModBlocks.block_light_bigoak, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 5),
				'G', Blocks.glowstone});
		manager.addShapedRecipe(new ItemStack(ModBlocks.block_light_spruce, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 1),
				'G', Blocks.glowstone});
		manager.addShapedRecipe(new ItemStack(ModBlocks.block_light_jungle, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 3),
				'G', Blocks.glowstone});
		manager.addShapedRecipe(new ItemStack(ModBlocks.block_light_acacia, 8), new Object[]{
				"PPP", "PGP", "PPP",
				'P', new ItemStack(Blocks.planks, 1, 4),
				'G', Blocks.glowstone});
		// Metal Rod
		manager.addShapedRecipe(new ItemStack(ModItems.item_rod, 2), new Object[]{
				"I", "I",
				'I', Items.iron_ingot});
		// Electric Wire
		manager.addShapedRecipe(new ItemStack(ModItems.item_wire, 3, 0), new Object[]{
				"I", "R", "I",
				'I', Items.gold_nugget,
				'R', Items.redstone});
		manager.addShapelessRecipe(new ItemStack(ModItems.item_wire, 3, 1), new Object[]{ // Red wire
				new ItemStack(Items.dye, 1, 1),
				new ItemStack(ModItems.item_wire, 1, 0)});
		manager.addShapelessRecipe(new ItemStack(ModItems.item_wire, 3, 2), new Object[]{ // Black wire
				new ItemStack(Items.dye, 1, 0),
				new ItemStack(ModItems.item_wire, 1, 0)});
		manager.addShapelessRecipe(new ItemStack(ModItems.item_wire, 3, 3), new Object[]{ // Green wire
				new ItemStack(Items.dye, 1, 2),
				new ItemStack(ModItems.item_wire, 1, 0)});
		// Motor Core
		manager.addShapedRecipe(new ItemStack(ModItems.item_motor_core, 1), new Object[]{
				"  M  ", " MWM ", "  R  ", "MW WM", "MM MM",
				'M', ModItems.item_magnet,
				'W', new ItemStack(ModItems.item_wire, 1, 0),
				'R', ModItems.item_rod});
		manager.addShapedRecipe(new ItemStack(ModItems.item_motor_core, 1), new Object[]{
				"  M  ", " MWM ", "  R  ", "MW WM", "MM MM",
				'M', ModItems.item_magnet,
				'W', new ItemStack(ModItems.item_wire, 1, 3),
				'R', ModItems.item_rod});
		// Motor (AC)
		manager.addShapedRecipe(new ItemStack(ModItems.item_motor, 1, 0), new Object[]{
				"IIRII", "IDRDI", "IMCMI", "IWRWI", "NIIIN",
				'I', Items.iron_ingot,
				'W', new ItemStack(ModItems.item_wire, 1, 0),
				'R', ModItems.item_rod,
				'D', Items.redstone,
				'M', ModItems.item_magnet,
				'C', ModItems.item_motor_core,
				'N', Items.gold_nugget});
		manager.addShapedRecipe(new ItemStack(ModItems.item_motor, 1, 0), new Object[]{
				"IIRII", "IDRDI", "IMCMI", "IWRWI", "NIIIN",
				'I', Items.iron_ingot,
				'W', new ItemStack(ModItems.item_wire, 1, 3),
				'R', ModItems.item_rod,
				'D', Items.redstone,
				'M', ModItems.item_magnet,
				'C', ModItems.item_motor_core,
				'N', Items.gold_nugget});
		manager.addShapedRecipe(new ItemStack(ModItems.item_motor, 1, 0), new Object[]{
				"IIRII", "IDRDI", "IMCMI", "IERWI", "NIIIN",
				'I', Items.iron_ingot,
				'W', new ItemStack(ModItems.item_wire, 1, 0),
				'E', new ItemStack(ModItems.item_wire, 1, 3),
				'R', ModItems.item_rod,
				'D', Items.redstone,
				'M', ModItems.item_magnet,
				'C', ModItems.item_motor_core,
				'N', Items.gold_nugget});
		manager.addShapedRecipe(new ItemStack(ModItems.item_motor, 1, 0), new Object[]{
				"IIRII", "IDRDI", "IMCMI", "IWREI", "NIIIN",
				'I', Items.iron_ingot,
				'W', new ItemStack(ModItems.item_wire, 1, 0),
				'E', new ItemStack(ModItems.item_wire, 1, 3),
				'R', ModItems.item_rod,
				'D', Items.redstone,
				'M', ModItems.item_magnet,
				'C', ModItems.item_motor_core,
				'N', Items.gold_nugget});
		// Motor (DC)
		manager.addShapedRecipe(new ItemStack(ModItems.item_motor, 1, 1), new Object[]{
				"IIRII", "IDRDI", "IMCMI", "IWREI", "NIIIN",
				'I', Items.iron_ingot,
				'W', new ItemStack(ModItems.item_wire, 1, 1),
				'E', new ItemStack(ModItems.item_wire, 1, 2),
				'R', ModItems.item_rod,
				'D', Items.redstone,
				'M', ModItems.item_magnet,
				'C', ModItems.item_motor_core,
				'N', Items.gold_nugget});
		manager.addShapedRecipe(new ItemStack(ModItems.item_motor, 1, 1), new Object[]{
				"IIRII", "IDRDI", "IMCMI", "IERWI", "NIIIN",
				'I', Items.iron_ingot,
				'W', new ItemStack(ModItems.item_wire, 1, 1),
				'E', new ItemStack(ModItems.item_wire, 1, 2),
				'R', ModItems.item_rod,
				'D', Items.redstone,
				'M', ModItems.item_magnet,
				'C', ModItems.item_motor_core,
				'N', Items.gold_nugget});
		// Coil
		manager.addShapedRecipe(new ItemStack(ModItems.item_coil, 1), new Object[]{
				"WRW", "WRW", "WRW", "WRW", "WRW",
				'W', ModItems.item_wire,
				'R', ModItems.item_rod});
		// Bar
		manager.addShapedRecipe(new ItemStack(ModItems.item_bar, 2), new Object[]{
				"R", "R",
				'R', ModItems.item_rod});
	}
}