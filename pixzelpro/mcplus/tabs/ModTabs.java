package net.pixzelpro.mcplus.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.pixzelpro.mcplus.init.ModItems;

public class ModTabs {

	public static CreativeTabs machineTab = new CreativeTabs("Machines") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ModItems.item_motor;
		}
	};
	
	public static CreativeTabs electronicTab = new CreativeTabs("Electronics") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ModItems.item_wire;
		}
	};
}