package flatmap;

public class Person {

    int pId;
    String name;


    public Person(int pId, String name) {
        this.pId = pId;
        this.name = name;
    }

    public int getpId() {
        return pId;
    }

    @Override
    public String toString() {
        return "Person{" + pId + '}';
    }
}
