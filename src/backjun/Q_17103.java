package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_17103 {
    private static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int primeCount = 0;
        boolean[] checks = new boolean[MAX+1];
        int[] primes = new int[MAX];
        //체
        checks[0] = true;
        checks[1] = true;
        for (int i = 2; i <= MAX; i++) {
            if(checks[i] == false) { // 체에서 제거가 안된 상태.
                primes[primeCount++] = i;
                for (int j = i + i; j <= MAX; j+=i) {
                    checks[j] = true; // 소수 목록에서 제거
                }
            }
        }

        while(count-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int result = 0;
            //a를 체에서 구한 홀수 소수로 정의
            for (int i = 0; i < primeCount; i++) {
                int b = num-primes[i];

                if(b >= 2 && primes[i] <= b) { // primes[i]가 b보다 커질 때부터 소수의 순서만 다른 것이 나온다.
                    if(checks[b] == false) { // b는 소수
                        result += 1;
                    }
                }else {
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
