package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/17413">17413번 문제</a>
 */
public class Q_17413 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = br.readLine();
            boolean tag = false;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '<') { // 첫번째 태그 시작 <, 두번째 태그 시작 <
                    while(!stack.isEmpty()) { //두번째 태그 시작 시, 태그 내용 단어 뒤집기
                        System.out.print(stack.pop());
                    }
                    System.out.print(c);
                    tag = true;
                }else if(c == '>') { // 태그 종료 >
                    System.out.print(c);
                    tag = false;
                }else if(tag) { // 태그 시작과 종료 여부
                    System.out.print(c);
                }else {
                    if(c == ' ') { // 공백으로 단어 구분, 앞의 단어가 입력이 모두 끝난 경우 뒤집기
                        while(!stack.isEmpty()) {
                            System.out.print(stack.pop());
                        }
                        System.out.print(c);
                    } else {
                        stack.push(c);
                    }
                }
            }
            //태그 없이 작성한 문자를 뒤집는 경우, 마지막 단어의 끝은 공백이 아니기 때문에 마지막 문자를 뒤집기 위해 사용
            while(!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
