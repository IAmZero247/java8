package fp;

import java.util.ArrayList;
import java.util.List;

public class F09SomeMoreExamples {
    /*
     *replaceAll
     *removeIf
     */
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices",
                "AWS", "PCF","Azure", "Docker", "Kubernetes"); //unmodiable list
        List<String> modifiableList = new ArrayList<>(courses);
        //modify above list with uppercase

        modifiableList.replaceAll( x-> x.toUpperCase());
        System.out.println(modifiableList);

        //remove if length > 5
        modifiableList.removeIf(x -> x.length()>5);
        System.out.println(modifiableList);


    }
}
