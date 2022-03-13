package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_3085 {
    //가장 긴 연속 부분 행 또는 열 찾기
    public static int max(char[][] b) {
        int n = b.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if(b[i][j] == b[i][j-1]) {
                    cnt += 1;
                }else {
                    cnt = 1;
                }
                if (ans < cnt) {
                    ans = cnt;
                }
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if(b[j][i] == b[j-1][i]) {
                    cnt += 1;
                }else {
                    cnt = 1;
                }
                if (ans < cnt) {
                    ans = cnt;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] b = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            b[i] = chars;
        }

        //인접한 사탕 교환
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j+1 < n) {
                    char temp = b[i][j];
                    b[i][j] = b[i][j + 1];
                    b[i][j + 1] = temp;
                    int val = max(b);
                    if(ans < val) {
                        ans = val;
                    }
                    temp = b[i][j];
                    b[i][j] = b[i][j + 1];
                    b[i][j + 1] = temp;
                }
                if (i+1 < n) {
                    char temp = b[i][j];
                    b[i][j] = b[i+1][j];
                    b[i+1][j] = temp;
                    int val = max(b);
                    if(ans < val) {
                        ans = val;
                    }
                    temp = b[i][j];
                    b[i][j] = b[i+1][j];
                    b[i+1][j] = temp;
                }
            }
        }
        System.out.println(ans);
    }
}
