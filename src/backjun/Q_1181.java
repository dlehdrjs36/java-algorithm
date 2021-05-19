package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����
 * ���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ���̰� ª�� �ͺ��� 
 * ���̰� ������ ���� ������ 
 * 
 * �Է�
 * ù° �ٿ� �ܾ��� ���� N�� �־�����. (1 �� N �� 20,000) 
 * ��° �ٺ��� N���� �ٿ� ���� ���ĺ� �ҹ��ڷ� �̷���� �ܾ �� �ٿ� �ϳ��� �־�����. 
 * �־����� ���ڿ��� ���̴� 50�� ���� �ʴ´�.
 * 
 * ���
 * ���ǿ� ���� �����Ͽ� �ܾ���� ����Ѵ�. 
 * ��, ���� �ܾ ���� �� �Էµ� ��쿡�� �� ������ ����Ѵ�.
 *
 * https://www.acmicpc.net/problem/1181
*/
public class Q_1181 {
	
	static int compare(String a, String b) {
		if(a.length() < b.length()) {
			return -1;
		}else if(a.length() > b.length()) {
			return 1;
		}else {
			return a.compareTo(b);
		}
	}
	
	static void sort(String[] array) {
		int j;
		String temp;
		for (int i = 0; i < array.length; i++) {
			j = i;
			while(j > 0 && (compare(array[j], array[j-1]) < 0)) {
				temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				j--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb = new StringBuffer();
			
			String st = br.readLine();
			int stCount = Integer.parseInt(st.trim());
			
			String[] array = new String[stCount];
			
			for (int i = 0; i < stCount; i++) {
				array[i] = br.readLine();
			}
			sort(array);
			
			for (int i = 0; i < array.length; i++) {
				if(i > 0 && (array[i].equals(array[i-1]))) {
					continue;
				}
				sb.append(array[i]+"\n");
			}
			System.out.println(sb);
			
		
	}
}
