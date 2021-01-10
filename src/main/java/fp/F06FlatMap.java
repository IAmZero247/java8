package fp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class F06FlatMap {

    /*
     *1) Collectors.Joining
     *2) FlatMap -> Each element of stream replaced with content of MappedString
     *   Arrays::stream
     *   [ [...] ,[...] ,[...], ....] -> [. . . . . . .]
     */
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        String allConcatCourses = courses.stream().collect(Collectors.joining(" "));
        //System.out.println(allConcatCourses);

        /*
        List<String[]> listOfStringArraysFromMap = courses.stream().map(x-> x.split("")).collect(Collectors.toList());
        listOfStringArraysFromMap.stream().forEach(x->System.out.print(Arrays.deepToString(x) + " "));
        */
        /*
        //the above is reduced to single array using reduce
        String [] flattendMap1 = courses.stream().map(x-> x.split("")).reduce( new String[]{} , F06FlatMap::merge );
        System.out.print(Arrays.deepToString(flattendMap1));
         */


        //FlatMap Begins .....
        String[] flattendMap2 = courses.stream()
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)  //flatMap(Stream::of)
                .toArray(String[]::new);
        System.out.print(Arrays.deepToString(flattendMap2));
    }





    public static String [] merge(String [] a1 , String [] a2 ){
        //function concat two string array
        return Stream.of(a1, a2).flatMap(Stream::of).toArray(String[]::new);
    }
}
