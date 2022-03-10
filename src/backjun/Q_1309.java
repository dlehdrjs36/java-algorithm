package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1309 {
    private static final int MAX = 100000;
    private static final int[][] D = new int[MAX+1][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //경우의 수
        D[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            D[i][0] = D[i-1][0] + D[i-1][1] + D[i-1][2];
            D[i][1] = D[i-1][0] + D[i-1][2];
            D[i][2] = D[i-1][0] + D[i-1][1];
            for (int j = 0; j < 3; j++) {
                D[i][j] %= 9901;
            }
        }
        System.out.println((D[n][0] + D[n][1] + D[n][2]) % 9901);
    }
}
