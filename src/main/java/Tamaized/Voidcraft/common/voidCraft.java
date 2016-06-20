package Tamaized.Voidcraft.common;

import java.util.ArrayList;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Tamaized.Voidcraft.Addons.AE2.voidCraftAE;
import Tamaized.Voidcraft.Addons.thaumcraft.VoidCraftThaum;
import Tamaized.Voidcraft.GUI.GuiHandler;
import Tamaized.Voidcraft.blocks.TileEntityNoBreak;
import Tamaized.Voidcraft.blocks.tileentity.TileEntityAIBlock;
import Tamaized.Voidcraft.blocks.tileentity.TileEntityXiaCastle;
import Tamaized.Voidcraft.capabilities.IVoidicInfusionCapability;
import Tamaized.Voidcraft.capabilities.VoidicInfusionCapabilityHandler;
import Tamaized.Voidcraft.capabilities.VoidicInfusionCapabilityStorage;
import Tamaized.Voidcraft.common.handlers.VoidCraftServerPacketHandler;
import Tamaized.Voidcraft.common.server.VoidCraftCommonProxy;
import Tamaized.Voidcraft.events.BlockBreakPlaceEvent;
import Tamaized.Voidcraft.events.DamageEvent;
import Tamaized.Voidcraft.events.PickUpEvent;
import Tamaized.Voidcraft.events.SpawnEvent;
import Tamaized.Voidcraft.events.VoidTickEvent;
import Tamaized.Voidcraft.handlers.CraftingHandler;
import Tamaized.Voidcraft.items.entity.EntityHookShot;
import Tamaized.Voidcraft.machina.addons.MaceratorRecipeList;
import Tamaized.Voidcraft.machina.tileentity.TileEntityHeimdall;
import Tamaized.Voidcraft.machina.tileentity.TileEntityVoidBox;
import Tamaized.Voidcraft.machina.tileentity.TileEntityVoidInfuser;
import Tamaized.Voidcraft.machina.tileentity.TileEntityVoidMacerator;
import Tamaized.Voidcraft.machina.tileentity.TileEntityVoidicPowerCable;
import Tamaized.Voidcraft.machina.tileentity.TileEntityVoidicPowerGen;
import Tamaized.Voidcraft.mobs.entity.EntityMobLich;
import Tamaized.Voidcraft.mobs.entity.EntityMobSpectreChain;
import Tamaized.Voidcraft.mobs.entity.EntityMobVoidWrath;
import Tamaized.Voidcraft.mobs.entity.EntityMobWraith;
import Tamaized.Voidcraft.mobs.entity.boss.EntityMobDol;
import Tamaized.Voidcraft.mobs.entity.boss.EntityMobHerobrine;
import Tamaized.Voidcraft.mobs.entity.boss.EntityMobVoidBoss;
import Tamaized.Voidcraft.mobs.entity.boss.EntityMobZol;
import Tamaized.Voidcraft.mobs.xia.EntityMobXia;
import Tamaized.Voidcraft.mobs.xia.EntityMobXia2;
import Tamaized.Voidcraft.projectiles.AcidBall;
import Tamaized.Voidcraft.projectiles.HerobrineFireball;
import Tamaized.Voidcraft.projectiles.VoidChain;
import Tamaized.Voidcraft.registry.Achievements;
import Tamaized.Voidcraft.registry.Armors;
import Tamaized.Voidcraft.registry.Biomes;
import Tamaized.Voidcraft.registry.LootTables;
import Tamaized.Voidcraft.registry.Materials;
import Tamaized.Voidcraft.registry.RegistryBase;
import Tamaized.Voidcraft.registry.Tabs;
import Tamaized.Voidcraft.registry.Tools;
import Tamaized.Voidcraft.registry.VoidBlocks;
import Tamaized.Voidcraft.registry.VoidFluids;
import Tamaized.Voidcraft.registry.VoidItems;
import Tamaized.Voidcraft.sound.BossMusicManager;
import Tamaized.Voidcraft.sound.VoidSoundEvents;
import Tamaized.Voidcraft.structures.StructureTestPieces;
import Tamaized.Voidcraft.structures.StructureTestStart;
import Tamaized.Voidcraft.voidicInfusion.VoidicInfusionHandler;
import Tamaized.Voidcraft.world.WorldGeneratorVoid;
import Tamaized.Voidcraft.world.dim.TheVoid.WorldProviderVoid;
import Tamaized.Voidcraft.world.dim.Xia.WorldProviderXia;

