package net.pixzelpro.mcplus.main;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.pixzelpro.mcplus.crafting.ModCraftingManager;
import net.pixzelpro.mcplus.handler.CraftingHandler;
import net.pixzelpro.mcplus.handler.GuiHandler;
import net.pixzelpro.mcplus.init.ModBlocks;
import net.pixzelpro.mcplus.init.ModItems;
import net.pixzelpro.mcplus.proxy.CommonProxy;
import net.pixzelpro.mcplus.reference.RefStrings;
import net.pixzelpro.mcplus.tileentity.TileEntityMagnetron;

@Mod (modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION)
public class MainRegistry {
	
	@Instance(RefStrings.MODID)
	public static MainRegistry instance;
	
	@SidedProxy(clientSide = "net.pixzelpro.mcplus.proxy.ClientProxy", serverSide = "net.pixzelpro.mcplus.proxy.CommonProxy")
	public static CommonProxy mcplusProxy;

	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		// Item / block initialization & registering, config handling
		
		System.out.println("Initializing Items");
		ModItems.initializeItems();
		System.out.println("Registering Items");
		ModItems.registerItems();
		System.out.println("Initializing Blocks");
		ModBlocks.initializeBlocks();
		System.out.println("Registering Blocks");
		ModBlocks.registerBlocks();
		System.out.println("Registering Recipes");
		ModCraftingManager.registerRecipes();
	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {
		// Proxies, TileEntities, Entities, GUI & Packet registering
		System.out.println("Registering Handlers (Crafting & GUI");
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		System.out.println("Registering TileEntities");
		GameRegistry.registerTileEntity(TileEntityMagnetron.class, "tileentity_magnetron");
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		
	}
}