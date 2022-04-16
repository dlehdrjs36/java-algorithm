package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1476 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        String[] split = readLine.split(" ");
        int e = Integer.parseInt(split[0]);
        int s = Integer.parseInt(split[1]);
        int m = Integer.parseInt(split[2]);

        e -= 1;
        s -= 1;
        m -= 1;
        for (int i=0; ; i++) {
            if ((e == i%15) && (s == i%28) && (m == i%19)) {
                System.out.println(i+1);
                break;
            }
        }
    }
}
