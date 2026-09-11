package benchmark.joml.vector;

import java.util.concurrent.TimeUnit;

import org.joml.Vector3f;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Vector3Float {
	Vector3f a;
	Vector3f b;
	
	@Setup(Level.Iteration)
	public void setupMatrix() {
		a = new Vector3f(0.0f, 1.0f, 0.0f);
		b = new Vector3f(1.0f, 0.0f, 0.0f);
	}
	
	@Benchmark
	public Vector3f testCreation() {
		return new Vector3f(1F, 0F, 0F);
	}
	
	@Benchmark
	public Vector3f testExampleCase() {
		Vector3f v = new Vector3f(a);
		Vector3f a = new Vector3f(b);
		v.add(a);
		a.cross(v);
		return a.normalize();
	}
	
	@Benchmark
	public float testAngle() {
		return a.angle(b);
	}
}
