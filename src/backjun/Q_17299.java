package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/17299">17299번 문제</a>
 */
public class Q_17299 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        try {
            String readLine = bufferedReader.readLine();
            String sequence = bufferedReader.readLine();
            String[] split = sequence.split(" ");
            int[] nge = new int[Integer.parseInt(readLine)];
            //수열에서 나온 횟수 파악
            int[] freq = new int[1000001];

            for (String s : split) {
                freq[Integer.parseInt(s)] += 1;
            }

            stack.push(0); //숫자가 하나만 있는 경우
            for (int i = 1; i < split.length; i++) {
                if(stack.empty()) {
                    stack.push(i);
                }
                while(!stack.empty() && freq[Integer.parseInt(split[stack.peek()])] < freq[Integer.parseInt(split[i])]) {
                    nge[stack.peek()] = Integer.parseInt(split[i]); //오큰수
                    stack.pop();
                }
                stack.push(i);
            }

            while(!stack.empty()) {
                nge[stack.peek()] = -1;
                stack.pop();
            }

            for (int j = 0; j < nge.length; j++) {
                String gubun = j == nge.length-1 ? "" : " ";
                bufferedWriter.write(nge[j]+gubun);
            }
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
