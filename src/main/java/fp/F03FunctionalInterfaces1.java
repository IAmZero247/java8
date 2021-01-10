package fp;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class F03FunctionalInterfaces1 {
    /*
     * Predicate
     * Function
     * Consumer
     * Supplier  --> F03FunctionalInterfaces2
     *
     * BinaryOperator -> Take T, T & Return T
     *        Usage -> Integer::sum
     *
     * UnaryOperator Take T & Return T
     *       Usage -> x-> x*x
     *
     *
     * Use below when you operate on streams from primitives - avoid boxing n unboxing
     * IntBinaryOperator    --> primitive int
     * LongBinaryOperator   -->           long
     * DoubleBinaryOperator -->           double
     *
     * IntUnaryOperator    --> primitive int
     * LongUnaryOperator   -->           long
     * DoubleUnaryOperator -->           double
     *
     */




    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        /*
        numbers.stream().filter(x -> x%2 ==0).map(x->x*x).forEach(System.out::println);
        step 1 -> extract the predicate
         */
        Predicate<Integer> isEvenPredicate = x -> x%2 ==0;
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }

        };
        /*
        //numbers.stream().filter(isEvenPredicate).map(x->x*x).forEach(System.out::println);
        step 2 -> extract function
         */
        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }

        };
        /*
        //numbers.stream().filter(isEvenPredicate).map(squareFunction2).forEach(System.out::println);
        step 3 -> extract consumer
         */
        Consumer<Integer> sysoutConsumer = System.out::println;

        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            public void accept(Integer x) {
                System.out.println(x);
            }
        };
        numbers.stream().filter(isEvenPredicate2).map(squareFunction2).forEach(sysoutConsumer2);


        //Binary Operator Starts From Here ....

        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        //BinaryOperator<Integer> sumBinaryOperator = (x,y) => x + y;


        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                // TODO Auto-generated method stub
                return a + b;
            }

        };

        int sum = numbers.stream()
                .reduce(0, sumBinaryOperator);

        System.out.println("Sum --> "+  sum);


        //Unary Operator Starts From Here ....


        UnaryOperator getSquare = new UnaryOperator<Integer>( ){


            @Override
            public Integer apply(Integer i) {
                return i * i;
            }
        };
        System.out.println("SquaredList --> "+ numbers.stream().map(getSquare).collect(Collectors.toList()));


    }
}
