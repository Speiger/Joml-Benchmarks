package benchmark.joml.vector;

import java.util.concurrent.TimeUnit;

import org.joml.Vector3f;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Vector3Float {
	
	@Benchmark
	public void testCreation(Blackhole hole) {
		hole.consume(new Vector3f(1F, 0F, 0F));
	}
	
	@Benchmark
	public void testExampleCase(Blackhole hole) {
		Vector3f v = new Vector3f(0.0f, 1.0f, 0.0f);
		Vector3f a = new Vector3f(1.0f, 0.0f, 0.0f);
		v.add(a);
		a.cross(v);
		hole.consume(a.normalize());
	}
	
	@Benchmark
	public void testAngle(Blackhole hole) {
		Vector3f center = new Vector3f(0.0f, 1.0f, 0.0f);
		Vector3f angle = new Vector3f(1.0f, 0.0f, 0.0f);
		hole.consume(center.angle(angle));
	}
}
