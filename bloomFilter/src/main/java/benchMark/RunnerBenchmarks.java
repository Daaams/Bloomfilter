package benchMark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class RunnerBenchmarks {

    public static void main(String[] args) throws Exception{
        // To run benchmarks with specific options
        Options opt = new OptionsBuilder().forks(5).build();
        new Runner(opt).run();
    }

}
