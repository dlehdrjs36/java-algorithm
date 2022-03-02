package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int sum = 0;
        //0은 2x5일 때 발생한다. 일반적으로 5의 개수가 적으므로 5의 개수만 검사한다.
        //정확하게 하려면 2의 개수도 검사하여 5의 개수와 일치하는만큼 0의 개수가 결정된다.
        for (int i = 5; i <= num; i *= 5) {
            sum += num/i;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
