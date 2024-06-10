package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort<T> {

    private static int[] arr = new int[] {3,1,4,5,2,9,8};
//    private static int[] arr = new int[] {3,1,4};
    long Hello;
    private static List<int[]> data = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,1)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,1)));
//        System.out.println(Arrays.toString(arr));
        int[] newSortedArray = sort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newSortedArray));
    }

    private static int[] sort(int[] arr) {
        data.add(arr);
        print();
        if(arr.length <= 1){
            data.remove(data.size()-1);
            print();
            return arr;
        }

        int mid = arr.length/2;
//        System.out.println("Mid: "+mid+" "+arr.length);
        int[] left = sort(Arrays.copyOfRange(arr,0,mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));
        data.remove(data.size()-1);
        print();
        return mergeSorted(left, right);
    }

    private static void print() {
        System.out.println(data.stream()
                .map(Arrays::toString)
                .collect(Collectors.joining(",  ")));
    }

    private static int[] mergeSorted(int[] left, int[] right) {
//        System.out.println("Unsorted Sorted Array: "+Arrays.toString(left)+ "  "+Arrays.toString(right));
        int leftLength = left.length;
        int rightLength = right.length;
        int sortedArray[] = new int[leftLength+rightLength];
        int leftCount =0;
        int rightCount =0;
        while(leftCount<leftLength&&rightCount<rightLength) {
            if(left[leftCount]<right[rightCount]){
                sortedArray[leftCount+rightCount] = left[leftCount];
                leftCount++;
            } else {
                sortedArray[leftCount+rightCount] = right[rightCount];
                rightCount++;
            }
        }

        while (leftCount<leftLength) {
            sortedArray[leftCount+rightCount] = left[leftCount];
            leftCount++;
        }

        while (rightCount<rightLength) {
            sortedArray[leftCount+rightCount] = right[rightCount];
            rightCount++;
        }
//        System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
        return sortedArray;


    }

}
