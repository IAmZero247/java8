package sample;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FreqencyOfCharacters {

    public static void main(String[] args) {

        String s1 = "ABCDA";
        String s2 = "CABAD";

        //FirstApproach Using to Map
        //Step 1 -> convert to intstream
        Stream<Character> characterStreamOfS1 = s1.chars().mapToObj(c -> (char) c);
        // Step 2 -> map of character with count
        Map<Character, Integer> collectOfS1 = characterStreamOfS1.collect(Collectors.toMap( c->c.charValue(), c -> 1, Integer::sum));
        System.out.println(collectOfS1);


        //SecondApproach - Using Group By
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
