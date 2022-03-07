package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_16194 {
    private static final int MAX = 10000;
    private static final int[] D = new int[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String readLine = br.readLine();
        String[] split = readLine.split(" ");
        int[] p = new int[split.length+1];

        for (int i = 0; i < split.length; i++) {
            p[i+1] = Integer.parseInt(split[i]);
        }

        //배열 초기값이 0이기 떄문에 min계산이 안된다. 따라서 배열 초기화 시 초기값을 잘 설정해야 한다.
        //문제를 보고 정답이 절대로 나올 수 없는 수로 설정한다.
        //카드의 개수 N <= 1000, 카드팩의 가격 <= 10000이기 때문에 정답은 절대로 1000*10000을 넘지 않는다.
//        for (int i = 1; i <= n; i++) {
//            D[i] = 1000*10000;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                D[i] = Math.min(D[i], D[i-j] + p[j]);
//            }
//        }

        //-1 초기화 방법. 위의 방법보다 이 방법을 추천한다.
        //경우의 수를 구하는 경우에는 경우의 수가 0이라는게 정답의 의미를 가질 수 있다.
        for (int i = 1; i <= n; i++) {
            D[i] = -1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(D[i] == -1 | D[i] > D[i-j] + p[j]) {
                    D[i] = D[i - j] + p[j];
                }
            }
        }
        System.out.println(D[n]);
    }
}
