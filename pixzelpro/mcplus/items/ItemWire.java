package net.pixzelpro.mcplus.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.pixzelpro.mcplus.init.ModItems;
import net.pixzelpro.mcplus.reference.RefStrings;
import net.pixzelpro.mcplus.tabs.ModTabs;

public class ItemWire extends Item {
	
	public ItemWire () {
		super();
		this.setHasSubtypes(true);
		this.setCreativeTab(ModTabs.electronicTab);
		System.out.println("Set tab for item_wire to 'Electronics' tab");
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		list.add(EnumChatFormatting.BLUE + "Connects electrical items");
		String un = getUnlocalizedName(itemStack);
		switch (un) {
			case "item.item_wire_white": list.add(EnumChatFormatting.WHITE + "White (Neutral)"); break;
			case "item.item_wire_red": list.add(EnumChatFormatting.RED + "Red (Positive)"); break;
			case "item.item_wire_black": list.add(EnumChatFormatting.DARK_GRAY+ "Black (Negative)"); break;
			case "item.item_wire_green": list.add(EnumChatFormatting.GREEN + "Green (Neutral)"); break;
			default: list.add(EnumChatFormatting.RED + "ERROR"); break;
		}
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		icons = new IIcon[4];
		icons[0] = iconRegister.registerIcon(RefStrings.MODID + ":wire_0");
		icons[1] = iconRegister.registerIcon(RefStrings.MODID + ":wire_1");
		icons[2] = iconRegister.registerIcon(RefStrings.MODID + ":wire_2");
		icons[3] = iconRegister.registerIcon(RefStrings.MODID + ":wire_3");
	}
	
	public static final String[] names = new String[] {"white", "red", "black", "green"};
	
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
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 3));
	}
}