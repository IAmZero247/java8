package fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class F11Files {
    public static void main(String[] args) throws IOException {
        //find all unique words in file
        List<String> collect = Files.lines(Paths.get("sampleFile.txt"))
                .map(i -> i.split(" ")) //List<String>
                .flatMap(Stream::of)          //flatMap(Arrays::stream)
                . filter(i -> i.trim().length()!=0) //filter out spaces
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(collect);

        //find all directories
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);


    }
}
