package net.pixzelpro.mcplus.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.pixzelpro.mcplus.reference.RefStrings;
import net.pixzelpro.mcplus.tabs.ModTabs;

public class ItemMotorCore extends Item {

	public ItemMotorCore () {
		super();
		this.setTextureName(RefStrings.MODID + ":motor_core");
		this.setCreativeTab(ModTabs.electronicTab);
		System.out.println("Set tab for item_motor_core to 'Electronics' tab");
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		list.add(EnumChatFormatting.BLUE + "The heart of the motor");
	}
}