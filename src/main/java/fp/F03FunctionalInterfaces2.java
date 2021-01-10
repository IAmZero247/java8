package fp;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class F03FunctionalInterfaces2 {
    /*
     * BiPredicate
     * BiConsumer
     * BiFunction
     **/

     /*
        The following use with primitive - remove boxing and unboxing
        //IntBinaryOperator

		//IntConsumer
		//IntFunction
		//IntPredicate
		//IntSupplier
		//IntToDoubleFunction
		//IntToLongFunction
		//IntUnaryOperator

		//Int Long, Double
      */
    public static void main(String[] args) {

        //Supplier

        //randomIntSupplier

        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        System.out.println(randomIntegerSupplier.get());


        //Bipredicate
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number<10 && str.length()>4;
        };
        System.out.println(biPredicate.test(0, "iamzero"));


        //BiFunction
        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return str+number;
        };
        System.out.println(biFunction.apply(143, "iamzero"));

        //BiConsumer
        BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept(0, "zero");


    }
}
