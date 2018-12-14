package _07_IteratorAndSorting.Iterable.Iterator;

import java.util.List;

public class ConcreteIterator<T> implements Iterator<T> {
    private List<T> list;
    private int actual = -1;

    public ConcreteIterator(List<T> list) {
        this.list = list;
    }

    public void add(T obj) {

    }

    public void remove(T obj) {

    }

    @Override
    public T next() {
        return list.get(++actual);
    }

    @Override
    public boolean hasNext() {
        return (actual+1 < list.size());
    }
}
