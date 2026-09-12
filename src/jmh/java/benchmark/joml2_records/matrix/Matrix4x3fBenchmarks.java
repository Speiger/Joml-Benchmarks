package benchmark.joml2_records.matrix;

import java.util.concurrent.TimeUnit;
import java.util.random.RandomGeneratorFactory;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import records.org.joml2.Float3;
import records.org.joml2.Float3x4;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Matrix4x3fBenchmarks {
	private static final float ROTATION = (float)Math.toRadians(32D);
	private Float3x4 matrix;

	@Setup(Level.Iteration)
	public void setupMatrix() {
		matrix = Float3x4.composeTRS(32F, 0.5F, 1F, 0.25F, 2F, 1F, ROTATION, 0, 1F, 0);
	}
	
	@Benchmark
	public Float3x4 testCreation() {
		return new Float3x4();
	}
	
	@Benchmark
	public Float3x4 testStandardOperation() {
		return Float3x4.composeTRS(32F, 0.5F, 1F, 0.25F, 2F, 1F, ROTATION, 0, 1F, 0);
	}
	
	@Benchmark
	public Float3 testMatrixTransform() {
		return matrix.transformPosition(new Float3(1, 3, 6));
	}
	
	@Benchmark
	public Float3x4[] testBoneAnimation(AnimationContainer container) {
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
