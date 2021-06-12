package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 
 * 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 
 * 수는 중복되지 않는다.
 * 
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 5
 * 5
 * 4
 * 3
 * 2
 * 1
 * 
 * 예제 출력 1 
 * 1
 * 2
 * 3
 * 4
 * 5
 * 
 * https://www.acmicpc.net/problem/2751
*/
public class Q_2751 {
	static int[] sortArray;
	//배열 쪼개기
	public static void mergeSort(int[] array, int start, int end) {
		if(start < end) {
			int middle = (start+end)/2;
			mergeSort(array, start, middle);
			mergeSort(array, middle+1, end);
			merge(array, start, middle, end);
		}
	}
	//배열 합치기
	public static void merge(int[] array, int start, int middle, int end) {
		int i = start;
		int j = middle+1;
		int k = start;
		
		while(i <= middle && j <= end) {
			if(array[i] <= array[j]) {
				sortArray[k] = array[i++];
			}else {
				sortArray[k] = array[j++];
			}
			k++;
		}
		//정렬 후, 남은 데이터 추가
		if(i > middle) {
			for(int l=j; l <= end; l++) {
				sortArray[k] = array[l];
				k++;
			}
		}else {
			for(int m=i; m <= middle; m++) {
				sortArray[k] = array[m];
				k++;
			}
		}
		//정렬된 배열 삽입
		for(int n=start; n<=end; n++ ) {
			array[n] = sortArray[n];
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine().trim());
		sortArray = new int[N];
		int[] array = new int[N];
		for(int i=0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine().trim());
		}
		mergeSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]+"\n");
		}
		System.out.print(sb);
	}
}
