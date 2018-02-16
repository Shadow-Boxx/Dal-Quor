package tamaized.dalquor.common.structures.voidfortress;

import com.google.common.collect.Lists;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import tamaized.dalquor.VoidCraft;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class StructureVoidFortressPieces {

	private static final StructureVoidFortressPieces.PieceWeight[] PRIMARY_COMPONENTS = new StructureVoidFortressPieces.PieceWeight[]{new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Straight.class, 30, 0, true), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Crossing3.class, 10, 4), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Crossing.class, 10, 4), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Stairs.class, 10, 3), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Throne.class, 5, 2), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Entrance.class, 5, 1)};
	private static final StructureVoidFortressPieces.PieceWeight[] SECONDARY_COMPONENTS = new StructureVoidFortressPieces.PieceWeight[]{new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Corridor5.class, 25, 0, true), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Crossing2.class, 15, 5), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Corridor2.class, 5, 10), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Corridor.class, 5, 10), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Corridor3.class, 10, 3, true), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.Corridor4.class, 7, 2), new StructureVoidFortressPieces.PieceWeight(StructureVoidFortressPieces.NetherStalkRoom.class, 5, 2)};

	public static void registerNetherFortressPieces() {
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Crossing3.class, "VFNeBCr");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.End.class, "VFNeBEF");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Straight.class, "VFNeBS");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Corridor3.class, "VFNeCCS");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Corridor4.class, "VFNeCTB");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Entrance.class, "VFNeCE");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Crossing2.class, "VFNeSCSC");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Corridor.class, "VFNeSCLT");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Corridor5.class, "VFNeSC");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Corridor2.class, "VFNeSCRT");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.NetherStalkRoom.class, "VFNeCSR");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Throne.class, "VFNeMT");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Crossing.class, "VFNeRC");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Stairs.class, "VFNeSR");
		MapGenStructureIO.registerStructureComponent(StructureVoidFortressPieces.Start.class, "VFNeStart");
	}

	private static StructureVoidFortressPieces.Piece findAndCreateBridgePieceFactory(StructureVoidFortressPieces.PieceWeight p_175887_0_, List<StructureComponent> p_175887_1_, Random p_175887_2_, int p_175887_3_, int p_175887_4_, int p_175887_5_, EnumFacing p_175887_6_, int p_175887_7_) {
		Class<? extends StructureVoidFortressPieces.Piece> oclass = p_175887_0_.weightClass;
		StructureVoidFortressPieces.Piece structurenetherbridgepieces$piece = null;

		if (oclass == StructureVoidFortressPieces.Straight.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Straight.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Crossing3.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Crossing3.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Crossing.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Crossing.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Stairs.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Stairs.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_7_, p_175887_6_);
		} else if (oclass == StructureVoidFortressPieces.Throne.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Throne.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_7_, p_175887_6_);
		} else if (oclass == StructureVoidFortressPieces.Entrance.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Entrance.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Corridor5.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Corridor5.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Corridor2.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Corridor2.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Corridor.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Corridor.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Corridor3.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Corridor3.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Corridor4.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Corridor4.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.Crossing2.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.Crossing2.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		} else if (oclass == StructureVoidFortressPieces.NetherStalkRoom.class) {
			structurenetherbridgepieces$piece = StructureVoidFortressPieces.NetherStalkRoom.createPiece(p_175887_1_, p_175887_2_, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_6_, p_175887_7_);
		}

		return structurenetherbridgepieces$piece;
	}

	public static class Corridor extends StructureVoidFortressPieces.Piece {
		private boolean chest;

		public Corridor() {
		}

		public Corridor(int p_i45615_1_, Random p_i45615_2_, StructureBoundingBox p_i45615_3_, EnumFacing p_i45615_4_) {
			super(p_i45615_1_);
			this.setCoordBaseMode(p_i45615_4_);
			this.boundingBox = p_i45615_3_;
			this.chest = p_i45615_2_.nextInt(3) == 0;
		}

		/**
		 * (abstract) Helper method to read subclass data from NBT
		 */
		@Override
		protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {
			super.readStructureFromNBT(tagCompound, p_143011_2_);
			this.chest = tagCompound.getBoolean("Chest");
		}

		/**
		 * (abstract) Helper method to write subclass data to NBT
		 */
		@Override
		protected void writeStructureToNBT(NBTTagCompound tagCompound) {
			super.writeStructureToNBT(tagCompound);
			tagCompound.setBoolean("Chest", this.chest);
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentX((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 0, 1, true);
		}

		public static StructureVoidFortressPieces.Corridor createPiece(List<StructureComponent> p_175879_0_, Random p_175879_1_, int p_175879_2_, int p_175879_3_, int p_175879_4_, EnumFacing p_175879_5_, int p_175879_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175879_2_, p_175879_3_, p_175879_4_, -1, 0, 0, 5, 7, 5, p_175879_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175879_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Corridor(p_175879_6_, p_175879_1_, structureboundingbox, p_175879_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 4, 5, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 1, 4, 4, 1, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 3, 4, 4, 3, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 5, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 3, 5, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 4, 1, 4, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 3, 4, 3, 4, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			if (this.chest && structureBoundingBoxIn.isVecInside(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
				this.chest = false;
				this.generateChest(worldIn, structureBoundingBoxIn, randomIn, 3, 2, 3, VoidCraft.lootTables.chest_voidFortress);
			}

			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 4, 6, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int i = 0; i <= 4; ++i) {
				for (int j = 0; j <= 4; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class Corridor2 extends StructureVoidFortressPieces.Piece {
		private boolean chest;

		public Corridor2() {
		}

		public Corridor2(int p_i45613_1_, Random p_i45613_2_, StructureBoundingBox p_i45613_3_, EnumFacing p_i45613_4_) {
			super(p_i45613_1_);
			this.setCoordBaseMode(p_i45613_4_);
			this.boundingBox = p_i45613_3_;
			this.chest = p_i45613_2_.nextInt(3) == 0;
		}

		/**
		 * (abstract) Helper method to read subclass data from NBT
		 */
		@Override
		protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {
			super.readStructureFromNBT(tagCompound, p_143011_2_);
			this.chest = tagCompound.getBoolean("Chest");
		}

		/**
		 * (abstract) Helper method to write subclass data to NBT
		 */
		@Override
		protected void writeStructureToNBT(NBTTagCompound tagCompound) {
			super.writeStructureToNBT(tagCompound);
			tagCompound.setBoolean("Chest", this.chest);
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentZ((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 0, 1, true);
		}

		public static StructureVoidFortressPieces.Corridor2 createPiece(List<StructureComponent> p_175876_0_, Random p_175876_1_, int p_175876_2_, int p_175876_3_, int p_175876_4_, EnumFacing p_175876_5_, int p_175876_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175876_2_, p_175876_3_, p_175876_4_, -1, 0, 0, 5, 7, 5, p_175876_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175876_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Corridor2(p_175876_6_, p_175876_1_, structureboundingbox, p_175876_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 5, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 1, 0, 4, 1, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 3, 0, 4, 3, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 4, 5, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 4, 4, 5, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 4, 1, 4, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 3, 4, 3, 4, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			if (this.chest && structureBoundingBoxIn.isVecInside(new BlockPos(this.getXWithOffset(1, 3), this.getYWithOffset(2), this.getZWithOffset(1, 3)))) {
				this.chest = false;
				this.generateChest(worldIn, structureBoundingBoxIn, randomIn, 1, 2, 3, VoidCraft.lootTables.chest_voidFortress);
			}

			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 4, 6, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int i = 0; i <= 4; ++i) {
				for (int j = 0; j <= 4; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class Corridor3 extends StructureVoidFortressPieces.Piece {
		public Corridor3() {
		}

		public Corridor3(int p_i45619_1_, Random p_i45619_2_, StructureBoundingBox p_i45619_3_, EnumFacing p_i45619_4_) {
			super(p_i45619_1_);
			this.setCoordBaseMode(p_i45619_4_);
			this.boundingBox = p_i45619_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 1, 0, true);
		}

		public static StructureVoidFortressPieces.Corridor3 createPiece(List<StructureComponent> p_175883_0_, Random p_175883_1_, int p_175883_2_, int p_175883_3_, int p_175883_4_, EnumFacing p_175883_5_, int p_175883_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175883_2_, p_175883_3_, p_175883_4_, -1, -7, 0, 5, 14, 10, p_175883_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175883_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Corridor3(p_175883_6_, p_175883_1_, structureboundingbox, p_175883_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			IBlockState iblockstate = VoidCraft.blocks.blockVoidstairs.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH);

			for (int i = 0; i <= 9; ++i) {
				int j = Math.max(1, 7 - i);
				int k = Math.min(Math.max(j + 5, 14 - i), 13);
				int l = i;
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, i, 4, j, i, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, j + 1, i, 3, k - 1, i, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);

				if (i <= 6) {
					this.setBlockState(worldIn, iblockstate, 1, j + 1, i, structureBoundingBoxIn);
					this.setBlockState(worldIn, iblockstate, 2, j + 1, i, structureBoundingBoxIn);
					this.setBlockState(worldIn, iblockstate, 3, j + 1, i, structureBoundingBoxIn);
				}

				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, k, i, 4, k, i, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, j + 1, i, 0, k - 1, i, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, j + 1, i, 4, k - 1, i, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

				if ((i & 1) == 0) {
					this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, j + 2, i, 0, j + 3, i, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
					this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, j + 2, i, 4, j + 3, i, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				}

				for (int i1 = 0; i1 <= 4; ++i1) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i1, -1, l, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class Corridor4 extends StructureVoidFortressPieces.Piece {
		public Corridor4() {
		}

		public Corridor4(int p_i45618_1_, Random p_i45618_2_, StructureBoundingBox p_i45618_3_, EnumFacing p_i45618_4_) {
			super(p_i45618_1_);
			this.setCoordBaseMode(p_i45618_4_);
			this.boundingBox = p_i45618_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			int i = 1;
			EnumFacing enumfacing = this.getCoordBaseMode();

			if (enumfacing == EnumFacing.WEST || enumfacing == EnumFacing.NORTH) {
				i = 5;
			}

			this.getNextComponentX((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 0, i, rand.nextInt(8) > 0);
			this.getNextComponentZ((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 0, i, rand.nextInt(8) > 0);
		}

		public static StructureVoidFortressPieces.Corridor4 createPiece(List<StructureComponent> p_175880_0_, Random p_175880_1_, int p_175880_2_, int p_175880_3_, int p_175880_4_, EnumFacing p_175880_5_, int p_175880_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175880_2_, p_175880_3_, p_175880_4_, -3, 0, 0, 9, 7, 9, p_175880_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175880_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Corridor4(p_175880_6_, p_175880_1_, structureboundingbox, p_175880_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 8, 1, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 8, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 8, 6, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 2, 5, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 2, 0, 8, 5, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 0, 1, 4, 0, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 3, 0, 7, 4, 0, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 8, 2, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 4, 2, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 1, 4, 7, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 8, 8, 3, 8, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 6, 0, 3, 7, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 3, 6, 8, 3, 7, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 4, 0, 5, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 3, 4, 8, 5, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 5, 2, 5, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 3, 5, 7, 5, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 5, 1, 5, 5, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 4, 5, 7, 5, 5, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);

			for (int i = 0; i <= 5; ++i) {
				for (int j = 0; j <= 8; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), j, -1, i, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class Corridor5 extends StructureVoidFortressPieces.Piece {
		public Corridor5() {
		}

		public Corridor5(int p_i45614_1_, Random p_i45614_2_, StructureBoundingBox p_i45614_3_, EnumFacing p_i45614_4_) {
			super(p_i45614_1_);
			this.setCoordBaseMode(p_i45614_4_);
			this.boundingBox = p_i45614_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 1, 0, true);
		}

		public static StructureVoidFortressPieces.Corridor5 createPiece(List<StructureComponent> p_175877_0_, Random p_175877_1_, int p_175877_2_, int p_175877_3_, int p_175877_4_, EnumFacing p_175877_5_, int p_175877_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175877_2_, p_175877_3_, p_175877_4_, -1, 0, 0, 5, 7, 5, p_175877_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175877_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Corridor5(p_175877_6_, p_175877_1_, structureboundingbox, p_175877_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 5, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 4, 5, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 1, 0, 4, 1, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 3, 0, 4, 3, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 1, 4, 4, 1, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 3, 4, 4, 3, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 4, 6, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int i = 0; i <= 4; ++i) {
				for (int j = 0; j <= 4; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class Crossing extends StructureVoidFortressPieces.Piece {
		public Crossing() {
		}

		public Crossing(int p_i45610_1_, Random p_i45610_2_, StructureBoundingBox p_i45610_3_, EnumFacing p_i45610_4_) {
			super(p_i45610_1_);
			this.setCoordBaseMode(p_i45610_4_);
			this.boundingBox = p_i45610_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 2, 0, false);
			this.getNextComponentX((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 0, 2, false);
			this.getNextComponentZ((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 0, 2, false);
		}

		public static StructureVoidFortressPieces.Crossing createPiece(List<StructureComponent> p_175873_0_, Random p_175873_1_, int p_175873_2_, int p_175873_3_, int p_175873_4_, EnumFacing p_175873_5_, int p_175873_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175873_2_, p_175873_3_, p_175873_4_, -2, 0, 0, 7, 9, 7, p_175873_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175873_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Crossing(p_175873_6_, p_175873_1_, structureboundingbox, p_175873_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 6, 1, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 6, 7, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 1, 6, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 6, 1, 6, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 0, 6, 6, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 6, 6, 6, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 6, 1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 5, 0, 6, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 2, 0, 6, 6, 1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 2, 5, 6, 6, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 6, 0, 4, 6, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 0, 4, 5, 0, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 6, 6, 4, 6, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 6, 4, 5, 6, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 2, 0, 6, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 2, 0, 5, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 6, 2, 6, 6, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 5, 2, 6, 5, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);

			for (int i = 0; i <= 6; ++i) {
				for (int j = 0; j <= 6; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class Crossing2 extends StructureVoidFortressPieces.Piece {
		public Crossing2() {
		}

		public Crossing2(int p_i45616_1_, Random p_i45616_2_, StructureBoundingBox p_i45616_3_, EnumFacing p_i45616_4_) {
			super(p_i45616_1_);
			this.setCoordBaseMode(p_i45616_4_);
			this.boundingBox = p_i45616_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 1, 0, true);
			this.getNextComponentX((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 0, 1, true);
			this.getNextComponentZ((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 0, 1, true);
		}

		public static StructureVoidFortressPieces.Crossing2 createPiece(List<StructureComponent> p_175878_0_, Random p_175878_1_, int p_175878_2_, int p_175878_3_, int p_175878_4_, EnumFacing p_175878_5_, int p_175878_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175878_2_, p_175878_3_, p_175878_4_, -1, 0, 0, 5, 7, 5, p_175878_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175878_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Crossing2(p_175878_6_, p_175878_1_, structureboundingbox, p_175878_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 5, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 4, 5, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 0, 5, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 4, 4, 5, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 0, 4, 6, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int i = 0; i <= 4; ++i) {
				for (int j = 0; j <= 4; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class Crossing3 extends StructureVoidFortressPieces.Piece {
		public Crossing3() {
		}

		public Crossing3(int p_i45622_1_, Random p_i45622_2_, StructureBoundingBox p_i45622_3_, EnumFacing p_i45622_4_) {
			super(p_i45622_1_);
			this.setCoordBaseMode(p_i45622_4_);
			this.boundingBox = p_i45622_3_;
		}

		protected Crossing3(Random p_i2042_1_, int p_i2042_2_, int p_i2042_3_) {
			super(0);
			this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(p_i2042_1_));

			if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
				this.boundingBox = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
			} else {
				this.boundingBox = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
			}
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 8, 3, false);
			this.getNextComponentX((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 3, 8, false);
			this.getNextComponentZ((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 3, 8, false);
		}

		public static StructureVoidFortressPieces.Crossing3 createPiece(List<StructureComponent> p_175885_0_, Random p_175885_1_, int p_175885_2_, int p_175885_3_, int p_175885_4_, EnumFacing p_175885_5_, int p_175885_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175885_2_, p_175885_3_, p_175885_4_, -8, -3, 0, 19, 10, 19, p_175885_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175885_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Crossing3(p_175885_6_, p_175885_1_, structureboundingbox, p_175885_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 3, 0, 11, 4, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 7, 18, 4, 11, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 0, 10, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 8, 18, 7, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 5, 0, 7, 5, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 5, 11, 7, 5, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 0, 11, 5, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 11, 11, 5, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 7, 7, 5, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 7, 18, 5, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 11, 7, 5, 11, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 11, 18, 5, 11, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 2, 0, 11, 2, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 2, 13, 11, 2, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 0, 0, 11, 1, 3, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 0, 15, 11, 1, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int i = 7; i <= 11; ++i) {
				for (int j = 0; j <= 2; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, 18 - j, structureBoundingBoxIn);
				}
			}

			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 7, 5, 2, 11, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 13, 2, 7, 18, 2, 11, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 7, 3, 1, 11, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 15, 0, 7, 18, 1, 11, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int k = 0; k <= 2; ++k) {
				for (int l = 7; l <= 11; ++l) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), k, -1, l, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 18 - k, -1, l, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class End extends StructureVoidFortressPieces.Piece {
		private int fillSeed;

		public End() {
		}

		public End(int p_i45621_1_, Random p_i45621_2_, StructureBoundingBox p_i45621_3_, EnumFacing p_i45621_4_) {
			super(p_i45621_1_);
			this.setCoordBaseMode(p_i45621_4_);
			this.boundingBox = p_i45621_3_;
			this.fillSeed = p_i45621_2_.nextInt();
		}

		public static StructureVoidFortressPieces.End createPiece(List<StructureComponent> p_175884_0_, Random p_175884_1_, int p_175884_2_, int p_175884_3_, int p_175884_4_, EnumFacing p_175884_5_, int p_175884_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175884_2_, p_175884_3_, p_175884_4_, -1, -3, 0, 5, 10, 8, p_175884_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175884_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.End(p_175884_6_, p_175884_1_, structureboundingbox, p_175884_5_) : null;
		}

		/**
		 * (abstract) Helper method to read subclass data from NBT
		 */
		@Override
		protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {
			super.readStructureFromNBT(tagCompound, p_143011_2_);
			this.fillSeed = tagCompound.getInteger("Seed");
		}

		/**
		 * (abstract) Helper method to write subclass data to NBT
		 */
		@Override
		protected void writeStructureToNBT(NBTTagCompound tagCompound) {
			super.writeStructureToNBT(tagCompound);
			tagCompound.setInteger("Seed", this.fillSeed);
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			Random random = new Random((long) this.fillSeed);

			for (int i = 0; i <= 4; ++i) {
				for (int j = 3; j <= 4; ++j) {
					int k = random.nextInt(8);
					this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, j, 0, i, j, k, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
				}
			}

			int l = random.nextInt(8);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 0, 5, l, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			l = random.nextInt(8);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 5, 0, 4, 5, l, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (l = 0; l <= 4; ++l) {
				int i1 = random.nextInt(5);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, l, 2, 0, l, 2, i1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			}

			for (l = 0; l <= 4; ++l) {
				for (int j1 = 0; j1 <= 1; ++j1) {
					int k1 = random.nextInt(3);
					this.fillWithBlocks(worldIn, structureBoundingBoxIn, l, j1, 0, l, j1, k1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
				}
			}

			return true;
		}
	}

	public static class Entrance extends StructureVoidFortressPieces.Piece {
		public Entrance() {
		}

		public Entrance(int p_i45617_1_, Random p_i45617_2_, StructureBoundingBox p_i45617_3_, EnumFacing p_i45617_4_) {
			super(p_i45617_1_);
			this.setCoordBaseMode(p_i45617_4_);
			this.boundingBox = p_i45617_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 5, 3, true);
		}

		public static StructureVoidFortressPieces.Entrance createPiece(List<StructureComponent> p_175881_0_, Random p_175881_1_, int p_175881_2_, int p_175881_3_, int p_175881_4_, EnumFacing p_175881_5_, int p_175881_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175881_2_, p_175881_3_, p_175881_4_, -5, -3, 0, 13, 14, 13, p_175881_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175881_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Entrance(p_175881_6_, p_175881_1_, structureboundingbox, p_175881_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 0, 12, 4, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 1, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 0, 12, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 11, 4, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 11, 10, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 9, 11, 7, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 0, 4, 12, 1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 0, 10, 12, 1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 9, 0, 7, 12, 1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 11, 2, 10, 12, 10, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 8, 0, 7, 8, 0, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);

			for (int i = 1; i <= 11; i += 2) {
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, 10, 0, i, 11, 0, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, 10, 12, i, 11, 12, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 10, i, 0, 11, i, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 10, i, 12, 11, i, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, 13, 0, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, 13, 12, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 0, 13, i, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 12, 13, i, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), i + 1, 13, 0, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), i + 1, 13, 12, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 0, 13, i + 1, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 12, 13, i + 1, structureBoundingBoxIn);
			}

			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 0, 13, 0, structureBoundingBoxIn);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 0, 13, 12, structureBoundingBoxIn);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 0, 13, 0, structureBoundingBoxIn);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 12, 13, 0, structureBoundingBoxIn);

			for (int k = 3; k <= 9; k += 2) {
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, k, 1, 8, k, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 7, k, 11, 8, k, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			}

			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 8, 2, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 12, 2, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 0, 8, 1, 3, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 9, 8, 1, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 4, 3, 1, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 0, 4, 12, 1, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int l = 4; l <= 8; ++l) {
				for (int j = 0; j <= 2; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), l, -1, j, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), l, -1, 12 - j, structureBoundingBoxIn);
				}
			}

			for (int i1 = 0; i1 <= 2; ++i1) {
				for (int j1 = 4; j1 <= 8; ++j1) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i1, -1, j1, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 12 - i1, -1, j1, structureBoundingBoxIn);
				}
			}

			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 5, 5, 7, 5, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 1, 6, 6, 4, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 6, 0, 6, structureBoundingBoxIn);
			IBlockState iblockstate = VoidCraft.fluids.voidFluidBlock.getDefaultState();
			this.setBlockState(worldIn, iblockstate, 6, 5, 6, structureBoundingBoxIn);
			BlockPos blockpos = new BlockPos(this.getXWithOffset(6, 6), this.getYWithOffset(5), this.getZWithOffset(6, 6));

			if (structureBoundingBoxIn.isVecInside(blockpos)) {
				worldIn.immediateBlockTick(blockpos, iblockstate, randomIn);
			}

			return true;
		}
	}

	public static class NetherStalkRoom extends StructureVoidFortressPieces.Piece {
		public NetherStalkRoom() {
		}

		public NetherStalkRoom(int p_i45612_1_, Random p_i45612_2_, StructureBoundingBox p_i45612_3_, EnumFacing p_i45612_4_) {
			super(p_i45612_1_);
			this.setCoordBaseMode(p_i45612_4_);
			this.boundingBox = p_i45612_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 5, 3, true);
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 5, 11, true);
		}

		public static StructureVoidFortressPieces.NetherStalkRoom createPiece(List<StructureComponent> p_175875_0_, Random p_175875_1_, int p_175875_2_, int p_175875_3_, int p_175875_4_, EnumFacing p_175875_5_, int p_175875_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175875_2_, p_175875_3_, p_175875_4_, -5, -3, 0, 13, 14, 13, p_175875_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175875_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.NetherStalkRoom(p_175875_6_, p_175875_1_, structureboundingbox, p_175875_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 0, 12, 4, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 1, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 5, 0, 12, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 11, 4, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 11, 10, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 9, 11, 7, 12, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 0, 4, 12, 1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 0, 10, 12, 1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 9, 0, 7, 12, 1, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 11, 2, 10, 12, 10, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int i = 1; i <= 11; i += 2) {
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, 10, 0, i, 11, 0, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, i, 10, 12, i, 11, 12, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 10, i, 0, 11, i, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 10, i, 12, 11, i, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, 13, 0, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, 13, 12, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 0, 13, i, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 12, 13, i, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), i + 1, 13, 0, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), i + 1, 13, 12, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 0, 13, i + 1, structureBoundingBoxIn);
				this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 12, 13, i + 1, structureBoundingBoxIn);
			}

			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 0, 13, 0, structureBoundingBoxIn);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 0, 13, 12, structureBoundingBoxIn);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 0, 13, 0, structureBoundingBoxIn);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 12, 13, 0, structureBoundingBoxIn);

			for (int j1 = 3; j1 <= 9; j1 += 2) {
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, j1, 1, 8, j1, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
				this.fillWithBlocks(worldIn, structureBoundingBoxIn, 11, 7, j1, 11, 8, j1, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			}

			IBlockState iblockstate = VoidCraft.blocks.blockVoidstairs.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);

			for (int j = 0; j <= 6; ++j) {
				int k = j + 4;

				for (int l = 5; l <= 7; ++l) {
					this.setBlockState(worldIn, iblockstate, l, 5 + j, k, structureBoundingBoxIn);
				}

				if (k >= 5 && k <= 8) {
					this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 5, k, 7, j + 4, k, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
				} else if (k >= 9 && k <= 10) {
					this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 8, k, 7, j + 4, k, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
				}

				if (j >= 1) {
					this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 6 + j, k, 7, 9 + j, k, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
				}
			}

			for (int k1 = 5; k1 <= 7; ++k1) {
				this.setBlockState(worldIn, iblockstate, k1, 12, 11, structureBoundingBoxIn);
			}

			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 6, 7, 5, 7, 7, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 6, 7, 7, 7, 7, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 13, 12, 7, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 2, 3, 5, 3, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 9, 3, 5, 10, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 4, 2, 5, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 5, 2, 10, 5, 3, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 5, 9, 10, 5, 10, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 10, 5, 4, 10, 5, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			IBlockState iblockstate1 = iblockstate.withProperty(BlockStairs.FACING, EnumFacing.EAST);
			IBlockState iblockstate2 = iblockstate.withProperty(BlockStairs.FACING, EnumFacing.WEST);
			this.setBlockState(worldIn, iblockstate2, 4, 5, 2, structureBoundingBoxIn);
			this.setBlockState(worldIn, iblockstate2, 4, 5, 3, structureBoundingBoxIn);
			this.setBlockState(worldIn, iblockstate2, 4, 5, 9, structureBoundingBoxIn);
			this.setBlockState(worldIn, iblockstate2, 4, 5, 10, structureBoundingBoxIn);
			this.setBlockState(worldIn, iblockstate1, 8, 5, 2, structureBoundingBoxIn);
			this.setBlockState(worldIn, iblockstate1, 8, 5, 3, structureBoundingBoxIn);
			this.setBlockState(worldIn, iblockstate1, 8, 5, 9, structureBoundingBoxIn);
			this.setBlockState(worldIn, iblockstate1, 8, 5, 10, structureBoundingBoxIn);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 4, 4, 4, 4, 8, VoidCraft.blocks.realityHole.getDefaultState(), VoidCraft.blocks.realityHole.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 4, 4, 9, 4, 8, VoidCraft.blocks.realityHole.getDefaultState(), VoidCraft.blocks.realityHole.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 5, 4, 4, 5, 8, VoidCraft.blocks.realityHole.getDefaultState(), VoidCraft.blocks.realityHole.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 5, 4, 9, 5, 8, VoidCraft.blocks.realityHole.getDefaultState(), VoidCraft.blocks.realityHole.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 0, 8, 2, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 4, 12, 2, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 0, 8, 1, 3, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 9, 8, 1, 12, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 4, 3, 1, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 0, 4, 12, 1, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int l1 = 4; l1 <= 8; ++l1) {
				for (int i1 = 0; i1 <= 2; ++i1) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), l1, -1, i1, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), l1, -1, 12 - i1, structureBoundingBoxIn);
				}
			}

			for (int i2 = 0; i2 <= 2; ++i2) {
				for (int j2 = 4; j2 <= 8; ++j2) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i2, -1, j2, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 12 - i2, -1, j2, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	abstract static class Piece extends StructureComponent {
		public Piece() {
		}

		protected Piece(int p_i2054_1_) {
			super(p_i2054_1_);
		}

		/**
		 * (abstract) Helper method to read subclass data from NBT
		 */
		@Override
		protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {

		}

		/**
		 * (abstract) Helper method to write subclass data to NBT
		 */
		@Override
		protected void writeStructureToNBT(NBTTagCompound tagCompound) {

		}

		private int getTotalWeight(List<StructureVoidFortressPieces.PieceWeight> p_74960_1_) {
			boolean flag = false;
			int i = 0;

			for (StructureVoidFortressPieces.PieceWeight structurenetherbridgepieces$pieceweight : p_74960_1_) {
				if (structurenetherbridgepieces$pieceweight.maxPlaceCount > 0 && structurenetherbridgepieces$pieceweight.placeCount < structurenetherbridgepieces$pieceweight.maxPlaceCount) {
					flag = true;
				}

				i += structurenetherbridgepieces$pieceweight.weight;
			}

			return flag ? i : -1;
		}

		private StructureVoidFortressPieces.Piece generatePiece(StructureVoidFortressPieces.Start p_175871_1_, List<StructureVoidFortressPieces.PieceWeight> p_175871_2_, List<StructureComponent> p_175871_3_, Random p_175871_4_, int p_175871_5_, int p_175871_6_, int p_175871_7_, EnumFacing p_175871_8_, int p_175871_9_) {
			int i = this.getTotalWeight(p_175871_2_);
			boolean flag = i > 0 && p_175871_9_ <= 30;
			int j = 0;

			while (j < 5 && flag) {
				++j;
				int k = p_175871_4_.nextInt(i);

				for (StructureVoidFortressPieces.PieceWeight structurenetherbridgepieces$pieceweight : p_175871_2_) {
					k -= structurenetherbridgepieces$pieceweight.weight;

					if (k < 0) {
						if (!structurenetherbridgepieces$pieceweight.doPlace(p_175871_9_) || structurenetherbridgepieces$pieceweight == p_175871_1_.theNetherBridgePieceWeight && !structurenetherbridgepieces$pieceweight.allowInRow) {
							break;
						}

						StructureVoidFortressPieces.Piece structurenetherbridgepieces$piece = StructureVoidFortressPieces.findAndCreateBridgePieceFactory(structurenetherbridgepieces$pieceweight, p_175871_3_, p_175871_4_, p_175871_5_, p_175871_6_, p_175871_7_, p_175871_8_, p_175871_9_);

						if (structurenetherbridgepieces$piece != null) {
							++structurenetherbridgepieces$pieceweight.placeCount;
							p_175871_1_.theNetherBridgePieceWeight = structurenetherbridgepieces$pieceweight;

							if (!structurenetherbridgepieces$pieceweight.isValid()) {
								p_175871_2_.remove(structurenetherbridgepieces$pieceweight);
							}

							return structurenetherbridgepieces$piece;
						}
					}
				}
			}

			return StructureVoidFortressPieces.End.createPiece(p_175871_3_, p_175871_4_, p_175871_5_, p_175871_6_, p_175871_7_, p_175871_8_, p_175871_9_);
		}

		private StructureComponent generateAndAddPiece(StructureVoidFortressPieces.Start p_175870_1_, List<StructureComponent> p_175870_2_, Random p_175870_3_, int p_175870_4_, int p_175870_5_, int p_175870_6_, @Nullable EnumFacing p_175870_7_, int p_175870_8_, boolean p_175870_9_) {
			if (Math.abs(p_175870_4_ - p_175870_1_.getBoundingBox().minX) <= 112 && Math.abs(p_175870_6_ - p_175870_1_.getBoundingBox().minZ) <= 112) {
				List<StructureVoidFortressPieces.PieceWeight> list = p_175870_1_.primaryWeights;

				if (p_175870_9_) {
					list = p_175870_1_.secondaryWeights;
				}

				StructureComponent structurecomponent = this.generatePiece(p_175870_1_, list, p_175870_2_, p_175870_3_, p_175870_4_, p_175870_5_, p_175870_6_, p_175870_7_, p_175870_8_ + 1);

				if (structurecomponent != null) {
					p_175870_2_.add(structurecomponent);
					p_175870_1_.pendingChildren.add(structurecomponent);
				}

				return structurecomponent;
			} else {
				return StructureVoidFortressPieces.End.createPiece(p_175870_2_, p_175870_3_, p_175870_4_, p_175870_5_, p_175870_6_, p_175870_7_, p_175870_8_);
			}
		}

		/**
		 * Gets the next component in any cardinal direction
		 */
		protected StructureComponent getNextComponentNormal(StructureVoidFortressPieces.Start p_74963_1_, List<StructureComponent> p_74963_2_, Random p_74963_3_, int p_74963_4_, int p_74963_5_, boolean p_74963_6_) {
			EnumFacing enumfacing = this.getCoordBaseMode();

			if (enumfacing != null) {
				switch (enumfacing) {
					case NORTH:
						return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ - 1, enumfacing, this.getComponentType(), p_74963_6_);
					case SOUTH:
						return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.maxZ + 1, enumfacing, this.getComponentType(), p_74963_6_);
					case WEST:
						return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, enumfacing, this.getComponentType(), p_74963_6_);
					case EAST:
						return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, enumfacing, this.getComponentType(), p_74963_6_);
					default:
						return null;
				}
			}

			return null;
		}

		/**
		 * Gets the next component in the +/- X direction
		 */
		protected StructureComponent getNextComponentX(StructureVoidFortressPieces.Start p_74961_1_, List<StructureComponent> p_74961_2_, Random p_74961_3_, int p_74961_4_, int p_74961_5_, boolean p_74961_6_) {
			EnumFacing enumfacing = this.getCoordBaseMode();

			if (enumfacing != null) {
				switch (enumfacing) {
					case NORTH:
						return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, EnumFacing.WEST, this.getComponentType(), p_74961_6_);
					case SOUTH:
						return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, EnumFacing.WEST, this.getComponentType(), p_74961_6_);
					case WEST:
						return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), p_74961_6_);
					case EAST:
						return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), p_74961_6_);
					default:
						return null;
				}
			}

			return null;
		}

		/**
		 * Gets the next component in the +/- Z direction
		 */
		protected StructureComponent getNextComponentZ(StructureVoidFortressPieces.Start p_74965_1_, List<StructureComponent> p_74965_2_, Random p_74965_3_, int p_74965_4_, int p_74965_5_, boolean p_74965_6_) {
			EnumFacing enumfacing = this.getCoordBaseMode();

			if (enumfacing != null) {
				switch (enumfacing) {
					case NORTH:
						return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, EnumFacing.EAST, this.getComponentType(), p_74965_6_);
					case SOUTH:
						return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, EnumFacing.EAST, this.getComponentType(), p_74965_6_);
					case WEST:
						return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), p_74965_6_);
					case EAST:
						return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), p_74965_6_);
					default:
						return null;
				}
			}

			return null;
		}

		/**
		 * Checks if the bounding box's minY is > 10
		 */
		protected static boolean isAboveGround(StructureBoundingBox p_74964_0_) {
			return p_74964_0_ != null && p_74964_0_.minY > 10;
		}
	}

	static class PieceWeight {
		public Class<? extends StructureVoidFortressPieces.Piece> weightClass;
		public final int weight;
		public int placeCount;
		public int maxPlaceCount;
		public boolean allowInRow;

		public PieceWeight(Class<? extends StructureVoidFortressPieces.Piece> p_i2055_1_, int p_i2055_2_, int p_i2055_3_, boolean p_i2055_4_) {
			this.weightClass = p_i2055_1_;
			this.weight = p_i2055_2_;
			this.maxPlaceCount = p_i2055_3_;
			this.allowInRow = p_i2055_4_;
		}

		public PieceWeight(Class<? extends StructureVoidFortressPieces.Piece> p_i2056_1_, int p_i2056_2_, int p_i2056_3_) {
			this(p_i2056_1_, p_i2056_2_, p_i2056_3_, false);
		}

		public boolean doPlace(int p_78822_1_) {
			return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
		}

		public boolean isValid() {
			return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
		}
	}

	public static class Stairs extends StructureVoidFortressPieces.Piece {
		public Stairs() {
		}

		public Stairs(int p_i45609_1_, Random p_i45609_2_, StructureBoundingBox p_i45609_3_, EnumFacing p_i45609_4_) {
			super(p_i45609_1_);
			this.setCoordBaseMode(p_i45609_4_);
			this.boundingBox = p_i45609_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentZ((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 6, 2, false);
		}

		public static StructureVoidFortressPieces.Stairs createPiece(List<StructureComponent> p_175872_0_, Random p_175872_1_, int p_175872_2_, int p_175872_3_, int p_175872_4_, int p_175872_5_, EnumFacing p_175872_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175872_2_, p_175872_3_, p_175872_4_, -2, 0, 0, 7, 11, 7, p_175872_6_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175872_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Stairs(p_175872_5_, p_175872_1_, structureboundingbox, p_175872_6_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 6, 1, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 6, 10, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 1, 8, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 0, 6, 8, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 1, 0, 8, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 2, 1, 6, 8, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 6, 5, 8, 6, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 2, 0, 5, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 3, 2, 6, 5, 2, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 3, 4, 6, 5, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), 5, 2, 5, structureBoundingBoxIn);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 2, 5, 4, 3, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 2, 5, 3, 4, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 2, 5, 2, 5, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 5, 1, 6, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 7, 1, 5, 7, 4, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 8, 2, 6, 8, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 6, 0, 4, 8, 0, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 5, 0, 4, 5, 0, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);

			for (int i = 0; i <= 6; ++i) {
				for (int j = 0; j <= 6; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

	public static class Start extends StructureVoidFortressPieces.Crossing3 {
		/**
		 * Instance of StructureNetherBridgePieceWeight.
		 */
		public StructureVoidFortressPieces.PieceWeight theNetherBridgePieceWeight;
		public List<StructureVoidFortressPieces.PieceWeight> primaryWeights;
		public List<StructureVoidFortressPieces.PieceWeight> secondaryWeights;
		public List<StructureComponent> pendingChildren = Lists.<StructureComponent>newArrayList();

		public Start() {
		}

		public Start(Random p_i2059_1_, int p_i2059_2_, int p_i2059_3_) {
			super(p_i2059_1_, p_i2059_2_, p_i2059_3_);
			this.primaryWeights = Lists.<StructureVoidFortressPieces.PieceWeight>newArrayList();

			for (StructureVoidFortressPieces.PieceWeight structurenetherbridgepieces$pieceweight : StructureVoidFortressPieces.PRIMARY_COMPONENTS) {
				structurenetherbridgepieces$pieceweight.placeCount = 0;
				this.primaryWeights.add(structurenetherbridgepieces$pieceweight);
			}

			this.secondaryWeights = Lists.<StructureVoidFortressPieces.PieceWeight>newArrayList();

			for (StructureVoidFortressPieces.PieceWeight structurenetherbridgepieces$pieceweight1 : StructureVoidFortressPieces.SECONDARY_COMPONENTS) {
				structurenetherbridgepieces$pieceweight1.placeCount = 0;
				this.secondaryWeights.add(structurenetherbridgepieces$pieceweight1);
			}
		}

	}

	public static class Straight extends StructureVoidFortressPieces.Piece {
		public Straight() {
		}

		public Straight(int p_i45620_1_, Random p_i45620_2_, StructureBoundingBox p_i45620_3_, EnumFacing p_i45620_4_) {
			super(p_i45620_1_);
			this.setCoordBaseMode(p_i45620_4_);
			this.boundingBox = p_i45620_3_;
		}

		/**
		 * Initiates construction of the Structure Component picked, at the current Location of StructGen
		 */
		@Override
		public void buildComponent(StructureComponent componentIn, List<StructureComponent> listIn, Random rand) {
			this.getNextComponentNormal((StructureVoidFortressPieces.Start) componentIn, listIn, rand, 1, 3, false);
		}

		public static StructureVoidFortressPieces.Straight createPiece(List<StructureComponent> p_175882_0_, Random p_175882_1_, int p_175882_2_, int p_175882_3_, int p_175882_4_, EnumFacing p_175882_5_, int p_175882_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175882_2_, p_175882_3_, p_175882_4_, -1, -3, 0, 5, 10, 19, p_175882_5_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175882_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Straight(p_175882_6_, p_175882_1_, structureboundingbox, p_175882_5_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 0, 4, 4, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 0, 3, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 0, 5, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 5, 0, 4, 5, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 4, 2, 5, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 13, 4, 2, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 4, 1, 3, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 15, 4, 1, 18, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);

			for (int i = 0; i <= 4; ++i) {
				for (int j = 0; j <= 2; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, 18 - j, structureBoundingBoxIn);
				}
			}

			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 1, 0, 4, 1, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 4, 0, 4, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 3, 14, 0, 4, 14, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 17, 0, 4, 17, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 1, 4, 4, 1, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 4, 4, 4, 4, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 3, 14, 4, 4, 14, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 1, 17, 4, 4, 17, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			return true;
		}
	}

	public static class Throne extends StructureVoidFortressPieces.Piece {
		private boolean hasSpawner;

		public Throne() {
		}

		public Throne(int p_i45611_1_, Random p_i45611_2_, StructureBoundingBox p_i45611_3_, EnumFacing p_i45611_4_) {
			super(p_i45611_1_);
			this.setCoordBaseMode(p_i45611_4_);
			this.boundingBox = p_i45611_3_;
		}

		/**
		 * (abstract) Helper method to read subclass data from NBT
		 */
		@Override
		protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_) {
			super.readStructureFromNBT(tagCompound, p_143011_2_);
			this.hasSpawner = tagCompound.getBoolean("Mob");
		}

		/**
		 * (abstract) Helper method to write subclass data to NBT
		 */
		@Override
		protected void writeStructureToNBT(NBTTagCompound tagCompound) {
			super.writeStructureToNBT(tagCompound);
			tagCompound.setBoolean("Mob", this.hasSpawner);
		}

		public static StructureVoidFortressPieces.Throne createPiece(List<StructureComponent> p_175874_0_, Random p_175874_1_, int p_175874_2_, int p_175874_3_, int p_175874_4_, int p_175874_5_, EnumFacing p_175874_6_) {
			StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175874_2_, p_175874_3_, p_175874_4_, -2, 0, 0, 7, 8, 9, p_175874_6_);
			/**
			 * Checks if the bounding box's minY is > 10
			 */
			return isAboveGround(structureboundingbox) && StructureComponent.findIntersecting(p_175874_0_, structureboundingbox) == null ? new StructureVoidFortressPieces.Throne(p_175874_5_, p_175874_1_, structureboundingbox, p_175874_6_) : null;
		}

		/**
		 * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at the end, it adds Fences...
		 */
		@Override
		public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 6, 7, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 0, 5, 1, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 1, 5, 2, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 3, 2, 5, 3, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 3, 5, 4, 7, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 0, 1, 4, 2, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 2, 0, 5, 4, 2, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 2, 1, 5, 3, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 5, 5, 2, 5, 5, 3, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 3, 0, 5, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 5, 3, 6, 5, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 5, 8, 5, 5, 8, VoidCraft.blocks.blockVoidbrick.getDefaultState(), VoidCraft.blocks.blockVoidbrick.getDefaultState(), false);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 1, 6, 3, structureBoundingBoxIn);
			this.setBlockState(worldIn, VoidCraft.blocks.blockVoidfence.getDefaultState(), 5, 6, 3, structureBoundingBoxIn);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 3, 0, 6, 8, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 6, 3, 6, 6, 8, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 6, 8, 5, 7, 8, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);
			this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 8, 8, 4, 8, 8, VoidCraft.blocks.blockVoidfence.getDefaultState(), VoidCraft.blocks.blockVoidfence.getDefaultState(), false);

			if (!this.hasSpawner) {
				BlockPos blockpos = new BlockPos(this.getXWithOffset(3, 5), this.getYWithOffset(5), this.getZWithOffset(3, 5));

				if (structureBoundingBoxIn.isVecInside(blockpos)) {/*
																	 * this.hasSpawner = true; worldIn.setBlockState(blockpos, Blocks.MOB_SPAWNER.getDefaultState(), 2); TileEntity tileentity = worldIn.getTileEntity(blockpos); if (tileentity instanceof TileEntityMobSpawner) { ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic().setEntityName("Blaze"); }
																	 */
				}
			}

			for (int i = 0; i <= 6; ++i) {
				for (int j = 0; j <= 6; ++j) {
					this.replaceAirAndLiquidDownwards(worldIn, VoidCraft.blocks.blockVoidbrick.getDefaultState(), i, -1, j, structureBoundingBoxIn);
				}
			}

			return true;
		}
	}

}