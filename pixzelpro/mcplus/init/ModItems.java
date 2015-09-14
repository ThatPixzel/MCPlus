package net.pixzelpro.mcplus.init;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.pixzelpro.mcplus.items.ItemBar;
import net.pixzelpro.mcplus.items.ItemCoil;
import net.pixzelpro.mcplus.items.ItemMagnet;
import net.pixzelpro.mcplus.items.ItemMotor;
import net.pixzelpro.mcplus.items.ItemMotorCore;
import net.pixzelpro.mcplus.items.ItemQuiver;
import net.pixzelpro.mcplus.items.ItemRod;
import net.pixzelpro.mcplus.items.ItemWire;

public class ModItems {

	public static Item item_quiver;
	public static Item item_rod;
	public static Item item_bar;
	public static Item item_magnet;
	public static Item item_motor_core;
	public static Item item_motor;
	public static Item item_wire;
	public static Item item_coil;
	
	public static void initializeItems () {
		item_quiver = new ItemQuiver().setUnlocalizedName("item_quiver");
		item_rod = new ItemRod().setUnlocalizedName("item_rod");
		item_bar = new ItemBar().setUnlocalizedName("item_bar");
		item_magnet = new ItemMagnet().setUnlocalizedName("item_magnet");
		item_motor_core = new ItemMotorCore().setUnlocalizedName("item_motor_core");
		item_motor = new ItemMotor().setUnlocalizedName("item_motor");
		item_wire = new ItemWire().setUnlocalizedName("item_wire");
		item_coil = new ItemCoil().setUnlocalizedName("item_coil");
		
		LanguageRegistry.addName(new ItemStack(item_wire, 1, 0), "Electric Wire");
		LanguageRegistry.addName(new ItemStack(item_wire, 1, 1), "Electric Wire");
		LanguageRegistry.addName(new ItemStack(item_wire, 1, 2), "Electric Wire");
		LanguageRegistry.addName(new ItemStack(item_wire, 1, 3), "Electric Wire");
		
		LanguageRegistry.addName(new ItemStack(item_motor, 1, 0), "AC Motor");
		LanguageRegistry.addName(new ItemStack(item_motor, 1, 1), "DC Motor");
		
		LanguageRegistry.addName(new ItemStack(item_coil, 1, 0), "Coil");
		LanguageRegistry.addName(new ItemStack(item_coil, 1, 1), "Electromagnetic Coil");
	}
	
	public static void registerItems () {
		GameRegistry.registerItem(item_quiver, item_quiver.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_rod, item_rod.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_bar, item_bar.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_magnet, item_magnet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_motor_core, item_motor_core.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_motor, item_motor.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_wire, item_wire.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_coil, item_coil.getUnlocalizedName().substring(5));
	}
}