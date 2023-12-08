package com.shiny_labs.bonesupdate.common.events;

import com.shiny_labs.bonesupdate.BonesUpdate;
import com.shiny_labs.bonesupdate.common.client.models.KnightSkeletonModel;
import com.shiny_labs.bonesupdate.common.client.models.MinionModel;
import com.shiny_labs.bonesupdate.common.client.models.NecromancerModel;
import com.shiny_labs.bonesupdate.common.client.renderer.KnightSkeletonRenderer;
import com.shiny_labs.bonesupdate.common.client.renderer.MinionRenderer;
import com.shiny_labs.bonesupdate.common.client.renderer.NecromancerRenderer;
import com.shiny_labs.bonesupdate.init.BonesEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BonesUpdate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BonesClientEvents {

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BonesEntities.MINION.get(), MinionRenderer::new);
        event.registerEntityRenderer(BonesEntities.NECROMANCER.get(), NecromancerRenderer::new);
        event.registerEntityRenderer(BonesEntities.KNIGHT_SKELETON.get(), KnightSkeletonRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MinionModel.LAYER_LOCATION,MinionModel::createBodyLayer);
        event.registerLayerDefinition(NecromancerModel.LAYER_LOCATION,NecromancerModel::createBodyLayer);
        event.registerLayerDefinition(KnightSkeletonModel.LAYER_LOCATION, KnightSkeletonModel::createBodyLayer);
    }
}
