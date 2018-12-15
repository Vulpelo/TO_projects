package _07_IteratorAndSorting;

import _07_IteratorAndSorting.Iterable.ConcreteCollection;
import _07_IteratorAndSorting.Iterable.Iterator.Iterator;
import _07_IteratorAndSorting.Sort.CtxSort;

import java.util.Random;

public class Main {
    private static ConcreteCollection<int[]> list = new ConcreteCollection<>();

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            list.addObj(randArray(10));
        }

        CtxSort sorting = new CtxSort();
        sorting.sort(list.iterator());

        printCollection();
    }

    private static void printCollection() {
        Iterator<int[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            int[] tmp = iterator.next();
            for (int aTmp : tmp) {
                System.out.print(aTmp + " ");
            }
            System.out.println();
        }
    }

    private static int[] randArray(int len) {
        Random r = new Random();
        int[] arr = new int[len];

        for (int i=0; i<len; i++) {
            arr[i] = r.nextInt(999);
        }

        return arr;
    }

}
