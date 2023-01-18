package benchMark;

import bloomFilter.BloomFilter;
import bloomFilter.BloomFilterArray;
import bloomFilter.BloomFilterArrayList;
import bloomFilter.BloomFilterLinkedList;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
@State(Scope.Benchmark) // allows to create objects in the class
@BenchmarkMode(Mode.AverageTime) // Benchmark mode output
@OutputTimeUnit(TimeUnit.NANOSECONDS) // unity
@Warmup(iterations = 0, time = 1, timeUnit = TimeUnit.SECONDS) // Iteration(s) before the measurement
@Measurement(iterations = 6, time = 1, timeUnit = TimeUnit.SECONDS) // Measurement iteration(s)
public class BenchTest {

    // attributes
    BloomFilterArray array = BloomFilterArray.fillArray(3, 1000, 0.1, 0, 100);
    BloomFilterArrayList arrayList = BloomFilterArrayList.fillArray(3, 1000, 0.1, 0, 100);
    BloomFilterLinkedList linkedList = BloomFilterLinkedList.fillArray(3, 1000, 0.1, 0, 100);
    //Benchmarks
    @Benchmark
    public boolean presentArray(){
        return array.isPresent(56);
    }
    @Benchmark
    public boolean presentArrayList(){
        return arrayList.isPresent(56);
    }
    @Benchmark
    public boolean presentLinkedList(){
        return linkedList.isPresent(56);
    }
}
