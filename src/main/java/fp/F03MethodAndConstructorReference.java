package fp;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class F03MethodAndConstructorReference {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");

        courses.stream()
                //.map(str -> str.toUpperCase())
                .map(String::toUpperCase) //instance
                .forEach(F03MethodAndConstructorReference::print); //static


        //Constructor Reference

        Supplier<String> supplierString = String::new;
        String stringSample = supplierString.get();
        System.out.println("stringSample " + stringSample);


        BiFunction<Integer, String , Sample> getSample = Sample::new;
        Sample sample =getSample.apply(10 , "zero");
        System.out.println(sample);


        FIAutomobile auto = Automobile::new;
        Automobile honda = auto.auto("honda", "city", 2010);
        System.out.println(honda);



    }

    private static void print(String str) {
        System.out.println(str);
    }


    static class Sample {
        int num;
        String text;

        private Sample(int num, String text) {
            this.num = num;
            this.text = text;
        }

        @Override
        public String toString() {
            return "Sample{" +
                    "num=" + num +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    static interface  FIAutomobile{
        Automobile auto(String auto, String make, int year);
    }

    static class Automobile {
        String make;
        String model;
        int year;

        public Automobile(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        @Override
        public String toString() {
            return "Automobile{" +
                    "make='" + make + '\'' +
                    ", model='" + model + '\'' +
                    ", year=" + year +
                    '}';
        }
    }

}
