package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[10];
        int count = 0;
        int sum = 0;

        while(count++ < 9) {
            a[count] = Integer.parseInt(br.readLine());
            sum += a[count];
        }
        Arrays.sort(a);

        outer:
        for (int i = 1; i <= 9; i++) {
            for (int j = i+1; j <= 9; j++) {
                if(sum - a[i] - a[j] == 100) {
                    for (int k = 1; k <= 9; k++) {
                        if(i == k || j == k) {
                            continue;
                        }
                        System.out.println(a[k]);
                    }
                    break outer;
                }
            }
        }
    }
}
