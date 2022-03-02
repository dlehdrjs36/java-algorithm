package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/1929">1929번 문제</a>
 */
public class Q_1929 {
    public static void sieve(int min, int max) {
        int[] prime = new int[max+1];
        boolean[] check = new boolean[max+1];

        for(int i=2; i<=max; i++) {
            if(check[i] == false) {
                if(i >= min) {
                    prime[i] = i;
                    System.out.println(i);
                }
                for (int j=i*2; j<=max; j+=i) {
                    check[j] = true; //값이 지워지는 경우를 true
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String readLine = bufferedReader.readLine();
        String[] split = readLine.split(" ");

        int min = Integer.parseInt(split[0]);
        int max = Integer.parseInt(split[1]);

        sieve(min, max);
    }
}
