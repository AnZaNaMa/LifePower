package com.networkoverflow.lifepower;

import com.networkoverflow.lifepower.content.capabilities.CapabilityHandler;
import com.networkoverflow.lifepower.content.items.DebugItem;
import com.networkoverflow.lifepower.init.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = LifePower.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(CapabilityHandler::onCommonSetup);
    }

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                setup(new DebugItem(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)), "debug_item")
        );
    }

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "useless_block")
        );
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(LifePower.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }
}
