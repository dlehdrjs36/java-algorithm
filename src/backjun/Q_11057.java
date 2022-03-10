package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11057 {
    private static final int MAX = 1000;
    private static final int[][] D = new int[MAX+1][MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    D[i][j] += D[i-1][k];
                    D[i][j] %= 10007;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += D[n][i];
        }
        System.out.println(ans%10007);
    }
}
