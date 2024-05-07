package radix;

public class LCP {

    public static int lcp(String first, String second) {

        int length = Math.min(first.length(), second.length());
        for (int i = 0; i< length ; i++){
            if(first.charAt(i) != second.charAt(i)){
                return i;
            }
        }

        return length;
    }
}
