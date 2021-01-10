package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ShiftBasedOnK {

    public static void main(String[] args) {
        //shift based on k
        int[] array = new int[]{1, 2, 3, 4, 5};
        int k = 2;
        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toList());
        int[] result = Stream.of(list.subList(k, list.size()).toArray(), list.subList(0, k).toArray()).flatMap(Stream::of).map(Object::toString).mapToInt(Integer::valueOf).toArray();
    }



    //int[] array = new int []{​​​​​1,2,3,4,5}​​​​​;
    //int k =2 ;
    //List<Integer>list = IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList());
    //List<Integer>  result = Stream.of(Stream.of(list.subList(k, list.size()).toArray(), list.subList(0,k).toArray()).flatMap(Stream::of).toArray()).map(Object::toString).map(Integer::valueOf).collect(Collectors.toList());


}