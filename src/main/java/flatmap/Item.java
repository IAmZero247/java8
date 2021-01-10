package flatmap;

public class Item {
    int id;
    int pId;
    String name;

    public int getpId() {
        return pId;
    }

    public Item(int id, int pId, String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" + id +"," + pId + '}';
    }
}
