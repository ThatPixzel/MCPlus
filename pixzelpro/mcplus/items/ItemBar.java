package net.pixzelpro.mcplus.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.pixzelpro.mcplus.reference.RefStrings;

public class ItemBar extends Item {

	public ItemBar () {
		super();
		this.setTextureName(RefStrings.MODID + ":bar");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		System.out.println("Set tab for item_bar to 'Materials' tab");
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		list.add(EnumChatFormatting.BLUE + "Turn this into a magnet by placing it in a Magnetizer");
	}
}