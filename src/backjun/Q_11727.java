package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11727 {
    private static final int MAX = 1000;
    private static final int[] d = new int[MAX+1];

    public static int sol(int n) {
        if(n == 0 || n == 1) {
            d[n] = 1;
        }else {
            if(d[n-1] == 0) {
                d[n-1] = sol(n-1);
            }
            if(d[n-2] == 0) {
                d[n-2] = sol(n-2);
            }
            d[n] = (d[n-1] + d[n-2] + d[n-2]) % 10007;
        }
        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(sol(n));
    }
}
