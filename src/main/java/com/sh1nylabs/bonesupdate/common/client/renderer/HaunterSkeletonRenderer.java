package com.sh1nylabs.bonesupdate.common.client.renderer;

/* Java class written by sh1nylabs' team. All rights reserved. */

import com.sh1nylabs.bonesupdate.BonesUpdate;
import com.sh1nylabs.bonesupdate.common.client.models.HaunterSkeletonModel;
import com.sh1nylabs.bonesupdate.common.entities.custom_skeletons.HaunterSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class HaunterSkeletonRenderer extends MobRenderer<HaunterSkeleton, HaunterSkeletonModel> {

    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(BonesUpdate.MODID,"textures/entity/haunter_skeleton.png");

    public HaunterSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context,new HaunterSkeletonModel(context.bakeLayer(HaunterSkeletonModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    public ResourceLocation getTextureLocation(HaunterSkeleton entity) {
        return TEXTURE;
    }
}
