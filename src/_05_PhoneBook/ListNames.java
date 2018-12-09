package _05_PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class ListNames {
    protected List<Name> names = new ArrayList<Name>();

    public Name getName(String name) {
        for (Name n: names) {
            if (n.getName().equals(name)) {
                return n;
            }
        }

        // TODO: if there is no name, add one to the list.
        return null;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> n) {
        this.names = n;
    }

    public void addName(Name nName) {
        // deleting name that exists in array
        for (int i=0; i<names.size(); i++) {
            if ( names.get(i).getName().equals(nName.getName()) ) {
                names.remove(i);
                break;
            }
        }
        names.add(nName);
    }
}
