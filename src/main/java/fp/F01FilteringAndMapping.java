package fp;

import java.util.Arrays;
import java.util.List;

public class F01FilteringAndMapping {
    public static void main(String[] args) {
        Integer [] array = {12, 9, 13, 4, 6, 2, 4, 12, 15};
        List<Integer> numbers = Arrays.asList(array);

        /*java 9+
        List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
         */

        printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
        printSquaresOfEvenNumbersInListFunctional(numbers);
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        /*
        1)Do Stream to get one element followed by other
        2)Filter to get even - Lambda
        3)Map to get i*i
        4)Method Reference To Print
        */
        numbers.stream().filter(i->i%2==0).map(i -> i*i).forEach(System.out::print);
        System.out.println();//new line
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(i->i%2==0).forEach(System.out::print);
        System.out.println();//new line
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().forEach(System.out::print);
        System.out.println();//new line
    }

    /*
     private static void print(int number) {
     System.out.println(number);
     }

     private static boolean isEven(int number) {
     return number%2 == 0;
     }
     */
}
