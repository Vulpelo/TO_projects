package _04_FileDirectory;

public class Check_Folder extends Folder {

    public Check_Folder(String name) {
        super(name);
    }

    public INode FindElementByName(String fName) {
        for (INode n: itemsList) {
            // don't add file if there is existing file with this same name
            if (n.getName().equals(fName)) {
                return n;
            }
        }
        return null;
    }

    @Override
    public void rename(String nName) {
        Validator val = new Validator(this);
        val.rename(nName);
    }

    @Override
    public void add(INode nNode) {
        // don't add file if there is existing file with this same name
        if (FindElementByName(nNode.getName()) == null) {
            itemsList.add(nNode);
        }
    }

    public void tree(int tab) {
        System.out.println(this.getName());

        for (int i=0; i<itemsList.size(); i++) {
            // draw tabulators
            for ( int j = 0; j<tab; j++) {
                System.out.print('\t');
            }

            // print name
            Check_Folder folder = itemsList.get(i) instanceof Check_Folder ? ( (Check_Folder) itemsList.get(i) ) : null;
            if (folder != null) {
                // recurention
                folder.tree(tab + 1);
            }
            else {
                System.out.println( itemsList.get(i).getName());
            }
        }
    }

    public void ls() {
        System.out.println( this.getName());
        for (int i=0; i<itemsList.size(); i++) {
            System.out.println( '\t' + itemsList.get(i).getName());
        }
    }

}
