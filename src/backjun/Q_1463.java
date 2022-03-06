package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1463 {
    private static final int MAX = 1000000;
    public static final int[] d = new int[MAX+1];

    //top-down
    public static int sol(int n) {
        if (n == 1) {
            return 0;
        }
        if (d[n] > 0) { // 메모이제이션
            return d[n];
        }
        d[n] = sol(n-1) + 1;
        if(n%2 == 0) {
            int temp = sol(n/2) + 1;
            if(d[n] > temp) {
                d[n] = temp;
            }
        }
        if (n%3 == 0) {
            int temp = sol(n/3) + 1;
            if(d[n] > temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }

    //bottom-up
    public static int sol2(int n) {
        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1;
            if(i%2 == 0 && d[i] > d[n/2] + 1) {
                d[i] = d[n/2] + 1;
            }
            if(i%3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        return d[n];
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
