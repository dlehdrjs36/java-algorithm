package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2156 {
    private static final int MAX = 10000;
    private static final int[] D = new int[MAX+1];
    private static final int[] A = new int[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = n;

        while(count-- > 0) {
            int size = Integer.parseInt(br.readLine());
            A[n-count] = size;
        }

        D[1] = A[1];
        D[2] = A[1] + A[2];
        for (int i = 3; i <= n; i++) {
            D[i] = Math.max(Math.max(D[i - 1], D[i - 2] + A[i]), D[i - 3] + A[i - 1] + A[i]);
        }
        System.out.println(D[n]);
    }
}
