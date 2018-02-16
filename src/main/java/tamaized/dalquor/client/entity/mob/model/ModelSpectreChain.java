// Date: 8/6/2014 12:40:17 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package tamaized.dalquor.client.entity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpectreChain extends ModelBase {
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;

	public ModelSpectreChain() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 6F, -6F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.296706F, 0F, 0F);
		body = new ModelRenderer(this, 36, 0);
		body.addBox(-4F, 0F, -2F, 8, 23, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 18, 16);
		rightarm.addBox(-2F, 0F, -2F, 3, 12, 4);
		rightarm.setRotationPoint(-6F, 4F, -5F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 18, 16);
		leftarm.addBox(-1F, 0F, -2F, 3, 12, 4);
		leftarm.setRotationPoint(6F, 4F, -5F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float limbSwingAmount, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, limbSwingAmount, f2, f3, f4, f5, entity);

		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);

		float maxSwing = 1.0F;

		leftarm.rotateAngleX = limbSwingAmount * maxSwing;
		rightarm.rotateAngleX = limbSwingAmount * maxSwing;

	}

}