package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1912 {
    private static final int MAX = 100000;
    private static final int[] D = new int[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String readLine = br.readLine();
        String[] split = readLine.split(" ");

        int[] a = new int[n+1];
        a[0] = -1;
        for (int i = 0; i < split.length; i++) {
            a[i+1] = Integer.parseInt(split[i]);
        }

        int max = 1;
        for(int j = 1; j <= n; j++) {
            D[j] = a[j];
            if(D[j] < D[j-1]+a[j]) {
                D[j] = D[j-1]+a[j];
            }
            if(D[max] < D[j]) {
                max = j;
            }
        }
        System.out.println(D[max]);
    }
}
