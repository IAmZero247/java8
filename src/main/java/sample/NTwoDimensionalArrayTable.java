package sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NTwoDimensionalArrayTable {

    public static void main(String[] args) {
        /*
         * 1 2   3  4  5  6
         * 2 4   6  8  10 12
         * 3 6   9  12 15 18
         * 4 8   12 16 20 24
         * 5 10  15 20 25 30
         * 6 12  18 24 30 36
         */

        List<Integer> list1 = IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
        List<Integer[]> flattened = list1.stream().flatMap(i -> list2.stream().map(j -> new Integer[]{i, j}))
                .collect(Collectors.toList());
        flattened.forEach(i -> System.out.println(Arrays.deepToString(i)) );
        //System.out.println(flattened);
    }
}
