package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. 
 * ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. 
 * �� ���� ������ 1,000���� �۰ų� ���� �����̴�. 
 * ���� �ߺ����� �ʴ´�.
 * 
 * ���
 * ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * 
 * ���� �Է�
 * 5
 * 5
 * 2
 * 3
 * 4
 * 1
 * 
 * ���� ���
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
