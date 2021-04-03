package sample;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEvenAndOddNumbersIntoMap {
    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);

        Map<String, List<Integer>> collect = listA.stream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "even" : "odd"));

        System.out.println(collect);

    }
}
