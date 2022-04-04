package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_15990 {
    private static final int MAX = 100000;
    private static final int[][] D = new int[MAX+1][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i <= MAX; i++) {
            if(i-1 >= 0) {
                D[i][1] = D[i-1][2] + D[i-1][3];
                if (i == 1) {
                    D[i][1] = 1;
                }
            }
            if(i-2 >= 0) {
                D[i][2] = D[i-2][1] + D[i-2][3];
                if (i == 2) {
                    D[i][2] = 1;
                }
            }
            if(i-3 >= 0) {
                D[i][3] = D[i-3][1] + D[i-3][2];
                if (i == 3) {
                    D[i][3] = 1;
                }
            }
            D[i][1] %= 1000000009;
            D[i][2] %= 1000000009;
            D[i][3] %= 1000000009;
        }
        while (count-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((D[n][1] + D[n][2] + D[n][3]) % 1000000009);
        }
    }
}
