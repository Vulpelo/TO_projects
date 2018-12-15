package _07_IteratorAndSorting.Sort;

public class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] t) {
        sortProcedure(t, 0, t.length-1);
    }

    private void sortProcedure(int[] arr, int start, int end) {
        if (start < end) {
            int i = splitArray(arr, start, end);
            sortProcedure(arr, start, i-1);
            sortProcedure(arr, i+1, end);
        }
    }

    private int splitArray(int[] arr, int left, int right) {
        int splitPoint = splitPoint(left,  right);
        int value = arr[splitPoint];

        replace(arr, splitPoint, right);

        int actualPos = left;
        for (int i=left; i<right; i++) {
            if (arr[i] < value) {
                replace(arr, i, actualPos);
                actualPos++;
            }
        }
        replace(arr, actualPos, right);
        return actualPos;
    }

    private int splitPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    private void replace(int []arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
