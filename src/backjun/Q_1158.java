package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/1158">1158번 문제</a>
 */
public class Q_1158 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split(" ");
            String N = split[0];
            String K = split[1];
            //수 넣기
            for(int i=1; i<=Integer.parseInt(N); i++) {
                queue.add(i);
            }
            //수 빼기
            System.out.print("<");
            for (int i=0; i<Integer.parseInt(N)-1; i++) {
                for (int j=0; j<Integer.parseInt(K)-1; j++) {
                    queue.add(queue.peek());
                    queue.remove();
                }
                System.out.printf("%d, ", queue.peek());
                queue.remove();
            }
            System.out.printf("%d>", queue.peek());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
