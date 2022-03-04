package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/9613">9613번 문제</a>
 */
public class Q_9613 {
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        while(count-- > 0) {
            String readLine = br.readLine();
            String[] split = readLine.split(" ");
            long sum = 0;

            for (int i = 1; i < split.length; i++) {
                for (int j = i + 1; j < split.length; j++) {
                    sum += gcd(Integer.parseInt(split[i]), Integer.parseInt(split[j]));
                }
            }
            System.out.println(sum);
        }
    }
}
