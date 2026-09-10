## JOML & JOML2 JMH Benchmark Repository

As JOML 2 is being developed it needs to be tracked how much the library is improving.    
So this repository is intended to provide an easy way to implement benchmarks and to also maybe provide a hub where a lot of benchmarks can be tracked.   

## TODOS

- Implement Benchmark Post Processor.    
	As at the moment we only get JSON results and they are not really human readable.    
	The goal is to provide a Markdown chart that gets automatically generated after a JMH run was done.    


## How to run benchmarks

Pull the repo. Make sure you have jdk25 installed (other jvm versions aren't tested atm)    
and run the following command:    
```
gradle jmh --no-daemon
```

## How to implement new Benchmarks

### Extend existing benchmarks

Create a function with the following schema    
```
@Benchmark
public void testMY_FUNCTION(Blackhole hole) {
//	write your test in here.
}
```       
The blackhole is used to consume objects to ensure java doesn't erase the object and does instant executions.

### Create new Benchmarks (Class)

When you want to create new benchmark class the following has to be provided.    
```
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class MY_BENCHMARK {

}
```    
@BenchmarkMode defines what the target is. Which mode is used depends on the test, but AverageTime is a good default.
@OutputTimeUnit defines which units are used. As the library is rather fast Nanoseconds are required. If the function is slower you can also provide Microseconds
@State defines what scope variables are going to be used in. These are relevant for Setup functions.

### Create new benchmark (Library)

Please create a dedicated folder for the library.    
The idea of the folder format is benchmark/library/section/SpecificClass