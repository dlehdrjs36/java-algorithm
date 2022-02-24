package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/10799">10799번 문제</a>
 */
public class Q_10799 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String readLine = bufferedReader.readLine();
            int result = 0;

            for(int i = 0; i < readLine.length(); i++) {
                char c = readLine.charAt(i);
                if(c == ')') {
                    if(!stack.empty()) {
                        Integer pop = stack.pop();
                        if(pop == i-1) { //바로 이전의 인덱스라면? 레이저
                            int size = stack.size();
                            result += size;
                        }else {
                            result += 1;
                        }
                    }
                }else {
                    stack.push(i); //스택 값의 위치(인덱스)
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
