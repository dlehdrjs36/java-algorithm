package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/1934">1934번 문제</a>
 */
public class Q_1934 {
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String readLine = bufferedReader.readLine();
        int count = Integer.parseInt(readLine);

        while(count != 0) {
            String ab = bufferedReader.readLine();
            String[] split = ab.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int gcd = gcd(a, b);
            int lcm =  gcd * a/gcd * b/gcd;
            System.out.println(lcm);
            count--;
        }
    }
}
