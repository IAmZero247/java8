package fp;

import java.util.stream.LongStream;

public class F08Parallel {

    public static void main(String[] args) {
        //withoutParallel -> 623
        //withParallel -> 171
        long time = System.currentTimeMillis();
        //System.out.println(LongStream.range(0,1000000000).sum());
        System.out.println(LongStream.range(0,1000000000).parallel().sum());
        System.out.println(System.currentTimeMillis() - time);
    }
}
