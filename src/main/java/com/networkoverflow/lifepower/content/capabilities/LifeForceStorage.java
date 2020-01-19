package com.networkoverflow.lifepower.content.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class LifeForceStorage implements Capability.IStorage<ILifeForce> {

    @Override
    public INBT writeNBT(Capability<ILifeForce> capability, ILifeForce instance, Direction direction) {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("lifeForce", instance.getLifeForce());
        return tag;
    }

    @Override
    public void readNBT(Capability<ILifeForce> capability, ILifeForce instance, Direction direction, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.set(tag.getInt("lifeForce"));
    }
}
