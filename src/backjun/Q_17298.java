package backjun;

import java.io.*;
import java.util.Stack;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/17298">17298번 문제</a>
 */
public class Q_17298 {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        try {
            String readLine = bufferedReader.readLine();
            String sequence  = bufferedReader.readLine();
            String[] nge = new String[Integer.parseInt(readLine)];
            String[] split = sequence.split(" ");

            for (int i = 0; i < split.length; i++) {
                while(!stack.empty() && Integer.parseInt(split[stack.peek()]) < Integer.parseInt(split[i])) {
                    nge[stack.peek()] = split[i]; //오큰수
                    stack.pop();
                }
                stack.push(i);
            }
            while (!stack.empty()) {
                nge[stack.peek()] = "-1";
                stack.pop();
            }
            for (int j = 0; j < nge.length; j++) {
                if(j == nge.length -1)
                    bufferedWriter.write(nge[j]);
                else
                    bufferedWriter.write(nge[j]+" ");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
