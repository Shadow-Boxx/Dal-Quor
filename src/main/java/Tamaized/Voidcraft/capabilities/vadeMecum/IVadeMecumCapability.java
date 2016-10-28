package Tamaized.Voidcraft.capabilities.vadeMecum;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import io.netty.buffer.ByteBufInputStream;

public interface IVadeMecumCapability {

	public static enum Category {
		INTRO, TOME,

		Flame, FireSheath, Fireball, FireTrap, ExplosionFire, CircleOfFire,

		Shock, ShockSheath, LitStrike, LitTrap, ExplosionLit, CircleOfLit,

		Freeze, FrostSheath, IceSpike, FrostTrap, ExplosionFrost, CircleOfFrost,

		AcidSpray, AcidSheath, Disint, AcidTrap, ExplosionAcid, CircleOfAcid,

		VoidicTouch, VoidicSheath, Implosion
	}

	public static int getCategoryID(Category c) {
		return c == null ? -1 : c.ordinal();
	}

	public static Category getCategoryFromID(int id) {
		return (id > Category.values().length || id < 0) ? null : Category.values()[id];
	}

	public static enum ActivePower {
		Flame, FireSheath, Fireball, FireTrap, ExplosionFire, CircleOfFire,

		Shock, ShockSheath, LitStrike, LitTrap, ExplosionLit, CircleOfLit,

		Freeze, FrostSheath, IceSpike, FrostTrap, ExplosionFrost, CircleOfFrost,

		AcidSpray, AcidSheath, Disint, AcidTrap, ExplosionAcid, CircleOfAcid,

		VoidicTouch, VoidicSheath, Implosion
	}

	public static int getActivePowerID(ActivePower c) {
		return c == null ? -1 : c.ordinal();
	}

	public static ActivePower getActivePowerFromID(int id) {
		return (id > ActivePower.values().length || id < 0) ? null : ActivePower.values()[id];
	}

	public static enum PassivePower {
		TEST, TESTTWO
	}

	public static int getPassivePowerID(PassivePower c) {
		return c == null ? -1 : c.ordinal();
	}

	public static PassivePower getPassivePowerFromID(int id) {
		return (id > PassivePower.values().length || id < 0) ? null : PassivePower.values()[id];
	}

	public boolean isDirty();

	public void resetDirty();

	public ArrayList<Category> getObtainedCategories();

	public void setObtainedCategories(ArrayList<Category> list);

	public void addCategory(Category category);

	public void removeCategory(Category category);

	public void clearCategories();

	public boolean hasCategory(Category category);

	public ArrayList<ActivePower> getActivePowers();

	public void setActivePowers(ArrayList<ActivePower> list);

	public void addActivePower(ActivePower power);

	public void removeActivePower(ActivePower power);

	public void clearActivePowers();

	public boolean hasActivePower(ActivePower power);

	public ArrayList<PassivePower> getPassivePowers();

	public void setPassivePowers(ArrayList<PassivePower> list);

	public void addPassivePower(PassivePower power);

	public void removePassivePower(PassivePower power);

	public void clearPassivePowers();

	public boolean hasPassivePower(PassivePower power);

	public void setCurrentActive(ActivePower power);

	public ActivePower getCurrentActive();

	public void setLastEntry(String e);

	public String getLastEntry();

	public boolean hasLoaded();

	public void setLoaded();

	public void copyFrom(IVadeMecumCapability cap);

	public void decodePacket(ByteBufInputStream stream) throws IOException;

	public void encodePacket(DataOutputStream stream) throws IOException;

}