package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_15988 {
    private static final int MAX = 1000000;
    private static final int[] D = new int[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        D[0] = 1;
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for (int i = 3; i <= MAX; i++) {
            D[i] = (D[i-1]%1000000009 + D[i-2]%1000000009)%1000000009;
            D[i] = (D[i] + (D[i-3]%1000000009))%1000000009;
        }

        while(count-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(D[n]);
        }
    }
}
