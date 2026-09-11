# Benchmark Results

## System Information

- Publish Date: 2026-09-12
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
|           Creation  |    0,592 ns/op<br>0,007 Â±|    0,603 ns/op<br>0,034 Â±|
|    MatrixTransform  |    0,589 ns/op<br>0,012 Â±|    0,608 ns/op<br>0,016 Â±|
|  StandardOperation  |    1,876 ns/op<br>0,007 Â±|    4,232 ns/op<br>0,131 Â±|

### Matrix4x3fBenchmarks

|      Function       |       Joml<br>Score       | Joml2<br>Fields<br>Score  |
|---------------------|---------------------------|---------------------------|
|      BoneAnimation  |    3,955 ns/op<br>0,138 Â±|    3,715 ns/op<br>0,171 Â±|
|           Creation  |     0,49 ns/op<br>0,008 Â±|    0,515 ns/op<br>0,005 Â±|
|    MatrixTransform  |    0,594 ns/op<br>0,012 Â±|    0,602 ns/op<br>0,082 Â±|
|  StandardOperation  |    1,853 ns/op<br>0,016 Â±|    4,252 ns/op<br>0,046 Â±|

## Vector

### Vector3Float

|   Function    |       Joml<br>Score       | Joml2<br>Fields<br>Score  |
|---------------|---------------------------|---------------------------|
|        Angle  |    0,583 ns/op<br>0,004 Â±|    0,699 ns/op<br>0,082 Â±|
|     Creation  |    0,218 ns/op<br>0,005 Â±|    0,218 ns/op<br>0,007 Â±|
|  ExampleCase  |    0,657 ns/op<br>0,008 Â±|    0,648 ns/op<br>0,043 Â±|

