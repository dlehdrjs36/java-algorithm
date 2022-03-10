package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2839 {
    private static final int MAX = 5000;
    private static final int[] D = new int[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= MAX; i++) {
            D[i] = -1;
        }
        D[3] = 1;
        D[5] = 1;
        for (int i = 6; i <= MAX; i++) {
            if(D[i-3] != -1) {
                D[i] = D[i - 3] + 1;
            }
            if(D[i-5] != -1) {
                if(D[i] == -1 || D[i] > D[i-5] + 1) {
                    D[i] = D[i - 5] + 1;
                }
            }
        }
        System.out.println(D[n]);
    }
}
