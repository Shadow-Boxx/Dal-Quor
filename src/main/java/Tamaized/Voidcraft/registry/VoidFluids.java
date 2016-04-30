package Tamaized.Voidcraft.registry;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import Tamaized.Voidcraft.common.voidCraft;
import Tamaized.Voidcraft.fluid.BasicVoidFluidBlock;

public class VoidFluids extends RegistryBase {
	
	private static final ArrayList<BlockFluidBase> fluids = new ArrayList<BlockFluidBase>();
	
	public static Fluid voidFluid;
	
	public static MaterialLiquid voidMaterialLiquid;
	
	public static BlockFluidBase voidFluidBlock;
	
	public static Item voidBucket;

	@Override
	public void preInit() {
		//fluid -> fluid.setLuminosity(10).setDensity(800).setViscosity(1500),
		//, BasicVoidFluidBlock.class, new MaterialLiquid(MapColor.purpleColor)
		voidFluid = createFluid("void", "blocks/voidFluid", true);
		voidFluid.setLuminosity(3).setDensity(-400).setViscosity(1500).setGaseous(true);
		voidMaterialLiquid = new MaterialLiquid(MapColor.purpleColor);
		voidFluidBlock = new BasicVoidFluidBlock(voidFluid, voidMaterialLiquid, "blockVoidFluid");
		voidBucket = ForgeModContainer.getInstance().universalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, voidFluid).getItem();
		
		fluids.add(voidFluidBlock);
	}
	
	@Deprecated
	private void deprecated(){
		// Fluid
		//fluidVoid = new Fluid("void", new ResourceLocation("VoidCraft:textures/blocks/voidFluid_still.png"), new ResourceLocation("VoidCraft:textures/blocks/voidFluid_flow.png"));
		//materialFluidVoid = new MaterialLiquid(MapColor.purpleColor);
		// This has to be here for Fluids
		//FluidRegistry.registerFluid(fluidVoid);
		// This must be last
		//blockVoidFluid = new BlockVoidFluid(fluidVoid, Material.water).setDensity(-400).setUnlocalizedName("blockVoidFluid");
		//FluidRegistry.addBucketForFluid(fluidVoid);
		//voidBucket = new ItemVoidCraftBucket(blockVoidFluid).setUnlocalizedName("voidBucket").setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(voidCraft.tabs.tabVoid);
		//FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(fluidVoid.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(voidBucket), new ItemStack(Items.bucket)));
		//BucketHandler.INSTANCE.buckets.put(blockVoidFluid, voidBucket);
		//MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {

	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void setupRender() {
		
	}
	
	public void preInitRender(){
		for(BlockFluidBase f : fluids){
			Item fluid = Item.getItemFromBlock(f);
			final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(voidCraft.modid+":blocks/fluids", f.getFluid().getName());
			ModelBakery.registerItemVariants(fluid);
			ModelLoader.setCustomMeshDefinition(fluid, new ItemMeshDefinition()
	        {
	            public ModelResourceLocation getModelLocation(ItemStack stack)
	            {
	                return modelResourceLocation;
	            }
	        });
			ModelLoader.setCustomStateMapper(f, new StateMapperBase()
	        {
	            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
	            {
	                return modelResourceLocation;
	            }
	        });
		}
	}
	
	private static Fluid createFluid(String name, String textureName, boolean hasFlowIcon){
		ResourceLocation still = new ResourceLocation(voidCraft.modid, textureName + "_still");
		ResourceLocation flowing = hasFlowIcon ? new ResourceLocation(voidCraft.modid, textureName + "_flow") : still;
		System.out.println(still);
		Fluid fluid = new Fluid(name, still, flowing);
		if (!FluidRegistry.registerFluid(fluid)) fluid = FluidRegistry.getFluid(name);
		FluidRegistry.addBucketForFluid(fluid);
		return fluid;
	}
	
}
