package tamaized.voidcraft.common.machina.addons;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import tamaized.voidcraft.VoidCraft;

import javax.annotation.Nullable;

public class VoidTank extends FluidTank implements IFluidTank, IFluidHandler {

	public VoidTank(TileEntity te, int capacity) {
		super(new FluidStack(VoidCraft.fluids.voidFluid, 0), capacity);
		tile = te;
	}

	public VoidTank(@Nullable FluidStack fluidStack, int capacity) {
		super(fluidStack.getFluid() == VoidCraft.fluids.voidFluid ? fluidStack : null, capacity);
	}

	public VoidTank(Fluid fluid, int amount, int capacity) {
		this(new FluidStack(fluid, amount), capacity);
	}

	public boolean canFillFluidType(FluidStack fluid) {
		return canFill() ? fluid.getFluid() == VoidCraft.fluids.voidFluid : false;
	}
}