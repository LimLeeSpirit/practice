package javadetail.basic.hashMap;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) // 测试完成时间
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS) // 预热 2 轮，每次 1s
@Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS) // 测试 5 轮，每次 1s
@Fork(1) // fork 1 个线程
@State(Scope.Thread) // 每个测试线程一个实例
public class HashMapCycleTest {
    static Map<Integer, String> map = new HashMap() {{
        for (int i = 0; i < 100; i ++) {
            put(i, "val:" + i);
        }
    }};


    public static void main(String[] args) throws RunnerException {
        // option + command + V,自动补全
        Options optionsBuilder = new OptionsBuilder()
                .include(HashMapCycleTest.class.getSimpleName()) // 要导入的测试类
                .output(System.getProperty("user.dir") + "/" + "resources" + "/" + "jmh-map.log") // 输出测试结果的文件
                .build();
        new Runner(optionsBuilder).run();

    }

    @Benchmark
    public void entrySet() {
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            int key = entry.getKey();
            String val = entry.getValue();
        }
    }

    @Benchmark
    public void foreachEntrySet() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String val = entry.getValue();
        }
    }

    @Benchmark
    public void foreachKeySet() {
        for (int a : map.keySet()) {
            int key = a;
            String val = map.get(a);
        }
    }

    @Benchmark
    public void lambda() {
        map.forEach((key, val) -> {
            int k = key;
            String v = val;
        });
    }

    @Benchmark
    public void streamAPI() {
        map.entrySet().stream().forEach((entry) -> {
            int k = entry.getKey();
            String val = entry.getValue();
        });
    }

    @Benchmark
    public void parallelStreamApi() {
        map.entrySet().parallelStream().forEach((entry) -> {
            int k = entry.getKey();
            String val = entry.getValue();
        });
    }
}
