package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11053 {
    private static final int MAX = 1000;
    private static final int[] D = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String readLine = br.readLine();
        String[] split = readLine.split(" ");

        int max = 0;
        for (int i = 0; i < n; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if((Integer.parseInt(split[j]) < Integer.parseInt(split[i])) && (D[i] < (D[j] + 1))) {
                    D[i] =  D[j] + 1;
                }
            }
            if(D[i] > D[max]) {
                max = i;
            }
        }
        System.out.println(D[max]);
    }
}
