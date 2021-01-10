package fp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class F02Programming {
    /* Intermedicate and Terminal Operation
    NOTE -> operation which takes and return stream are called intermediate operations
            eg-> filter , distinct , sort  ,map , peek , parallel
                 All intermediate operation on a stream are lazy, they will execute only when
                 chained with terminal operations

            Terminal Operation -> return something other then streams
            eg forEach -> void
               collect -> Collection
               reduce -> One Element

    */
    /*
     *1) reduce method. List -> One Element
     *2) collect as collections
     *3) distint
     *4) sort
     *5) sort based on custom logic -Comparator.comparing method
     */

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");


        /* 1) find sum of number - useing reduce method
        int sum = addListFunctional(numbers);
        System.out.println(sum);
        // 0 12
		// 12 9
		// 21 13
		// 34 4
		// 38 6
		// 44 2
		// 46 4
		// 50 12
		// 62 15
		// 77
         */

        /* 2) Collectors Samples
        System.out.println(squareList(numbers));
        System.out.println(evenNumbersOnly(numbers));
         */

        /* 3) distinct
        numbers.stream().distinct().forEach(System.out::println);
        */

        /*4) sort
          numbers.stream().sorted().forEach(System.out::println);

          courses.stream().sorted().forEach(System.out::println);
          courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
          courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

          //filter out duplicates and sort
          numbers.stream().distinct().sorted().forEach(System.out::println);
         */


         /*4) Comparator.comparing
         // compare based on length
          courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
         */
        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);






    }

    private static List<Integer> evenNumbersOnly(List<Integer> numbers) {
        return numbers.stream().filter(i-> i%2==0).collect(Collectors.toList());
    }

    private static List<Integer> squareList(List<Integer> numbers) {
        return numbers.stream().map(i-> i*i).collect(Collectors.toList());
    }

    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
                //.reduce(0 ,F02Programming::sum);
                //.reduce(0, Integer::sum);
                .reduce(0 , (x,y) -> x+y);
    }

    public static int sum(int aggregate, int nextNumber){
        return aggregate+nextNumber;
    }
}
