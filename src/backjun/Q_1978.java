package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/1978">1978번 문제</a>
 */
public class Q_1978 {

    public static boolean primeAt(int n) {
        if(n < 2) {
            return false;
        }
        for (int i=2; i*i<=n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String count = br.readLine();
        String num = br.readLine();
        String[] primeArr = num.split(" ");
        int primeCount = 0;

        for (int i=0; i<Integer.parseInt(count); i++) {
            int n = Integer.parseInt(primeArr[i]);
            if(primeAt(n)) {
                primeCount += 1;
            }
        }
        System.out.println(primeCount);
    }
}
