package flatmap;

public class PersonItem {
    Person person;
    Item item;

    public PersonItem(Person person, Item item) {
        this.person = person;
        this.item = item;
    }

    @Override
    public String toString() {
        return "PersonItem{" +
                "customer=" + person +
                ", item=" + item +
                '}';
    }
}
