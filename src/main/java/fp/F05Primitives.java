package fp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class F05Primitives {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
        int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};
        Stream s1 = Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        Stream s2 = numbers.stream();
        IntStream s3 = IntStream.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        IntStream s4 = Arrays.stream(numberArray);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        //few operations
        System.out.println(Arrays.stream(numberArray).sum());
        System.out.println(Arrays.stream(numberArray).average());
        System.out.println(Arrays.stream(numberArray).count());
        System.out.println(Arrays.stream(numberArray).reduce(0, (x1,x2)-> x1+x2));


        //more on primitive streams - create stream based on alogrithum

        System.out.println(IntStream.range(1, 10).sum());
        System.out.println(IntStream.rangeClosed(1, 10).sum());
        System.out.println(IntStream.iterate(1, i->i+2).limit(10).peek(x-> System.out.print(x + " ")).sum());
        System.out.println(IntStream.iterate(2, i->i*2).limit(10).peek(x-> System.out.print(x + " ")).sum());
        //box to wrapper
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        System.out.println(list);


        //cast to BigInteger - factorial

        int factorial10 = IntStream.rangeClosed(1, 10).reduce(1, (x,y)->x*y);
        System.out.println(factorial10);

        Optional<BigInteger> factorial100 = IntStream.rangeClosed(1,100).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply);
        System.out.println(factorial100.get());


    }
}
