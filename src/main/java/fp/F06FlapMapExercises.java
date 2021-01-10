package fp;

import java.util.List;
import java.util.stream.Collectors;

public class F06FlapMapExercises {
    //create tuples for strings of equal length from the list
    public static void main(String[] args) {
        List<String> course1 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> course2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        List<List<String>> tuplesOfSameLength = course1.stream()
                .flatMap(c1 -> course2.stream()
                        .filter(c2 -> c2.length() ==c1.length()) //filter out  elements like [DOCKER, AWS]
                        .map(c2 -> List.of(c1, c2)))
                .filter(e-> !e.get(0).equals(e.get(1))) //filter out element like [AWS, AWS]
        .collect(Collectors.toList());
        System.out.println(tuplesOfSameLength);

    }
}
