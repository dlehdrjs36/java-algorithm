package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 
 * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 
 * 수는 중복되지 않는다.
 * 
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 * 예제 입력
 * 5
 * 5
 * 2
 * 3
 * 4
 * 1
 * 
 * 예제 출력
 * 1
 * 2
 * 3
 * 4
 * 5
 * 
 * https://www.acmicpc.net/problem/2750
*/
public class Q_2750 {

	public void mySol() {
		int[] array = new int[1000];
		int min, j, k, temp;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int count = Integer.parseInt(br.readLine());
			for (int i = 0; i < count; i++) {
				array[i] = Integer.parseInt(br.readLine());
			}
			
			for (j=0; j <count; j++) {
				min = j;
				for (k=j; k<count; k++) {
					if(array[k] < array[min]) {
						min = k;
					}
				}
				temp = array[j];
				array[j] = array[min];
				array[min] = temp;
			}
			
			for (int l=0; l<count; l++) {
				System.out.println(array[l]);
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Q_2750 q = new Q_2750();
		q.mySol();
	}
}
