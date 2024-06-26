package search;

public class KMP {

    private static int R = 256;

    private String pattern;

    private int M ;

    private int dfa[][];

    public KMP(String pattern){
        this.pattern = pattern;
        M = pattern.length();
        dfa = new int[R][M];

        dfa[pattern.charAt(0)][0] = 1;

        for (int X=0, j =1; j<M; j++) {
            for (int c =0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pattern.charAt(j)][j] = j+1;

            X = dfa[pattern.charAt(j)][X];
        }

    }

    public int search(String text) {
        int i, j, N = text.length();

        for (i =0, j =0; i< N && j < M; i++) {
            j = dfa[text.charAt(i)][j];
        }

        if(j == M) {
            return i -M;
        } else {
            return N;
        }
    }

}
