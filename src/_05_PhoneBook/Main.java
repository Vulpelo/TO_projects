package _05_PhoneBook;

import java.util.List;

public class Main {
    static PhoneBook pB = new PhoneBook();

    public static void main(String[] args) {
        pB.addNewNumber("Damian Praski Polak", "258");
        pB.addNewNumber("Damian Praski", "789");
        pB.addNewNumber("Damian Polak", "123");
        pB.addNewNumber("Damian Praski Polak Mikel", "2528");
        pB.addNewNumber("Damian Polak", "147");
        pB.addNewNumber("Damian Praski", "456");

        findPrintNumbers("Damian Praski");
        findPrintNumbers("Damian Praski Polak Mikel");
    }

    private static void findPrintNumbers(String name) {
        List<Number> a = pB.findNumbers(name);

        printNumbers(name, a);
    }

    private static void printNumbers(String foundName, List<Number> lNum) {
        System.out.println("Numery znalezione dla: " + foundName);
        for (Number n: lNum) {
            System.out.println("- " + n.getNumber());
        };
    }
}