@Mod(modid=voidCraft.modid, name="VoidCraft", version=voidCraft.version)

public class voidCraft {
	
	protected final static String version = "0.7.3_DEV";
	public static final String modid = "voidcraft";
	
	public static String getVersion(){
		return version;
	}
	
	@Instance(modid) 
	public static voidCraft instance = new voidCraft();

	public static FMLEventChannel channel;
	public static final String networkChannelName = "VoidCraft";

	@SidedProxy(clientSide = "Tamaized.Voidcraft.common.client.VoidCraftClientProxy", serverSide = "Tamaized.Voidcraft.common.server.VoidCraftCommonProxy")
	public static VoidCraftCommonProxy proxy;

	public static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;

	public VoidTickEvent VoidTickEvent;
	
	public static VoidicInfusionHandler infusionHandler = new VoidicInfusionHandler();

	//Public API Integrations
	public static VoidCraftThaum thaumcraftIntegration;
	public static voidCraftAE aeIntegration;

	public static Materials materials = new Materials();
	public static Tabs tabs = new Tabs();
	public static Tools tools = new Tools();
	public static VoidItems items = new VoidItems();
	public static Armors armors = new Armors();
	public static VoidFluids fluids = new VoidFluids();
	public static VoidBlocks blocks = new VoidBlocks();
	public static Biomes biomes = new Biomes();
	public static Achievements achievements = new Achievements();
	public static LootTables lootTables = new LootTables();
	
	public static ArrayList<RegistryBase> registry = new ArrayList<RegistryBase>();

	public static final int dimensionIdVoid = -2;
	public static final int dimensionIdXia = -3;

	public static MaceratorRecipeList maceratorList = new MaceratorRecipeList();
	
	public static Logger logger;

	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = LogManager.getLogger("VoidCraft");
		
		logger.info("Uh oh, I guess we need to open a portal to the Void");
		logger.info("Starting VoidCraft PreInit");
	
		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(networkChannelName);
		
		registry.add(materials);
		registry.add(tabs);
		registry.add(tools);
		registry.add(items);
		registry.add(armors);
		registry.add(fluids);
		registry.add(blocks);
		registry.add(biomes);
		registry.add(achievements);
		registry.add(lootTables);

		VoidSoundEvents.register(); //Do this first in case the other registers need to grab a sound
		for(RegistryBase reg : registry) reg.preInit();
		
		//API Loader
		if (Loader.isModLoaded("Thaumcraft")) {
			//logger.info("Thaumcraft Detected. Attempting to load API");
			try {
				//thaumcraftIntegration = new VoidCraftThaum();
				//logger.info("Loaded ThaumcraftAPI into VoidCraft");
			}catch (Exception e1) {
				logger.info("Error while adding ThaumcraftAPI into VoidCraft");
				e1.printStackTrace(System.err);
			}
		}
		
		//if(thaumcraftIntegration != null) thaumcraftIntegration.preInit();
		
		System.out.println("registering Capabilities");
        CapabilityManager.INSTANCE.register(IVoidicInfusionCapability.class, new VoidicInfusionCapabilityStorage(), VoidicInfusionCapabilityHandler.class);
        MinecraftForge.EVENT_BUS.register(new Tamaized.Voidcraft.capabilities.EventHandler());
		
