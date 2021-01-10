package fp;

import java.util.List;

public class F02Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //find max using reduce
        int max = numbers.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ?x:y);
        System.out.println(max);

        //find min using reduce
        int min = numbers.stream().reduce(Integer.MAX_VALUE, (x,y)-> x>y ?y:x);
        System.out.println(min);

        //find sum of odd numbers in list
        int sumOfOddNumbers = numbers.stream().filter(i -> i%2 !=0).reduce(0, Integer::sum);
        System.out.println(sumOfOddNumbers);
        //square every number in list and find sum of squares
        int sumOfSquares = numbers.stream().map(i -> i*i).reduce(0, Integer::sum);
        System.out.println(sumOfSquares);
        //cube every number in list and find sum of cubes
        int sumOfCubes = numbers.stream().map(i -> i*i*i).reduce(0, Integer::sum);
        System.out.println(sumOfCubes);



    }
}
