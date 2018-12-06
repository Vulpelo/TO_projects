// Delegator: zleca wykonywanie funkcji

public class Validator implements INode {
    private INode node;

    public Validator(INode node) {
        this.node = node;
    }

    @Override
    public void setName(String name) {
        if (checkName(name)) {
            node.setName(name);
        }
    }

    @Override
    public String getName() {
        return node.getName();
    }

    @Override
    public void rename(String name) {
        if (checkName(name)) {
            node.setName(name);
        }
    }

    // checks if give file name is valid
    protected boolean checkName(String name) {
        String tmp = name.toLowerCase();

        for (int i=0; i<tmp.length(); i++) {
            if ( !((tmp.charAt(i) >= 'a' && tmp.charAt(i) <= 'z') || (tmp.charAt(i) >= '0' && tmp.charAt(i) <= '9')) ) {
                return false;
            }
        }
        return true;
    }
}
