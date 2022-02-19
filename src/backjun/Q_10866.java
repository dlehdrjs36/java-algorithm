package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * @see <a href="https://www.acmicpc.net/problem/10866">10866번 문제</a>
 */
public class Q_10866 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String readLine = br.readLine();
            int count = Integer.parseInt(readLine); //명령의 수
            int[] deque = new int[count]; //명령의 수가 모두 push일 경우 필요한 공간
            int start = 0; // 덱 앞 커서(머리)
            int end = deque.length-1; //덱 뒤 커서(꼬리)

            //명령의 수 만큼 명령줄 입력
            while(count > 0) {
                String commandLine = br.readLine();
                String[] commandParam = commandLine.split(" ");

                switch (commandParam[0]) {
                    case "push_front": {
                        int cycleCount = start;
                        //맨 앞에 추가하는 경우 기존 등록된 값들의 위치 이동 필요. 기존 값을 모두 뒤로 한 칸씩 이동
                        while(cycleCount > 0) {
                            deque[cycleCount] = deque[cycleCount-1];
                            cycleCount--;
                        }
                        //맨 앞에 값 추가
                        deque[0] = Integer.parseInt(commandParam[1]);
                        //기존 앞의 커서를 뒤(오른쪽)로 한 칸 이동
                        if(start < deque.length-1) {
                            start += 1;
                        }
                        break;
                    }
                    case "push_back": {
                        int cycleCount = end;
                        //맨 뒤에 추가하는 경우 기존 등록된 값들의 위치 이동 필요. 기존 값을 모두 앞으로 한 칸씩 이동
                        while(cycleCount < deque.length-1) {
                            deque[cycleCount] = deque[cycleCount+1];
                            cycleCount++;
                        }
                        //맨 뒤에 값 추가
                        deque[deque.length-1] = Integer.parseInt(commandParam[1]);
                        //기존 뒤의 커서를 앞(왼쪽)으로 한 칸 이동
                        if(end > 0) {
                            end -= 1;
                        }
                        break;
                    }
                    case "pop_front": {
                        //앞 커서에 값이 추가된 적이 있는 경우
                        if(start != 0) {
                            System.out.println(deque[0]);
                            //기존 등록된 값들의 위치를 앞으로 한 칸씩 이동. i가 start-1의 위치인 경우, 기존 start 위치의 값은 비어있으므로 초기화된다.
                            for(int i=0; i<start; i++) {
                                deque[i] = deque[i+1];
                            }
                            //앞의 커서를 앞(왼쪽)으로 한 칸 이동
                            if(start > 0) {
                                start -= 1;
                            }
                        }else if(end != deque.length-1) { //뒤 커서에 값이 추가된 적이 있는 경우
                            //뒤 커서에만 값이 추가된 경우, 맨 앞에 존재하는 값은 end+1 이다. 맨 뒤에서 삭제되거나 추가되는 경우가 아니므로 값들의 위치 변경은 불필요하다.
                            System.out.println(deque[end+1]);
                            deque[end+1] = -1;
                            //뒤 커서의 위치를 뒤(오른쪽)로 한 칸 이동
                            if(end < deque.length-1) {
                                end += 1;
                            }
                        }else { //앞, 뒤 커서에 값이 추가된 적이 없는 경우
                            System.out.println(-1);
                        }
                        break;
                    }
                    case "pop_back": {
                        //뒤 커서에 값이 추가된 적이 있는 경우
                        if(end != deque.length-1) {
                            System.out.println(deque[deque.length-1]);
                            //기존 등록된 값들의 위치를 뒤(오른쪽)로 한 칸씩 이동. i가 end+1의 위치인 경우, 기존 end 위치의 값은 비어있으므로 초기화된다.
                            for(int i=deque.length-1; i>end; i--) {
                                deque[i] = deque[i-1];
                            }
                            //뒤 커서의 위치를 뒤(오른쪽)로 한 칸 이동
                            if(end < deque.length-1) {
                                end += 1;
                            }
                        }else if(start != 0) { //앞 커서에 값이 추가된 적이 있는 경우
                            //앞 커서에만 값이 추가된 경우, 맨 뒤에 존재하는 값은 start-1 이다. 맨 앞에서 삭제되거나 추가되는 경우가 아니므로 값들의 위치 변경은 불필요하다.
                            System.out.println(deque[start-1]);
                            deque[start-1] = -1;
                            //앞의 커서를 앞(왼쪽)으로 한 칸 이동
                            start -= 1;
                        }else {
                            System.out.println(-1);
                        }
                        break;
                    }
                    case "size": {
                        int dequeLength = 0;
                        for (int j : deque) {
                            if (j >= 1) {
                                dequeLength += 1;
                            }
                        }
                        System.out.println(dequeLength);
                        break;
                    }
                    case "empty": {
                        int dequeLength = 0;
                        for (int j : deque) {
                            if (j >= 1) {
                                dequeLength += 1;
                            }
                        }
                        int result = dequeLength >= 1 ? 0 : 1;
                        System.out.println(result);
                        break;
                    }
                    case "front": {
                        //앞 커서에 값이 추가된 적이 있는 경우
                        if(start != 0) {
                            System.out.println(deque[0]);
                        }else if(end != deque.length-1) { //뒤 커서에 값이 추가된 적이 있는 경우
                            System.out.println(deque[end+1]);
                        }else { //앞, 뒤 커서에 값이 추가된 적이 없는 경우
                            System.out.println(-1);
                        }
                        break;
                    }
                    case "back": {
                        //뒤 커서에 값이 추가된 적이 있는 경우
                        if(end != deque.length-1) {
                            System.out.println(deque[deque.length-1]);
                        }else if(start != 0) { //앞 커서에 값이 추가된 적이 있는 경우
                            System.out.println(deque[start-1]);
                        }else { //앞, 뒤 커서에 값이 추가된 적이 없는 경우
                            System.out.println(-1);
                        }
                        break;
                    }
                }
                count--;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}