package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1149 {
    private static final int MAX = 1000;
    private static final int[][] D = new int[MAX+1][MAX+1];
    private static final int[][] A = new int[MAX+1][MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while(n != count++) {
            String readLine = br.readLine();
            String[] split = readLine.split(" ");
            int r = Integer.parseInt(split[0]);
            int g = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[2]);
            A[count][1] = r;
            A[count][2] = g;
            A[count][3] = b;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 4; j++) {
                if(j == 1) {
                    D[i][j] = Math.min(D[i - 1][2], D[i - 1][3]) + A[i][j];
                }else if(j == 2) {
                    D[i][j] = Math.min(D[i - 1][1], D[i - 1][3]) + A[i][j];
                }else {
                    D[i][j] = Math.min(D[i - 1][1], D[i - 1][2]) + A[i][j];
                }
            }
        }
        System.out.println(Math.min(Math.min(D[n][1], D[n][2]), D[n][3]));
    }
}
