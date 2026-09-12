# Benchmark Results

## System Information

- Publish Date: 2026-09-11
- OS: Microsoft Windows 10 build 19045
- CPU: AMD Ryzen 9 7900 12-Core Processor             
- Java Version: Eclipse Adoptium - OpenJDK Runtime Environment - Temurin-25.0.3+9
- Consistent Data: Yes


## Libraries Tested
- JOML: 1.10.9
- JOML2 Fields: BETA


## Matrix

### MatrixBenchmarks

|      Function       |       Joml<br>Score       | Joml2<br>Fields<br>Score  |
|---------------------|---------------------------|---------------------------|
|           Creation  |     0,589 ns/op<br>0,049 ±|     0,577 ns/op<br>0,002 ±|
|    MatrixTransform  |     0,582 ns/op<br>0,101 ±|     0,585 ns/op<br>0,005 ±|
|  StandardOperation  |     1,934 ns/op<br>0,018 ±|      4,46 ns/op<br>1,511 ±|

## Vector

### Vector3Float

|   Function    |       Joml<br>Score       | Joml2<br>Fields<br>Score  |
|---------------|---------------------------|---------------------------|
|        Angle  |     0,573 ns/op<br>0,007 ±|     0,695 ns/op<br>0,029 ±|
|     Creation  |     0,214 ns/op<br>0,007 ±|     0,211 ns/op<br>0,002 ±|
|  ExampleCase  |     0,614 ns/op<br>0,006 ±|     0,624 ns/op<br>0,006 ±|

