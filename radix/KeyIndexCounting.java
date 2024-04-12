package radix;

import java.util.Arrays;

public class KeyIndexCounting {

    public static void sort(char a[]){
        int N = a.length;
        int R = 256;
        int[] count = new int[R +1];
        char aux[] = new char[N];

        for (int i =0; i< N; i++){
            count[a[i]+1]++;
        }
        System.out.println(Arrays.toString(count));
        for (int i =0; i< R; i++){
            count[i+1] += count[i];
        }
        System.out.println(Arrays.toString(count));

        for( int i =0 ; i< N; i++){
            aux[count[a[i]]++] = a[i];
        }

        for (int i =0 ; i< N; i++) {
            a[i] = aux[i];
        }
    }

}
