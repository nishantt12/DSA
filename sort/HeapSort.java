package sort;// How to build the Binary heap// Check again
// Rest same as BinaryHeap

import common.Comparable;
import graph.Graph;

import java.util.Arrays;

public class HeapSort {

    private static int N;

    public static <Key extends Comparable<Key>> void sort(Key[] items) {
        N = items.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(items, k);
        }
//        System.out.println(Arrays.toString(items));
        while (N>=1){
            System.out.println("BAfore "+ Arrays.toString(items)+" "+N);
            exchange(items, 1, N--);
            System.out.println("Before "+ Arrays.toString(items)+" "+N);
            sink(items, 1);
            System.out.println("After  "+Arrays.toString(items)+" "+N);
        }
    }

    private static <Key extends Comparable<Key>> void sink(Comparable<Key>[] keys, int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (N > j && isLess(keys, j, j + 1)) {
                j++;
            }

            if (isLess(keys, j, k)) {
                break;
            }
            exchange(keys, j,k);
            k = j;
        }
    }

    private static <Key extends Comparable<Key>> boolean isLess(Comparable<Key>[] keys, int i, int j) {
        return keys[i-1].compareTo((Key) keys[j-1]) < 0;
    }

    private static <Key extends Comparable<Key>> void exchange(Comparable<Key>[] keys, int i, int j) {
        Key temp = (Key) keys[i-1];
        keys[i-1] = keys[j-1];
        keys[j-1] = temp;
    }

}

