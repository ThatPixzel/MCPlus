package net.pixzelpro.mcplus.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.pixzelpro.mcplus.container.ContainerMagnetron;
import net.pixzelpro.mcplus.reference.RefStrings;
import net.pixzelpro.mcplus.tileentity.TileEntityMagnetron;

public class GuiMagnetron extends GuiContainer {
	
	public static final ResourceLocation bground = new ResourceLocation(RefStrings.MODID + ":" + "textures/gui/container/magnetizer.png");
	
	public TileEntityMagnetron magnetron;

	public GuiMagnetron(InventoryPlayer inventoryPlayer, TileEntityMagnetron entity) {
		super(new ContainerMagnetron(inventoryPlayer, entity));
		
		this.magnetron = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer (int par1, int par2) {
		String name = "Magnetizer";
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 5, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 80, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if (this.magnetron.isMagnetizing()) {
			// 29: GUI left, 65: GUI Top, 176: Bar Left, 0: Bar Top, 10: Bar Height
			int k = this.magnetron.getMagnetizeTimeRemainingScaled(40); // 40 = the width of the progress bar
			drawTexturedModalRect(guiLeft + 29, guiTop + 65, 176, 0, 40 - (40 - k), 10);
		}
		
		// 24: Arrow Width, 79: Arrow Left, 34: Arrow Top
		int k = this.magnetron.getMagnetizeProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 10, k + 1, 16);
	}
}