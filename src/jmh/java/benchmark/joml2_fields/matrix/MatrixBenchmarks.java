package benchmark.joml2_fields.matrix;

import java.util.concurrent.TimeUnit;

import org.joml2.Float3;
import org.joml2.Float4x4;
import org.joml2.internal.types.Float3Impl;
import org.joml2.internal.types.Float4x4Impl;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class MatrixBenchmarks {
	private static final float ROTATION = (float)Math.toRadians(32D);
	private Float4x4 matrix;
	
	@Setup(Level.Iteration)
	public void setupMatrix() {
		matrix = new Float4x4Impl().translate(32F, 0.5F, 1F).scale(0.25F, 2F, 1F).rotateAxis(ROTATION, 0, 1F, 0);
	}
	
	@Benchmark
	public Float4x4 testCreation() {
		return new Float4x4Impl();
	}
	
	@Benchmark
	public Float4x4 testStandardOperation(Blackhole hole) {
		return new Float4x4Impl()
				.translate(32F, 0.5F, 1F)
				.scale(0.25F, 2F, 1F)
				.rotateAxis(ROTATION, 0, 1F, 0);
	}
	
	@Benchmark
	public Float3 testMatrixTransform(Blackhole hole) {
		return matrix.transformPosition(new Float3Impl().set(1, 3, 6));
	}
	
}
