package net.pixzelpro.mcplus.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.pixzelpro.mcplus.reference.RefStrings;

public class ItemQuiver extends Item {
	
	//TODO : On right click, open a GUI. Show the 2 arrows in the quiver, allowing the player to remove them or add more
	// Make sure to rewrite the NBT data!
	
	NBTTagCompound arrows;
	
	public ItemQuiver () {
		super();
		this.setCreativeTab(CreativeTabs.tabCombat);
		System.out.println("Set tab for item_quiver to 'Combat' tab");
		this.setTextureName(RefStrings.MODID + ":quiver-empty");
		this.setFull3D();
		this.setNoRepair();
		this.setMaxStackSize(1);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (arrows != null) {
			byte arrowCount = arrows.getByte("arrows");
			if (arrowCount < 25) {
				list.add(EnumChatFormatting.RED + "Arrows: " + arrowCount);
			} else if (arrowCount >= 25 && arrowCount < 50) {
				list.add(EnumChatFormatting.GOLD + "Arrows: " + arrowCount);
			} else if (arrowCount >= 50) {
				list.add(EnumChatFormatting.GREEN + "Arrows: " + arrowCount);
			} 
		} else {
			list.add(EnumChatFormatting.RED + "Arrows: 2");
		}
	}
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		super.onCreated(itemStack, world, player);
		if (arrows == null) {
			arrows = new NBTTagCompound();
			arrows.setByte("arrows", (byte)2);
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int int1, int int2, int int3, int int4,
			float int5, float int6, float int7) {
		
		byte arrowCount = arrows.getByte("arrows");
		byte newValue = arrowCount += 1;
		arrows.setByte("arrows", newValue);
		//TODO : Update the tooltip
		
		System.out.println("Added 1 arrow");
		
		return super.onItemUse(itemStack, player, world, int1, int2, int3, int4, int5, int6, int7);
	}
}