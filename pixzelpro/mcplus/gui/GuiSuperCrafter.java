package net.pixzelpro.mcplus.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.pixzelpro.mcplus.container.ContainerSuperCrafter;
import net.pixzelpro.mcplus.reference.RefStrings;

public class GuiSuperCrafter extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":" + "textures/gui/container/super_crafter.png"); 
	
	public GuiSuperCrafter(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerSuperCrafter(invPlayer, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 188;
	}
	
	public void onGuiClosed () {
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer (int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Super Crafter"), 100, 5, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float float1, int int1, int int2) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}