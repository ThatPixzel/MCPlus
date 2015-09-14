package net.pixzelpro.mcplus.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.pixzelpro.mcplus.reference.RefStrings;
import net.pixzelpro.mcplus.tabs.ModTabs;

public class ItemMotor extends Item {

	public ItemMotor () {
		super();
		this.setHasSubtypes(true);
		this.setCreativeTab(ModTabs.electronicTab);
		System.out.println("Set tab for item_motor to 'Electronics' tab");
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		list.add(EnumChatFormatting.BLUE + "You spin me right round baby");
		String un = getUnlocalizedName(itemStack);
		switch (un) {
			case "item.item_motor_ac": list.add(EnumChatFormatting.BLUE + "AC - Spins both ways"); break;
			case "item.item_motor_dc": list.add(EnumChatFormatting.BLUE + "DC - Only spins one way"); break;
			default: list.add(EnumChatFormatting.RED + "ERROR"); break;
		}
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon icon;
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		icon = iconRegister.registerIcon(RefStrings.MODID + ":motor");
	}
	
	public static final String[] names = new String[] {"ac", "dc"};
	
	public String getUnlocalizedName (ItemStack itemStack) {
		int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "_" + names[i];
	}
	
	public IIcon getIconFromDamage (int par1) {
		return icon;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTab, List list) {
		super.getSubItems(item, creativeTab, list);
		list.add(new ItemStack(item, 1, 1));
	}
}