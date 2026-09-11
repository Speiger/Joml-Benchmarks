package benchmark.joml.matrix;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.joml.Matrix4x3f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class BoneAnimation {
	int size;
	Vector3f[] translationStart;
	Quaternionf[] rotationStart;
	Vector3f[] scaleStart;
	
	Vector3f[] translationEnd;
	Quaternionf[] rotationEnd;
	Vector3f[] scaleEnd;
	Matrix4x3f[] inverseMatrices;
	RandomGenerator generator;
	
	public BoneAnimation(int count, RandomGenerator generator) {
		this.size = count;
		translationStart = new Vector3f[count];
		rotationStart = new Quaternionf[count];
		scaleStart = new Vector3f[count];
		
		translationEnd = new Vector3f[count];
		rotationEnd = new Quaternionf[count];
		scaleEnd = new Vector3f[count];
		
		inverseMatrices = new Matrix4x3f[count];
		
		for(int i = 0;i<count;i++) {
			translationStart[i] = new Vector3f((float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian());
			rotationStart[i] = new Quaternionf((float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian()).normalize();
			scaleStart[i] = new Vector3f((float)generator.nextGaussian());
			
			translationEnd[i] = new Vector3f((float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian());
			rotationEnd[i] = new Quaternionf((float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian(), (float)generator.nextGaussian()).normalize();
			scaleEnd[i] = new Vector3f((float)generator.nextGaussian());
			
			inverseMatrices[i] = new Matrix4x3f().translationRotateScale(translationStart[i], rotationStart[i], scaleStart[i]).invert();
		}
		this.generator = RandomGeneratorFactory.getDefault().create(generator.nextLong());
	}
	
	public Matrix4x3f[] process() {
		Matrix4x3f[] results = new Matrix4x3f[size];
		Vector3f translation = new Vector3f();
		Quaternionf rotation = new Quaternionf();
		Vector3f scale = new Vector3f();
		for(int i = 0;i<size;i++) {
			float t = generator.nextFloat();
			Matrix4x3f result = new Matrix4x3f();
			
			translationStart[i].lerp(translationEnd[i], t, translation);
			rotationStart[i].nlerp(rotationEnd[i], t, rotation);
			scaleStart[i].lerp(scaleEnd[i], t, scale);
			results[i] = result.translationRotateScaleMul(translation, rotation, scale, inverseMatrices[i]);
		}
		return results;
	}
}
