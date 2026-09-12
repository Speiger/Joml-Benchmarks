package benchmark.joml2_fields.matrix;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import fields.org.joml2.Float3;
import fields.org.joml2.Float3x4;
import fields.org.joml2.FloatQuat;
import fields.org.joml2.internal.types.Float3Impl;
import fields.org.joml2.internal.types.Float3x4Impl;
import fields.org.joml2.internal.types.FloatQuatImpl;

public class BoneAnimation {
	int size;
	Float3[] translationStart;
	FloatQuat[] rotationStart;
	Float3[] scaleStart;
	
	Float3[] translationEnd;
	FloatQuat[] rotationEnd;
	Float3[] scaleEnd;
	Float3x4[] inverseMatrices;
	RandomGenerator generator;
	
	public BoneAnimation(int count, RandomGenerator generator) {
		this.size = count;
		translationStart = new Float3[count];
		rotationStart = new FloatQuat[count];
		scaleStart = new Float3[count];
		
		translationEnd = new Float3[count];
		rotationEnd = new FloatQuat[count];
		scaleEnd = new Float3[count];
		
		inverseMatrices = new Float3x4[count];
		
		for(int i = 0;i<count;i++) {
			translationStart[i] = new Float3Impl().set((float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian());
			rotationStart[i] = new FloatQuatImpl().set((float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian()).normalize();
			scaleStart[i] = new Float3Impl().set((float)generator.nextGaussian());
			
			translationEnd[i] = new Float3Impl().set((float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian());
			rotationEnd[i] = new FloatQuatImpl().set((float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian()).normalize();
			scaleEnd[i] = new Float3Impl().set((float)generator.nextGaussian());
			
			inverseMatrices[i] = new Float3x4Impl().composeTRS(translationStart[i], rotationStart[i], scaleStart[i]).invert();
			((Float3x4Impl)inverseMatrices[i]).properties = 0;
		}
		this.generator = RandomGeneratorFactory.getDefault().create(generator.nextLong());
	}
	
	public Float3x4[] process() {
		Float3x4[] results = new Float3x4[size];
		Float3 translation = new Float3Impl();
		FloatQuat rotation = new FloatQuatImpl();
		Float3 scale = new Float3Impl();
		for(int i = 0;i<size;i++) {
			float t = generator.nextFloat();
			Float3x4Impl result = new Float3x4Impl();
			
			translationStart[i].lerp(translationEnd[i], t, translation);
			rotationStart[i].nlerp(rotationEnd[i], t, rotation);
			scaleStart[i].lerp(scaleEnd[i], t, scale);
			results[i] = result.composeTRSMul(translation, rotation, scale, inverseMatrices[i]);
		}
		return results;
	}
}
