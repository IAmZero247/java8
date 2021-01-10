package flatmap;

import org.jooq.lambda.Seq;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JoinUsingStreams {


    public static void main(String[] args) {
        List<Person> list1 = List.of(
                        new Person( 1 ,"Sam"),
                        new Person( 2 ,"Alice"),
                        new Person( 3 ,"Jane"),
                        new Person( 4 ,"Mark"),
                        new Person( 5 ,"Jack")
        );
        List<Item> list2 = List.of(
                new Item( 1 ,1,"Mobile"),
                new Item( 2 ,1,"TV"),
                new Item( 3 ,2,"Fridge"),
                new Item( 4 ,1,"Laptop"),
                new Item( 5 ,3,"Mobile"),
                new Item( 6 ,2,"TV"),
                new Item( 7 ,4,"Fridge"),
                new Item( 8 ,4,"Laptop"),
                new Item( 9, 0,"WaterPurifer")
        );


        //Flatmap - Cross Join
         List<PersonItem> crossJoin = list1.stream().flatMap(
                 p -> list2.stream().map(i-> new PersonItem(p,i))).collect(Collectors.toList());
         System.out.println("crossJoin --> " +crossJoin.size()); //5 * 9
         System.out.println(crossJoin);

         //Flatmap - Inner Join on pId
        List<PersonItem> innerJoin = list1.stream().flatMap(
                p -> list2.stream().map(i-> new PersonItem(p,i)))
                .filter(pi -> pi.item.pId == pi.person.pId)
                .collect(Collectors.toList());
        System.out.println("innerJoin --> " +innerJoin.size()); //5 * 9
        System.out.println(innerJoin);

        //Flatmap - Left Outer Join on pId

        Supplier<Seq<Person>> personSupplier =
                () -> Seq.of(
                new Person( 1 ,"Sam"),
                new Person( 2 ,"Alice"),
                new Person( 3 ,"Jane"),
                new Person( 4 ,"Mark"),
                new Person( 5 ,"Jack")
        );

        Supplier<Seq<Item>> itemSupplier =
                () ->  Seq.of(
                new Item( 1 ,1,"Mobile"),
                new Item( 2 ,1,"TV"),
                new Item( 3 ,2,"Fridge"),
                new Item( 4 ,1,"Laptop"),
                new Item( 5 ,3,"Mobile"),
                new Item( 6 ,2,"TV"),
                new Item( 7 ,4,"Fridge"),
                new Item( 8 ,4,"Laptop"),
                new Item( 9, 0,"WaterPurifer")
        );


        //start with left
        List<PersonItem> leftOuterJoin = personSupplier.get().flatMap(p -> itemSupplier.get().filter(i -> p.pId == i.pId)
                        .onEmpty(null)
                        .map(i -> new PersonItem(p,i)))
                .collect(Collectors.toList());
        System.out.println("leftOuterJoin --> " +leftOuterJoin.size()); //5 * 9
        System.out.println(leftOuterJoin);


        //Flatmap - Right Outer Join on pId

        List<PersonItem> rightOuterJoin = itemSupplier.get().flatMap(i -> personSupplier.get().filter(p -> p.pId == i.pId)
                .onEmpty(null)
                .map(p -> new PersonItem(p,i)))
                .collect(Collectors.toList());
        System.out.println("rightOuterJoin --> " +rightOuterJoin.size()); //5 * 9
        System.out.println(rightOuterJoin);


    }
}
