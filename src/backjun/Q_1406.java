package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/1406">1406번 문제</a>
 */
public class Q_1406 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        try {
            String str = bufferedReader.readLine();
            //초기 왼쪽 커서 값 설정
            for (int i = 0; i < str.length(); i++) {
                leftStack.push(str.substring(i, i+1));
            }
            String count = bufferedReader.readLine();

            for (int j = 0; j < Integer.parseInt(count); j++) {
                String inputLine = bufferedReader.readLine();
                String[] inputArr = inputLine.split(" ");
                String command = inputArr[0];

                switch (command) {
                    case "L":
                        if(!leftStack.isEmpty()) {
                            String leftStackElement = leftStack.pop();
                            rightStack.push(leftStackElement);
                        }
                        break;
                    case "D":
                        if(!rightStack.isEmpty()) {
                            String rightStackElement = rightStack.pop();
                            leftStack.push(rightStackElement);
                        }
                        break;
                    case "B":
                        if (!leftStack.isEmpty()) {
                            leftStack.pop();
                        }
                        break;
                    case "P":
                        String element = inputArr[1];
                        leftStack.push(element);
                        break;
                    default:
                        System.out.println("해당 명령어는 사용할 수 없습니다.");
                        break;
                }
            }

            while(!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            while(!rightStack.isEmpty()) {
                result.append(rightStack.pop());
            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
