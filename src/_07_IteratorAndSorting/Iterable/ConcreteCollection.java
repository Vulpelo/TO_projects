package _07_IteratorAndSorting.Iterable;

import _07_IteratorAndSorting.Iterable.Iterator.ConcreteIterator;
import _07_IteratorAndSorting.Iterable.Iterator.Iterator;

import java.util.List;
import java.util.ArrayList;

public class ConcreteCollection<T> implements Iterable<T> {
    private List<T> list = new ArrayList<T>();

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new ConcreteIterator<T>(list);
    }

    public void addObj(T obj) {
        list.add(obj);
    }
}
