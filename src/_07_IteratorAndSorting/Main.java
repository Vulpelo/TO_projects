package _07_IteratorAndSorting;

import _07_IteratorAndSorting.Iterable.ConcreteCollection;
import _07_IteratorAndSorting.Iterable.Iterator.Iterator;
import _07_IteratorAndSorting.Sort.CtxSort;

public class Main {
    private static ConcreteCollection<int[]> list = new ConcreteCollection<>();

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            int[] tab = new int[10];
            for(int j=9; j>=0; j--) {
                tab[j] = 10-j;
            }
            list.addObj(tab);
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

}
