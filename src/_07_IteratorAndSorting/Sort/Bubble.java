package _07_IteratorAndSorting.Sort;

public class Bubble implements SortStrategy {
    @Override
    public void sort(int[] t) {
        for (int i=0; i<t.length; i++) {
            for (int j=1; j<t.length - i; j++) {
                if (t[j-1] > t[j]) {
                    int tmp = t[j];
                    t[j] = t[j-1];
                    t[j-1] = tmp;
                }
            }
        }
    }
}
