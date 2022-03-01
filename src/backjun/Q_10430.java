package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/10430">10430번 문제</a>
 */
public class Q_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String readLine = bufferedReader.readLine();
        String[] split = readLine.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);

        //(A+B) % C
        bufferedWriter.write(String.valueOf((a + b) % c));
        bufferedWriter.write(System.lineSeparator());
        //((A % C)+(B % C)) % C
        bufferedWriter.write(String.valueOf(((a % c) + (b % c)) % c));
        bufferedWriter.write(System.lineSeparator());
        //(A×B)%C
        bufferedWriter.write(String.valueOf((a * b) % c));
        bufferedWriter.write(System.lineSeparator());
        //((A%C) × (B%C))%C
        bufferedWriter.write(String.valueOf(((a % c) * (b % c)) % c));
        bufferedWriter.flush();
    }
}
