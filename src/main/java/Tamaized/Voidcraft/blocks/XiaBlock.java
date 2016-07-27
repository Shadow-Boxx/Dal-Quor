package Tamaized.Voidcraft.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import Tamaized.TamModized.blocks.TamBlockContainer;
import Tamaized.Voidcraft.voidCraft;
import Tamaized.Voidcraft.blocks.tileentity.TileEntityXiaCastle;

public class XiaBlock extends TamBlockContainer {

	public XiaBlock(String string) {
		super(null, Material.CLOTH, string, -1);
		setBlockUnbreakable();
	}
	
	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new TileEntityXiaCastle();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!worldIn.isRemote){
			TileEntity te = worldIn.getTileEntity(pos);
			if(te instanceof TileEntityXiaCastle) ((TileEntityXiaCastle) te).start();
		}
		return true;
	}
	
	@Override
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, placer);
    }

}
