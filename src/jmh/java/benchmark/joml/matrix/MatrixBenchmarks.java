package benchmark.joml.matrix;

import java.util.concurrent.TimeUnit;

import org.joml.Matrix4f;
import org.joml.Vector4f;
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
	private Matrix4f matrix;
	
	@Setup(Level.Iteration)
	public void setupMatrix() {
		matrix = new Matrix4f().translate(32F, 0.5F, 1F).scale(0.25F, 2F, 1F).rotate(ROTATION, 0, 1F, 0);
	}
	
	@Benchmark
	public void testCreation(Blackhole hole) {
		hole.consume(new Matrix4f());
	}
	
	@Benchmark
	public void testStandardOperation(Blackhole hole) {
		hole.consume(new Matrix4f().translate(32F, 0.5F, 1F).scale(0.25F, 2F, 1F).rotate(ROTATION, 0, 1F, 0));
	}
	
	@Benchmark
	public void testMatrixTransform(Blackhole hole) {
		hole.consume(matrix.transform(new Vector4f(1, 3, 6, 1)));
	}
	
}
