abstract class Node implements INode {
    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void rename(String newName) {
        this.name = newName;
    }
}
