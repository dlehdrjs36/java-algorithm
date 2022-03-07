package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_9095 {
    private static final int[] D = new int[11];

    public static int sol(int n) {
        D[0] = 1;
        D[1] = 1;
        D[2] = 2;
        for (int i = 3; i <= n; i++) {
            D[i] = D[i-1] + D[i-2] + D[i-3];
        }
        return D[n];
    }

    //백준 슬라이드 코드
    public static int sol2(int n) {
        D[0] = 1;
        for (int i = 1; i <= 10; i++) {
            //1이 마지막, 2가 마지막, 3이 마지막이 오는 경우 검사
            for (int j = 1; j <= 3; j++) {
                if (i-j >= 0) {
                    D[i] += D[i-j];
                }
            }
        }
        return D[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        while(count-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(sol(n));
        }
    }
}
