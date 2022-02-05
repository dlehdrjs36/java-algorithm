package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제
괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.

여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.

입력
입력 데이터는 표준 입력을 사용한다.
입력은 T개의 테스트 데이터로 주어진다.
입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.
하나의 괄호 문자열의 길이는 2 이상 50 이하이다.

출력
출력은 표준 출력을 사용한다.
만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.

예제 입력 1
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(

예제 출력 1
NO
NO
YES
NO
YES
NO

예제 입력 2
3
((
))
())(()

예제 출력 2
NO
NO
NO
*/
public class Q_9012_2 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            //입력 데이터 갯수
            String count = bufferedReader.readLine();

            for (int i = 0; i < Integer.parseInt(count); i++) {
                int cnt = 0; // 스택의 크기
                String psLine = bufferedReader.readLine();

                //입력받은 괄호 문자열 라인 분해
                for (int j = 0; j < psLine.length(); j++) {
                    if(psLine.charAt(j) == '(') {
                        cnt++;
                    }else {
                        cnt--;
                        if(cnt < 0) break; //여는 괄호를 다 사용했는데 닫는 괄호가 존재하는 경우. 괄호쌍 미일치
                    }
                }
                if(cnt == 0) {//괄호쌍 일치
                    System.out.println("YES");
                }else {//괄호쌍 미일치
                    System.out.println("NO");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




