		proxy.preInit();
	}
	
	@EventHandler
	public void InitVoidCraft(FMLInitializationEvent event){ 
		logger.info("Starting VoidCraft Init");
		
		//Register Handlers into the Instance
		VoidTickEvent = new VoidTickEvent();
					
		//register GUI Handler
		//NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		//GuiHandler guiHandler = new GuiHandler();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		//Register Events
		MinecraftForge.EVENT_BUS.register(VoidTickEvent);
		MinecraftForge.EVENT_BUS.register(new PickUpEvent());
		MinecraftForge.EVENT_BUS.register(new SpawnEvent());
		MinecraftForge.EVENT_BUS.register(new CraftingHandler()); 
		MinecraftForge.EVENT_BUS.register(BossMusicManager.instance); //We want to give this class a tick updater
		MinecraftForge.EVENT_BUS.register(new BlockBreakPlaceEvent());
		MinecraftForge.EVENT_BUS.register(infusionHandler);
		MinecraftForge.EVENT_BUS.register(new DamageEvent());
				
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityVoidMacerator.class, "tileEntityVoidMacerator");
		GameRegistry.registerTileEntity(TileEntityVoidBox.class, "tileEntityVoidBox");
		GameRegistry.registerTileEntity(TileEntityVoidInfuser.class, "tileEntityVoidInfuser");
		GameRegistry.registerTileEntity(TileEntityHeimdall.class, "tileEntityHeimdall");
		GameRegistry.registerTileEntity(TileEntityNoBreak.class, "tileEntityNoBreak");
		GameRegistry.registerTileEntity(TileEntityAIBlock.class, "tileEntityAIBlock");
		GameRegistry.registerTileEntity(TileEntityXiaCastle.class, "tileEntityXiaCastle");
		GameRegistry.registerTileEntity(TileEntityVoidicPowerGen.class, "tileEntityVoidicPowerGen");
		GameRegistry.registerTileEntity(TileEntityVoidicPowerCable.class, "tileEntityVoidicPowerCable");
		
		for(RegistryBase reg : registry) reg.init();
		
		//Projectiles
		EntityRegistry.registerModEntity(VoidChain.class, "VoidChain", 0, this, 128, 1, true);
		EntityRegistry.registerModEntity(AcidBall.class, "AcidBall", 1, this, 128, 1, true);
		EntityRegistry.registerModEntity(EntityHookShot.class, "HookShot", 2, this, 128, 1, true);
		EntityRegistry.registerModEntity(HerobrineFireball.class, "HerobrineFireball", 3, this, 128, 1, true);

		//Dimension
		DimensionManager.registerDimension(dimensionIdVoid, DimensionType.register("The Void", "_void", dimensionIdVoid, WorldProviderVoid.class, false));
		DimensionManager.registerDimension(dimensionIdXia, DimensionType.register("???", "_xia", dimensionIdXia, WorldProviderXia.class, false));
		
		// World Gen
		GameRegistry.registerWorldGenerator(new WorldGeneratorVoid(), 0);
		
		MapGenStructureIO.registerStructure(StructureTestStart.class, "VoidFortress");
		StructureTestPieces.register();

		// Mobs
		EntityRegistry.registerModEntity(EntityMobWraith.class, "Wraith", 4, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobSpectreChain.class, "SpectreChain", 5, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobVoidWrath.class, "VoidWrath", 6, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobLich.class, "Lich", 7, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobVoidBoss.class, "VoidBoss", 8, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobHerobrine.class, "Herobrine", 9, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobDol.class, "Dol", 10, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobZol.class, "Zol", 11, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobXia.class, "Xia", 12, this, 64, 1, true);
		EntityRegistry.registerModEntity(EntityMobXia2.class, "Xia2", 13, this, 64, 1, true);
		
		EntityRegistry.registerEgg(EntityMobWraith.class, 0xFFFFFF, 0x000000);
		EntityRegistry.registerEgg(EntityMobSpectreChain.class, 0xFFFFFF, 0xAA0077);
		EntityRegistry.registerEgg(EntityMobVoidWrath.class, 0xFF0000, 0x000000);
		EntityRegistry.registerEgg(EntityMobLich.class, 0xAA00FF, 0x000000);
		EntityRegistry.registerEgg(EntityMobVoidBoss.class, 0x000000, 0xFF0000);
		EntityRegistry.registerEgg(EntityMobHerobrine.class, 0xFF0000, 0xFFAA00);
		EntityRegistry.registerEgg(EntityMobDol.class, 0xAAFF00, 0x000000);
		EntityRegistry.registerEgg(EntityMobZol.class, 0x00AAFF, 0x000000);
		EntityRegistry.registerEgg(EntityMobXia.class, 0xAA00FF, 0xFFFF00);
		EntityRegistry.registerEgg(EntityMobXia2.class, 0xAA00FF, 0xFFFF00);
		
		Biome.getBiome(6).getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(EntityMobLich.class, 10, 0, 1));
		
		//if(thaumcraftIntegration != null) thaumcraftIntegration.init();
		
		proxy.registerInventoryRender();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e){ 
		logger.info("Starting VoidCraft PostInit");
		
		for(RegistryBase reg : registry) reg.postInit();
		
		channel.register(new VoidCraftServerPacketHandler());
		proxy.registerNetwork();
		proxy.registerRenders();
		proxy.registerBlocks();
		proxy.registerRenderInformation();
		proxy.registerItems();
		proxy.registerMISC();
		proxy.registerAchievements();

		//if(thaumcraftIntegration != null) thaumcraftIntegration.postInit();
	}
}