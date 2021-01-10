package fp;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

}


public class F04CustomClass {
    /*1)terminal operations/functions -> AllMatch ,AnyMatch , NoneMatch
      2)sort courses
      3)limit and skip
      4)takeWhile and dropWhile
      5)max(will take last element in sorted collection)
        min(will take first element in sorted collection)
        findFirst findAny ---> All return Optional
      6)sum average and count
      7)group by
     */

    public static void main(String[] args) {
     Course[] array = {
             new Course("Spring", "Framework", 98, 20000),
             new Course("Spring Boot", "Framework", 95, 18000),
             new Course("API", "Microservices", 97, 22000),
             new Course("Microservices", "Microservices", 96, 25000),
             new Course("FullStack", "FullStack", 91, 14000),
             new Course("AWS", "Cloud", 92, 21000),
             new Course("Azure", "Cloud", 99, 21000),
             new Course("Docker", "Cloud", 92, 20000),
             new Course("Kubernetes", "Cloud", 91, 20000)
     };
        List<Course> courses = Arrays.asList(array);



        //1)allmatch , anymatch , nonematch
        Predicate<Course> reviewScoreGreaterThan95Predicate  = x -> x.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate  = x -> x.getReviewScore() > 90;
        Predicate<Course> reviewScoreLesserThan90Predicate  = x -> x.getReviewScore() <90;
        /*
        boolean  allMatchFor95Plus = courses.stream().allMatch(reviewScoreGreaterThan95Predicate );
        boolean  allMatchFor90Plus = courses.stream().allMatch(reviewScoreGreaterThan90Predicate );
        System.out.println("allMatchFor90Plus -> " + allMatchFor90Plus);
        System.out.println("allMatchFor95Plus -> " + allMatchFor95Plus);
        boolean anyMatchFor95Plus = courses.stream().anyMatch(reviewScoreGreaterThan95Predicate );
        boolean anyMatchFor90Minus = courses.stream().anyMatch(reviewScoreLesserThan90Predicate );
        System.out.println("anyMatchFor95Plus -> " + anyMatchFor95Plus);
        System.out.println("anyMatchFor90Minus -> " + anyMatchFor90Minus);
        boolean noneMatchFor90Minus = courses.stream().noneMatch(reviewScoreLesserThan90Predicate);
        boolean noneMatchFor90Plus = courses.stream().noneMatch(reviewScoreGreaterThan90Predicate );
        System.out.println("noneMatchFor90Minus -> " + noneMatchFor90Minus);
        System.out.println("noneMatchFor90Plus -> " + noneMatchFor90Plus);
        */

        //2 -> sort course based on review
        Comparator<Course> comparingByNoOfStudentsIncreasing
                = Comparator.comparingInt(Course::getNoOfStudents); //primitive
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore).reversed();

        List<Course> sortByNumberOfStudentIncreasing = courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents)).collect(Collectors.toList());
        List<Course> sortByNumberOfStudentDecreasing = courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).reversed()).collect(Collectors.toList());
        List<Course> sortByNumberOfStudentIncreasingOptimized = courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList());
        List<Course> sortByNumberOfStudentAndRatingOptimized =courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews)
                .collect(Collectors.toList());
        System.out.println(sortByNumberOfStudentAndRatingOptimized);


        //3) limit and Skip
        /*
         *find first 3 courses with maximum student & rating
         * List<Course> top3RatedCourse = courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).limit(3).collect(Collectors.toList());
         * System.out.println(top3RatedCourse);
         */

        /*
         *find course with 4th,5th and 6TH maximum student & rating
         * List<Course> top456RatedCourse = courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).skip(3).limit(3).collect(Collectors.toList());
         * System.out.println(top456RatedCourse);
         */



        //4) takeWhile and dropWhile
        /*
         * take all course whose rating greater then 95
         * List<Course> courseAbove95Rating = courses.stream()
         *                                 .takeWhile(course -> course.getReviewScore()>=95)
         *                                  .collect(Collectors.toList());
         *System.out.println(courseAbove95Rating);
         */

        /*
         * drop all course whose rating greater then 95
         * List<Course> courseWithRatingTill95 = courses.stream()
         *                                 .dropWhile(course -> course.getReviewScore()>=95)
         *                                  .collect(Collectors.toList());
         *System.out.println(courseWithRatingTill95);
         */

        //5) max min findFirst findAny
        /*find course with min student and rating
         *Optional<Course> opC1 = courses.stream().max(comparingByNoOfStudentsAndNoOfReviews);
         *System.out.println("opC1 ->" + opC1.get());
         */
        /*find course with max student and rating
         *Optional<Course> opC2 = courses.stream().min(comparingByNoOfStudentsAndNoOfReviews);
         *System.out.println("opC2 ->" + opC2.get());
         */

         /*find the firstelement from a collections
          *Optional<Course> firstCourse = courses.stream().findFirst();
          *System.out.println(firstCourse);
          */
         /* some more examples -
         Optional<Course> expectEmpty = courses.stream()
                 .filter(reviewScoreLesserThan90Predicate)
                 .min(comparingByNoOfStudentsAndNoOfReviews);
         System.out.println(expectEmpty);

         Course expectOrElse = courses.stream()
                        .filter(reviewScoreLesserThan90Predicate)
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new Course("OrElseCourse", "Default", 0, 0));
        System.out.println(expectOrElse);
        Course expectFirst = courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .min(comparingByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("OrElseCourse", "Default", 0, 0));
        System.out.println(expectFirst);
        */

         /* findAny
          *Optional<Course> getAnyCourse = courses.stream()
          *      .findAny();
          *System.out.println(getAnyCourse);
          */

         /*sum average and count (all work on primitive only)
          *System.out.println("sumOfStudents :" +courses.stream().mapToInt( x -> x.getNoOfStudents()).sum());
          *System.out.println("averageReview :" +courses.stream().mapToInt( x -> x.getReviewScore()).average());
          *System.out.println("count :" +courses.stream().mapToInt( x -> x.getReviewScore()).count());
          */


        //6) group by
         Map<String, List<Course>> groupByCatagory = courses.stream().collect(Collectors.groupingBy(Course::getCategory ,Collectors.toList()));
         System.out.println(groupByCatagory);
         //{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], FullStack=[FullStack:14000:91], Microservices=[API:22000:97, Microservices:25000:96], Framework=[Spring:20000:98, Spring Boot:18000:95]}
         Map<String, Long> groupByCatagoryAndGetCount = courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
         System.out.println(groupByCatagoryAndGetCount);
         //{Cloud=4, FullStack=1, Microservices=2, Framework=2}
         Comparator comparator =Comparator.comparing(Course::getNoOfStudents).reversed().thenComparing(Course::getReviewScore).reversed();
         Map<String, Optional<Course>> groupByCatagoryAndGetCourseWithMaxStudentAndRating = (Map<String, Optional<Course>>) courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(comparator)));
         System.out.println(groupByCatagoryAndGetCourseWithMaxStudentAndRating);
         //{Cloud=Optional[AWS:21000:92], FullStack=Optional[FullStack:14000:91], Microservices=Optional[Microservices:25000:96], Framework=Optional[Spring:20000:98]}
         Map<String, List<String>> groupByCatagoryAndGetListOfCourses = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())));
         System.out.println(groupByCatagoryAndGetListOfCourses);
         //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}

    }
}
