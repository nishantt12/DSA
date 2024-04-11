package sort;

import java.util.Arrays;

public class IndexedMinPQ<Key extends java.lang.Comparable<Key>> {
    private Key[] keys;
    private int[] index;
    private int[] indexReverse;

    private int N;

    public IndexedMinPQ(int capacity) {
        keys = (Key[]) new Comparable[capacity+1];
        index = new int[capacity+1];
        indexReverse = new int[capacity+1];
        for (int i = 0; i < capacity+1; i++){
            index[i] = -1;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int v) {
        return getIndex(v+1) >= 0;
    }

    private int getIndex(int v) {
        return index[v];
    }

    private int getReverseIndex(int v) {
        return indexReverse[v-1];
    }

    public void insert(Key key, int position) {
        keys[++N] = key;
        index[position+1] = N;
        indexReverse[N] = position+1;
        swim(N);
    }

    public void decreaseKey(Key key, int position) {
        int valueIndex = getIndex(position);
        keys[valueIndex] = key;
        swim(valueIndex);
    }

    public Key deleteMin() {
        Key key = keys[1];
        exchange(1, N--);
        sink(1);
        keys[N+1] = null;
        return key;
    }

    public int deleteMinPosition() {
        int position = indexReverse[1] ;
        exchange(1, N--);
        sink(1);
        keys[N+1] = null;

        return position-1;
    }

    public Key[] getHeap(){
        return keys;
    }

    private void swim(int k){
        while (k > 1 && isLess(k, k/2)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j<N && isLess(j+1, j)) {
                j = j+1;
            }
            if (isLess(k, j)){
                break;
            }
            exchange(k,j);
            k = j;
        }
    }

    private boolean isLess(int i, int j) {
        return keys[i].compareTo(keys[j]) < 0;
    }

    private void exchange(int i, int j) {
        System.out.println("Array: "+ Arrays.toString(index)+"   "+Arrays.toString(indexReverse));
        int tempI = i;
        int tempPositionI = getIndex(i);
        int tempPositionJ = getIndex(j);
        System.out.println("Array: "+ tempPositionI+"  "+tempPositionJ+"  "+i+"  "+j);
        int reverseTempI = indexReverse[tempPositionI];
        int reverseTempJ = indexReverse[tempPositionJ];

        Key temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;

        index[i] = index[j];
        index[j] = tempPositionI;

        indexReverse[tempPositionI] = indexReverse[tempPositionJ];
        indexReverse[tempPositionJ] = reverseTempI;
    }

}
