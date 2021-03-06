package tamaized.dalquor.registry;

import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tamaized.tammodized.common.armors.TamArmor;
import tamaized.tammodized.registry.ITamRegistry;
import tamaized.dalquor.common.armor.XiaArmor;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ModArmors {

	public static List<ITamRegistry> modelList;

	public static TamArmor voidHelmet;
	public static TamArmor voidChest;
	public static TamArmor voidLegs;
	public static TamArmor voidBoots;
	public static XiaArmor xiaHelmet;
	public static XiaArmor xiaChest;
	public static XiaArmor xiaLegs;
	public static XiaArmor xiaBoots;
	// public static ArmorCustomElytra elytra;

	static {
		modelList = new ArrayList<>();

		modelList.add(voidHelmet = new TamArmor(ModCreativeTabs.tabVoid, ModMaterials.voidArmor, 0, EntityEquipmentSlot.HEAD, "void", "voidhelmet"));
		modelList.add(voidChest = new TamArmor(ModCreativeTabs.tabVoid, ModMaterials.voidArmor, 0, EntityEquipmentSlot.CHEST, "void", "voidchest"));
		modelList.add(voidLegs = new TamArmor(ModCreativeTabs.tabVoid, ModMaterials.voidArmor, 0, EntityEquipmentSlot.LEGS, "void", "voidlegs"));
		modelList.add(voidBoots = new TamArmor(ModCreativeTabs.tabVoid, ModMaterials.voidArmor, 0, EntityEquipmentSlot.FEET, "void", "voidboots"));

		modelList.add(xiaHelmet = new XiaArmor(ModCreativeTabs.tabVoid, ModMaterials.xiaArmor, 0, EntityEquipmentSlot.HEAD, "xia", "xiahelmet"));
		modelList.add(xiaChest = new XiaArmor(ModCreativeTabs.tabVoid, ModMaterials.xiaArmor, 0, EntityEquipmentSlot.CHEST, "xia", "xiachest"));
		modelList.add(xiaLegs = new XiaArmor(ModCreativeTabs.tabVoid, ModMaterials.xiaArmor, 0, EntityEquipmentSlot.LEGS, "xia", "xialegs"));
		modelList.add(xiaBoots = new XiaArmor(ModCreativeTabs.tabVoid, ModMaterials.xiaArmor, 0, EntityEquipmentSlot.FEET, "xia", "xiaboots"));

		// modelList.add(elytra = new ArmorCustomElytra(voidCraft.tabs.tabVoid, voidCraft.materials.voidArmor, 0, EntityEquipmentSlot.CHEST, "void", "voidElytra"));
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		for (ITamRegistry b : modelList)
			b.registerBlock(event);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (ITamRegistry b : modelList)
			b.registerItem(event);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		for (ITamRegistry model : modelList)
			model.registerModel(event);
	}

}
