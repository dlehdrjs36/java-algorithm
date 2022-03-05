package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/17087">17087번 문제</a>
 */
public class Q_17087 {
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
        int n = Integer.parseInt(split[0]);
        int s = Integer.parseInt(split[1]);
        int[] distance = new int[n];

        String readLine1 = bufferedReader.readLine();
        String[] split1 = readLine1.split(" ");
        int gcd = 0;

        for (int i = 0; i < n; i++) {
            distance[i] = Math.abs(s - Integer.parseInt(split1[i]));
        }

        if(n == 1) { // 동생이 한 명인 경우, 거리 차가 최대 공약수
            gcd = distance[0];
        }else { // 동생이 여러 명인 경우, 모든 동생의 거리 차를 만족하는 최대 공약수를 구한다.
            gcd = gcd(distance[0], distance[1]);
            for (int i = 2; i < n; i++) {
                gcd = gcd(gcd, distance[i]);
            }
        }
        bufferedWriter.write(String.valueOf(gcd));
        bufferedWriter.flush();
    }
}
