package benchmark.joml.matrix;

import java.util.concurrent.TimeUnit;
import java.util.random.RandomGeneratorFactory;

import org.joml.Matrix4x3f;
import org.joml.Vector4f;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Matrix4x3fBenchmarks {
	private static final float ROTATION = (float)Math.toRadians(32D);
	private Matrix4x3f matrix;
	
	@Setup(Level.Iteration)
	public void setupMatrix() {
		matrix = new Matrix4x3f().translate(32F, 0.5F, 1F).scale(0.25F, 2F, 1F).rotate(ROTATION, 0, 1F, 0);
	}
	
	@Benchmark
	public Matrix4x3f testCreation() {
		return new Matrix4x3f();
	}
	
	@Benchmark
	public Matrix4x3f testStandardOperation() {
		return new Matrix4x3f().translate(32F, 0.5F, 1F).scale(0.25F, 2F, 1F).rotate(ROTATION, 0, 1F, 0);
	}
	
	@Benchmark
	public Vector4f testMatrixTransform() {
		return matrix.transform(new Vector4f(1, 3, 6, 1));
	}
	
	@Benchmark
	public Matrix4x3f[] testBoneAnimation(AnimationContainer container) {
		return container.animation.process();
	}
	
	@State(Scope.Benchmark)
	public static class AnimationContainer {
		private BoneAnimation animation;
		
		@Param("100")
		public int operationMultiplier;
		
		@Setup(Level.Iteration)
		public void setupContainer() {
			animation = new BoneAnimation(operationMultiplier, RandomGeneratorFactory.getDefault().create(32231212134522L));
		}
	}
}
