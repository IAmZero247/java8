package fp;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class F07HigherOrderFunction {
    //function as first class citizen
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<Course> courses = List.of( new Course("Spring", "Framework", 98, 20000),
                                new Course("Spring Boot", "Framework", 95, 18000),
                                new Course("API", "Microservices", 97, 22000),
                                new Course("Microservices", "Microservices", 96, 25000),
                                new Course("FullStack", "FullStack", 91, 14000),
                                new Course("AWS", "Cloud", 92, 21000),
                                new Course("Azure", "Cloud", 99, 21000),
                                new Course("Docker", "Cloud", 92, 20000),
                                new Course("Kubernetes", "Cloud", 91, 20000)
                                );


       List<Course> courseWithReviewScoresHigherThen95 = courses.stream().filter(createPredicateWithCutoffReviewScore2(95)).collect(Collectors.toList());
       List<Integer> cubedNumbers =  mapAndCreateNewList(numbers, x -> x*x*x);

       System.out.println(courseWithReviewScoresHigherThen95);
       System.out.println(cubedNumbers);

    }

    //below are HigherOrderFunction
    public static  Predicate<Course> createPredicateWithCutoffReviewScore1( int cutOffReviewScore){
          return new Predicate<Course>(){
              @Override
              public boolean test(Course course) {
                  return course.getReviewScore() >cutOffReviewScore;
              }
          };
    }

    public static Predicate<Course> createPredicateWithCutoffReviewScore2( int cutOffReviewScore){
        return x -> x.getReviewScore()> cutOffReviewScore;
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction){
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }


}
