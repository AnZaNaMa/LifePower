package com.networkoverflow.lifepower.content.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class DebugItem extends Item {

    public DebugItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        return true;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(worldIn.isRemote()) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            player.sendStatusMessage(entityLiving.getDisplayName(), false);
            //player.sendStatusMessage(new StringTextComponent("Life Force: " + ));
        }
        return stack;
    }
}
