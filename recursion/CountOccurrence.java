package recursion;

public class CountOccurrence {

    public static void main(String args[]) {

        System.out.println("countOccurrence: "+countOccurrence(new int[]{4, 2, 7, 4, 4, 1, 2}, 8, 0, 0));
        System.out.println("countOccurrence: "+countOccurrence2(new int[]{4, 2, 7, 4, 4, 1, 2}, 8, 0));

    }

    private static int countOccurrence(int[] arr, int num, int i, int count) {
        if(i>=arr.length){
            return count;
        }
        count  = arr[i] == num ? count+1 : count;
        return countOccurrence(arr, num, i+1, count);

    }

    private static int countOccurrence2(int[] arr, int num, int i) {
        if(i>=arr.length){
            return 0;
        }
        if(arr[i] == num) {
            return countOccurrence2(arr, num, i+1)+1;
        } else{
            return countOccurrence2(arr, num, i+1);
        }
    }
}
