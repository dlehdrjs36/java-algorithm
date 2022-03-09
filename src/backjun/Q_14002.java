package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_14002 {
    private static final int MAX = 1000;
    private static final int[] D = new int[MAX + 1];
    private static final int[] V = new int[MAX + 1];

    public static void go(int index, String[] a) {
        if(index == -1) {
            return;
        }
        go(V[index], a);
        if(index == 0) {
            System.out.print(a[index]);
        }else {
            System.out.print(" " + a[index]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String readLine = br.readLine();
        String[] split = readLine.split(" ");

        int max = 0;
        for (int i = 0; i < n; i++) {
            D[i] = 1;
            V[i] = -1;
            for (int j = 0; j < i; j++) {
                if((Integer.parseInt(split[j]) < Integer.parseInt(split[i])) && (D[i] < (D[j] + 1))) {
                    D[i] =  D[j] + 1;
                    V[i] = j; //이전 인덱스가 j일 때 가장 큰 길이를 가진다.
                }
            }
            if(D[i] > D[max]) {
                max = i;
            }
        }
        System.out.println(D[max]);
        go(max, split);
    }
}
