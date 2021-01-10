package fp;


import java.util.List;

public class F01Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        /* print all courses
        courses.stream().forEach(System.out::println);
        */

        /* print all courses containing spring
           courses.stream().filter(i->i.contains("Spring")).forEach(System.out::println);
        */

        /* print all courses whose length >4
            courses.stream().filter(i->i.length() >4 ).forEach(System.out::println);
        */


        /* print length of all course
            courses.stream().map(i-> i.length()).forEach(System.out::println);
        */

        /* print course->length format
           courses.stream().map(i-> i +" -> " + i.length()).forEach(System.out::println);
        */



         /* print odd Numbers in list
        printOddNumbersInListFunctional(numbers);
         */

         /* print cubes of odd Numbers in list
        printCubesOfOddNumbersInListFunctional(numbers)
         */



        printCubesOfOddNumbersInListFunctional(numbers);







    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(i -> i%2 !=0).forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(i -> i%2 !=0).map(i->i*i*i).forEach(System.out::println);
    }

}
