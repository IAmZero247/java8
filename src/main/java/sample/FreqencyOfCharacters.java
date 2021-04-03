package sample;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FreqencyOfCharacters {

    public static void main(String[] args) {

        String s1 = "ABCDA";
        String s2 = "CABAD";

        System.out.println(frequencyMap(s1.chars().mapToObj(i-> (char) i )));

    }

    public static <Character> Map<Character, Long> frequencyMap(Stream<Character> elements) {
        return elements.collect(
                Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new, // can be skipped
                        Collectors.counting()
                )
        );
    }


}
