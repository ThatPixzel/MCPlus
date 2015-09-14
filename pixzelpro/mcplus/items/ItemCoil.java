package net.pixzelpro.mcplus.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.pixzelpro.mcplus.init.ModItems;
import net.pixzelpro.mcplus.reference.RefStrings;
import net.pixzelpro.mcplus.tabs.ModTabs;

public class ItemCoil extends Item{

	public ItemCoil () {
		super();
		this.setHasSubtypes(true);
		this.setCreativeTab(ModTabs.electronicTab);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		list.add(EnumChatFormatting.BLUE + "Used in a Magnetizer");
		String un = getUnlocalizedName(itemStack);
		switch (un) {
			case "item.item_coil_normal": list.add(EnumChatFormatting.BLUE + "Magnetizes 8 items"); break;
			case "item.item_coil_magnetic": list.add(EnumChatFormatting.GOLD + "Magnetizes 32 items"); break;
			default: list.add(EnumChatFormatting.RED + "ERROR"); break;
		}
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		icons = new IIcon[2];
		icons[0] = iconRegister.registerIcon(RefStrings.MODID + ":coil_0");
		icons[1] = iconRegister.registerIcon(RefStrings.MODID + ":coil_1");
	}
	
	public static final String[] names = new String[] {"normal", "magnetic"};
	
	public String getUnlocalizedName (ItemStack itemStack) {
		int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "_" + names[i];
	}
	
	public IIcon getIconFromDamage (int par1) {
		return icons[par1];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTab, List list) {
		super.getSubItems(item, creativeTab, list);
		list.add(new ItemStack(item, 1, 1));
	}
}