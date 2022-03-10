package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_9465 {
    private static final int MAX = 100000;
    private static final int[][] D = new int[MAX+1][3];
    private static final int[][] A = new int[MAX+1][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] split = br.readLine().split(" ");
            for (int i = 0; i < split.length; i++) {
                A[i + 1][0] = Integer.parseInt(split[i]);
            }

            String[] split2 = br.readLine().split(" ");
            for (int i = 0; i < split2.length; i++) {
                A[i + 1][1] = Integer.parseInt(split2[i]);
            }

            for (int i = 1; i <= n; i++) {
                D[i][0] = Math.max(Math.max(D[i-1][0], D[i-1][1]), D[i-1][2]);
                D[i][1] = Math.max(D[i-1][0], D[i-1][2]) + A[i][0];
                D[i][2] = Math.max(D[i-1][0], D[i-1][1]) + A[i][1];
            }
            System.out.println(Math.max(Math.max(D[n][0],D[n][1]),D[n][2]));
        }
    }
}
