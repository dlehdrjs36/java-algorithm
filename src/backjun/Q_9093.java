package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*

문제
문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다. 단어의 길이는 최대 20, 문장의 길이는 최대 1000이다. 단어와 단어 사이에는 공백이 하나 있다.

출력
각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력한다.

예제 입력 1
2
I am happy today
We want to win the first prize

예제 출력 1
I ma yppah yadot
eW tnaw ot niw eht tsrif ezirp

https://www.acmicpc.net/problem/9093
 */
public class Q_9093 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int count = Integer.parseInt(br.readLine());//테스트 케이스 갯수
            for(int idx = 0; idx < count; idx++) {
                String input = br.readLine();

                for (int x = 0; x < input.length(); x++) {
                    String cc = input.substring(x, x+1);
                    stack.push(cc);

                    if(cc.equals(" ") || x == input.length()-1){
                        StringBuilder rWord = new StringBuilder();
                        String separator = (x == input.length()-1) ? "\n" : "";

                        while(!stack.empty()) {
                            String temp = stack.pop();
                            if(temp.equals(" ")) {
                                separator = temp;
                            }else {
                                rWord.append(temp);
                            }
                        }
                        rWord.append(separator);
                        System.out.print(rWord);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
