package _07_IteratorAndSorting.Sort;


import _07_IteratorAndSorting.Iterable.Iterator.Iterator;

public class CtxSort {
    private SortStrategy sortStrategy;

    public CtxSort() {
        sortStrategy = new QuickSort();
    }

    public void sort(Iterator<int[]> iterator) {
        while (iterator.hasNext()) {
            sortStrategy.sort( iterator.next() );
        }
    }

    public void setStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

}
