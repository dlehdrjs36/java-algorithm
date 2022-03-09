package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1699 {
    private static final int MAX = 100000;
    private static final int[] D = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            D[i] = i; // 카드 구매하기2에서 최소 값을 구하는 문제에서는 0으로 하면 안된다. 여기서 i로 넣어주는 이유는 정답이 i를 넘어갈 수 없다. 예) 1의 제곱을 i개 사용하면 개수는 i개 이다. 1의제곱+1의제곱+1의제곱+...+1의제곱 = i
            for (int j = 1; j * j <= i; j++) {
                if(D[i] > D[i - (j * j)] + 1) {
                    D[i] = D[i - (j * j)] + 1;
                }
            }
        }
        System.out.println(D[n]);
    }
}
