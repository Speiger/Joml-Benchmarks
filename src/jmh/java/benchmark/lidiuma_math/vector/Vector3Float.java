package benchmark.lidiuma_math.vector;

import lidiuma.org.lidiuma.math.vector.Vec3F32;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
import static lidiuma.org.lidiuma.math.vector.Vectors.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Vector3Float {
	float ax, ay, az;
	float bx, by, bz;
	Vec3F32 a;
	Vec3F32 b;	
	
	@Setup(Level.Iteration)
	public void setupVectors() {
		// Same two unit vectors (~62 degrees apart) as every other library's row.
		ax = 0.309426374F; ay = 0.928279122F; az = 0.206284249F;
		bx = 0.843274043F; by = 0.105409255F; bz = 0.527046277F;
		a = new Vec3F32(ax, ay, az);
		b = new Vec3F32(bx, by, bz);
	}
	
	@Benchmark
	public Vec3F32 testCreation() {
		return new Vec3F32(ax, ay, az);
	}

	@Benchmark
	public Vec3F32 testExampleCase() {
		Vec3F32 c = add(a, b);
		return normalize(cross(b, c));
	}

	@Benchmark
	public float testAngle() {
		final double dot = dot(a, b);
		final double length1 = lengthSquared(a);
		final double length2 = lengthSquared(b);
		final double theta = dot / Math.sqrt(length1 * length2);
		return (float) Math.acos(theta);
	}
}
