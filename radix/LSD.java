package radix;

import java.util.Arrays;

public class LSD {


    public static void sort(String a[], int w){
        int N = a.length;
        int R = 256;
        String aux[] = new String[N];

        for (int d = w-1 ; d>=0; d--) {
            int[] count = new int[R +1];
            for (int i =0; i< N; i++){
                char atA = a[i].charAt(d);
                count[atA+1]++;
            }
            System.out.println(Arrays.toString(count));
            for (int i =0; i< R; i++){
                count[i+1] += count[i];
            }
            System.out.println(Arrays.toString(count));

            for( int i =0 ; i< N; i++){
                char atA = a[i].charAt(d);
                aux[count[atA]++] = a[i];
            }

            for (int i =0 ; i< N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
