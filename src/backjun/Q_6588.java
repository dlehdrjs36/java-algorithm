package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Q_6588 {
    private static final int MAX = 1000000;

    //1.짝수 범위에 해당하는 소수 구하기
    public static Map<String, Object> sieve() {
        Map<String, Object> map = new HashMap<>();

        int[] primes = new int[MAX+1];
        boolean[] checks = new boolean[MAX+1];
        int primeCount = 0;

        //1.짝수의 소수 판별
        for (int i = 2; i <= MAX; i++) {
            if(checks[i] == false) {
                primes[primeCount++] = i;
                for (int j=i*2; j<=MAX; j+=i) {
                    checks[j] = true; //값 지우기
                }
            }
        }

        map.put("primes", primes);
        map.put("checks", checks);
        map.put("primeCount", primeCount);

        return map;
    }

    //2. 소수의 합으로 짝수를 표현할 수 있는지 확인
    public static void solution(int even, Map<String, Object> sleve) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] primes = (int[]) sleve.get("primes");
        boolean[] checks = (boolean[]) sleve.get("checks");
        int primeCount = (int) sleve.get("primeCount");

        if(even%2 != 0) {
            bw.write("Goldbach's conjecture is wrong.");
            bw.write(System.lineSeparator());
            bw.flush();
        }

        for (int i = 1; i < primeCount; i++) {
            //N = a + b;
            //b = N - a
            //prime[i]를 a로 가정
            //b가 소수일 경우 a가 가장 작은 값이 되는 경우가 b가 가장 큰 값. a가 가장 작은 값이 되는 경우는 처음으로 b가 소수인 경우
            //짝수는 홀수인 소수의 여러 조합으로 구성될 수 있다. 여기서 b-a가 가장 큰 경우를 출력한다.
            if(checks[even - primes[i]] == false) { //b가 소수냐?
                bw.write(even + " = " + primes[i] + " + " + (even - primes[i]));
                bw.write(System.lineSeparator());
                bw.flush();
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Object> sieve = sieve();

        while(true) {
            int even = Integer.parseInt(br.readLine());
            if(even == 0) { //0이 입력된 경우 종료.
                break;
            }
            solution(even, sieve);
        }
    }
}
