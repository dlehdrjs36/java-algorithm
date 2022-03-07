package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/11052">11052번 문제</a>
 */
public class Q_11052 {
    private static final int MAX = 10000;
    private static final int[] D = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String readLine = br.readLine();

        String[] split = readLine.split(" ");
        int[] a = new int[n+1];
        for (int i = 0; i < split.length; i++) {
            a[i+1] = Integer.parseInt(split[i]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                D[i] = Math.max(D[i], D[i-j] + a[j]);
            }
        }
        System.out.println(D[n]);
    }
}
