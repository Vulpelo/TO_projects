package _05_PhoneBook;

import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    ListNames book = new ListNames();

    public PhoneBook() {

    }

    public List<Number> findNumbers(String name) {
        Scanner sc = new Scanner(name);

        String xName = sc.next();
        Name foundName = book.getName(xName);
        while (sc.hasNext() && foundName != null) {
            xName = sc.next();
            foundName = foundName.getName(xName);
        }

        NumberList tmp = foundName instanceof NumberList ? ((NumberList) foundName) : null;
        if (tmp == null) {
            return null;
        }
        return tmp.getNumbers();
    }

    // return's new prevName
    private ListNames creatingAddingNames(ListNames list, String name, String number, boolean hasNext) {
        // if there is next name
        if (hasNext) {
            Name n = new Name(name);
            list.addName(n);
            return n;
        }
        // if there is no next name; Add number to name
        else {
            NumberList nL = new NumberList(name);
            Number n = new Number(number);
            nL.addNumber(n);
            list.addName(nL);
        }
        return list;
    }

    // return's new prevName
    private ListNames goingByExistingNames(ListNames prevName, ListNames nextName, String name, String number, boolean hasNext) {
        // if there is another name
        if (hasNext) {
            return nextName;
        }
        // if there is no next name
        else {
            NumberList nL = nextName instanceof NumberList ? ((NumberList) nextName) : null;

            // if name isnt already NUmberList (so number cant be added) need to transform to NumberList
            if (nL == null) {
                Name tmpName = nextName instanceof Name ? ((Name) nextName) : null;
                nL = new NumberList(tmpName.getName());
                nL.setNames(tmpName.getNames());
            }

            // adding number to NumberList
            Number n = new Number(number);
            nL.addNumber(n);
            prevName.addName(nL);
        }
        return prevName;
    }

    public void addNewNumber(String name, String number) {
        Scanner sc = new Scanner(name);

        String xName = "ERROR";
        ListNames prevName = book;
        ListNames nextName = null;

        while (sc.hasNext()) {
            xName = sc.next();
            nextName = prevName.getName(xName);

            if (nextName == null) {
                prevName = creatingAddingNames(prevName, xName, number, sc.hasNext());
            }
            else {
                prevName = goingByExistingNames(prevName, nextName, xName, number, sc.hasNext());
            }
        }
    }
}
