package com.networkoverflow.lifepower.content.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class LifeForceProvider implements ICapabilitySerializable<INBT> {
    @CapabilityInject(ILifeForce.class)
    public static final Capability<ILifeForce> LIFE_FORCE_CAP = null;

    private LazyOptional<ILifeForce> instance = LazyOptional.of(LIFE_FORCE_CAP::getDefaultInstance);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {
        return capability == LIFE_FORCE_CAP ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return LIFE_FORCE_CAP.getStorage().writeNBT(LIFE_FORCE_CAP, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        LIFE_FORCE_CAP.getStorage().readNBT(LIFE_FORCE_CAP, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null, nbt);
    }
}
