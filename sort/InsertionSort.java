package sort;

import common.Comparable;

public class InsertionSort<T> {

    // Start with i =0 to n
    // Start j from i to 0
    // if j find element moving back smaller, exchange or else break
    // Idea is everything on the left is already sorted.


    public static <T extends Comparable<? super T>> void sort(T[] items){
        int length = items.length;
        for (int i = 0; i< length; i++) {
            for(int j = i; j>0; j--){

                boolean isLess = less(items[j], items[j-1]);
                if(isLess){
                    exchange(items, j, j-1);
                } else {
                    break;
                }
            }
        }
    }


    private static <T extends Comparable<? super T>> boolean less(T a, T b){
        return a.compareTo(b) < 0;
    }

    private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
