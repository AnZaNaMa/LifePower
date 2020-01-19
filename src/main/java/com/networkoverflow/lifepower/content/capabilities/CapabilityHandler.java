package com.networkoverflow.lifepower.content.capabilities;

import com.networkoverflow.lifepower.LifePower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = LifePower.MODID)
public class CapabilityHandler {

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(ILifeForce.class, new LifeForceStorage(), LifeForce::new);
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof LivingEntity) {
            event.addCapability(new ResourceLocation(LifePower.MODID, "lifeforce"), new LifeForceProvider());
            event.getObject().getCapability(LifeForceProvider.LIFE_FORCE_CAP).ifPresent((capability) -> {
                capability.set(Math.round(((LivingEntity) event.getObject()).getHealth()));
            });
        }
    }
}
