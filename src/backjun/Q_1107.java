package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1107 {

    private static final boolean[] mArr = new boolean[10];

    public static int sol(int n) {

        //0번 채널로 이동하려는 경우
        if(n == 0) {
            if(mArr[n]) {
                return 0;
            }else {
                return 1;
            }
        }

        int count = 0;
        while(n > 0) {
            //고장난 숫자 버튼
            if (mArr[n%10]) {
                return 0;
            }
            count += 1;

            n /= 10;
        }
        System.out.println("count = " + count);
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼 수
        
        if(m > 0) {
            String readLine = br.readLine();
            String[] split = readLine.split(" ");
            for (int i = 0; i < split.length; i++) {
                mArr[Integer.parseInt(split[i])] = true;
            }
        }

        int an = n - 100;
        if (an < 0) {
            an = -an;
        }

        for (int i = 0; i <= 1000000; i++) {
            int c = i; //  숫자 버튼을 눌러서 이동하는 채널
            int sol = sol(c); // 숫자 버튼 누르는 횟수

            if (sol > 0) {
                int press = c - n; // + 버튼 횟수

                if(press < 0) {
                    press = -press; // - 버튼 횟수
                }
                //기존 정답이 최소 값보다 큰 경우 대체
                if(an > sol + press) {
                    an = sol + press;
                }
            }
        }
        System.out.println(an);
    }
}
