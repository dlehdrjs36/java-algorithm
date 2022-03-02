package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10872 {
    public static int factorial(int i) {
        if(i == 0) {
            return 1;
        }else {
            return i * factorial(i-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        System.out.println(factorial(num));
    }
}
