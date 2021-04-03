package sample;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Pair {
    String val;
    boolean isPresent;

    public Pair(String val, boolean isPresent) {
        this.val = val;
        this.isPresent = isPresent;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}

public class CheckElementsInOneListWrtAnother {
    public static void main(String[] args) {
        List<String> list1 = List.of( "A" , "B", "C" , "D");
        List <String> list2 = List.of("B" , "V");
        Map<String, Boolean> collect = list2.stream().map(i -> new Pair(i, list1.contains(i))).collect(Collectors.toMap(Pair::getVal, Pair::isPresent));
        System.out.println(collect);
    }
}
