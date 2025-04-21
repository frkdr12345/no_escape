
package net.mcreator.noescape.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CodModel;

import net.mcreator.noescape.entity.CrashEntity;

public class CrashRenderer extends MobRenderer<CrashEntity, CodModel<CrashEntity>> {
	public CrashRenderer(EntityRendererProvider.Context context) {
		super(context, new CodModel(context.bakeLayer(ModelLayers.COD)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CrashEntity entity) {
		return new ResourceLocation("no_escape:textures/entities/crash.png");
	}
}
