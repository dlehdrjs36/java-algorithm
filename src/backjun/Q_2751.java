package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� ���� ���� N(1 �� N �� 1,000,000)�� �־�����. 
 * ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. 
 * �� ���� ������ 1,000,000���� �۰ų� ���� �����̴�. 
 * ���� �ߺ����� �ʴ´�.
 * 
 * ���
 * ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 *
 * ���� �Է� 1
 * 5
 * 5
 * 4
 * 3
 * 2
 * 1
 * 
 * ���� ��� 1 
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
	//�迭 �ɰ���
	public static void mergeSort(int[] array, int start, int end) {
		if(start < end) {
			int middle = (start+end)/2;
			mergeSort(array, start, middle);
			mergeSort(array, middle+1, end);
			merge(array, start, middle, end);
		}
	}
	//�迭 ��ġ��
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
		//���� ��, ���� ������ �߰�
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
		//���ĵ� �迭 ����
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
