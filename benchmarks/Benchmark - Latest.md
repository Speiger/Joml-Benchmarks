# Benchmark Results

## System Information

- Publish Date: 2026-09-11
- OS: Microsoft Windows 10 build 19045
- CPU: AMD Ryzen 9 7900 12-Core Processor             
- Java Version: Eclipse Adoptium - OpenJDK Runtime Environment - Temurin-25.0.3+9
- Consistent Data: Yes
	- jmh=1.36
	- Warmup Iterations=2
	- Warmup Time=3 s
	- Iteratations=5
	- Iteration Time=2 s


## Libraries Tested
- JOML: 1.10.9
- JOML2 Fields: BETA


## Matrix

### Matrix4fBenchmarks

|      Function       |       Joml<br>Score       | Joml2<br>Fields<br>Score  |
|---------------------|---------------------------|---------------------------|
|           Creation  |    0,588 ns/op<br>0,007 Â±|    0,583 ns/op<br>0,014 Â±|
|    MatrixTransform  |    0,596 ns/op<br>0,036 Â±|    0,576 ns/op<br>0,022 Â±|
|  StandardOperation  |    1,925 ns/op<br>0,024 Â±|    4,033 ns/op<br>0,023 Â±|

### Matrix4x3fBenchmarks

|      Function       |        Joml<br>Score         |  Joml2<br>Fields<br>Score   |
|---------------------|------------------------------|-----------------------------|
|      BoneAnimation  |    403,355 ns/op<br>34,717 Â±|    367,731 ns/op<br>6,453 Â±|
|           Creation  |       0,492 ns/op<br>0,011 Â±|      0,506 ns/op<br>0,008 Â±|
|    MatrixTransform  |       0,594 ns/op<br>0,032 Â±|      0,569 ns/op<br>0,005 Â±|
|  StandardOperation  |       1,825 ns/op<br>0,018 Â±|      4,125 ns/op<br>0,035 Â±|

## Vector

### Vector3Float

|   Function    |       Joml<br>Score       | Joml2<br>Fields<br>Score  |
|---------------|---------------------------|---------------------------|
|        Angle  |    0,576 ns/op<br>0,007 Â±|    0,679 ns/op<br>0,021 Â±|
|     Creation  |    0,215 ns/op<br>0,002 Â±|    0,214 ns/op<br>0,004 Â±|
|  ExampleCase  |    0,633 ns/op<br>0,006 Â±|    0,633 ns/op<br>0,048 Â±|

