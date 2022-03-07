package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11726 {
    private static final int MAX = 1000;
    private static final int[] D = new int[MAX+1];

    //top-down
    public static int sol(int n) {
        if(n == 0 || n == 1) {
            D[n] = 1;
            return D[n];
        }else {
            if(D[n-1] == 0) {
                D[n-1] = sol(n-1);
            }

            if(D[n-2] == 0) {
                D[n-2] = sol(n-2);
            }

            D[n] = ((D[n-1] % 10007) + (D[n-2] % 10007)) % 10007;
            return D[n];
        }
    }

    //bottom-up
    public static int sol2(int n) {
        D[0] = 1;
        D[1] = 1;
        for (int i = 2; i <= n; i++) {
            D[i] = ((D[i-1] % 10007) + (D[i-2] % 10007)) % 10007;
        }
        return D[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sol = sol(n);
        System.out.println(sol);
        int sol2 = sol2(n);
        System.out.println(sol2);
    }
}
