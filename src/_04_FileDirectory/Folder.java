package _04_FileDirectory;
import java.util.ArrayList;

public class Folder extends Node {
    protected ArrayList<INode> itemsList = new ArrayList<INode>();

    Folder(String name) {
        this.setName(name);
    }

    public ArrayList<INode> getItemsList() {
        return itemsList;
    }

    public INode getItem(String itemName) {
        return itemsList.get(0);
    }

    public void add(INode item) {
        itemsList.add(item);
    }
}
