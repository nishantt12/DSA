import java.util.Arrays;
import java.util.List;

// Implement compareTo
// Start with the 1st element and find the smallest in the array and swap the element
public class SelectionSort {

    public static void sort(Comparable[] items){
        int length = items.length;

        for(int i =0; i<length; i++) {
            for (int j = i ; j< length; j++){
                int minIndex = i;
                if(less(items[j], items[minIndex])){
                    minIndex = j;
                }
                exch(items, i, minIndex);
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static boolean less(Comparable a , Comparable b) {
        return a.compareTo(b) < 0;
    }
}
