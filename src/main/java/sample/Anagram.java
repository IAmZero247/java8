package sample;

import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        //Anagram
        String s1 = "ABCDA";
        String s2 = "CABAD";
        Map<Character, Integer> m1 = s1.chars().mapToObj(i-> (char) i).collect(Collectors.toMap(i->i.charValue(), i->1, (i1, i2)-> i1+i2));
        Map<Character, Integer> m2 = s2.chars().mapToObj( i-> (char) i).collect(Collectors.toMap(i->i.charValue(), i->1 , (i1,i2) -> i1+ i2));
        System.out.println(m1.equals(m2));
    }
}
