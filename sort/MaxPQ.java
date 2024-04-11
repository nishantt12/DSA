package sort;// Parent is always greater than children
// Parent access: k/2, children = 2k and 2k+1
// sink = When parent is smaller than children
// swim = When children is larger than parent.
import common.Comparable;
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] keys;

    private int N;

    public MaxPQ(int capacity) {
        keys = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        keys[++N] = key;
        swim(N);
    }

    public Key deleteMax() {
        Key key = keys[1];
        exchange(1, N--);
        sink(1);
        keys[N+1] = null;
        return key;
    }

    public Key[] getHeap(){
        return keys;
    }

    private void swim(int k){
        while (k > 1 && isLess(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j<N && isLess(j, j+1)) {
                j = j+1;
            }
            if (isLess(j, k)){
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
        Key temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }

}
