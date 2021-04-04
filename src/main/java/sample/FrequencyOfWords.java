package sample;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyOfWords {
    public static void main(String[] args) {
        String str = "Lorem adipising ipsum dolor sit Lorem amet Consectetur adipising elit Lorem ipsum dolor";
        List<String> list = Stream.of(str).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(list);
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        System.out.println(collect);

    }
}
