package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/2609">2609번 문제</a>
 */
public class Q_2609 {
    public static int gcd(int a, int b) {
        if(b == 0) {
           return a;
        }else {
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String readLine = bufferedReader.readLine();
        String[] split = readLine.split(" ");
        // 자연수
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        int gcd = gcd(a,b); //최대공약수
        int lcm = gcd * a/gcd * b/gcd; //최소공배수

        bufferedWriter.write(String.valueOf(gcd));
        bufferedWriter.write(System.lineSeparator());
        bufferedWriter.write(String.valueOf(lcm));
        bufferedWriter.flush();
    }
}
