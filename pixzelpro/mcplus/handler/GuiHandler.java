package net.pixzelpro.mcplus.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.pixzelpro.mcplus.container.ContainerMagnetron;
import net.pixzelpro.mcplus.container.ContainerSuperCrafter;
import net.pixzelpro.mcplus.gui.GuiMagnetron;
import net.pixzelpro.mcplus.gui.GuiSuperCrafter;
import net.pixzelpro.mcplus.init.ModBlocks;
import net.pixzelpro.mcplus.tileentity.TileEntityMagnetron;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null) {
			switch (ID) {
			case ModBlocks.gui_id_magnetron:
				if (entity instanceof TileEntityMagnetron) {
					return new ContainerMagnetron(player.inventory, (TileEntityMagnetron)entity);
				}
				return null;
			case ModBlocks.gui_id_super_crafter:
				return ID == ModBlocks.gui_id_super_crafter && world.getBlock(x, y, z) == ModBlocks.block_super_crafter ? new ContainerSuperCrafter(player.inventory, world, x, y, z) : null;
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {	
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null) {
			switch (ID) {
			case ModBlocks.gui_id_magnetron:
				if (entity instanceof TileEntityMagnetron) {
					return new GuiMagnetron(player.inventory, (TileEntityMagnetron)entity);
				}
				return null;
			case ModBlocks.gui_id_super_crafter:
				return ID == ModBlocks.gui_id_super_crafter && world.getBlock(x, y, z) == ModBlocks.block_super_crafter ? new GuiSuperCrafter(player.inventory, world, x, y, z) : null;
			}
		}
		
		return null;
	}
}