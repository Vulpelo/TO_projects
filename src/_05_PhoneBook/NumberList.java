package _05_PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class NumberList extends Name {
    List<Number> numbers = new ArrayList<Number>();

    public NumberList (String name) {
        super(name);
    }

    public List<Number> getNumbers() {
        return numbers;
    }


    public void addNumber(Number number) {
        numbers.add(number);
    }
}
