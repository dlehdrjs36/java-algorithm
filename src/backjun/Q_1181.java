package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 길이가 짧은 것부터 
 * 길이가 같으면 사전 순으로 
 * 
 * 입력
 * 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 
 * 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 
 * 주어지는 문자열의 길이는 50을 넘지 않는다.
 * 
 * 출력
 * 조건에 따라 정렬하여 단어들을 출력한다. 
 * 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
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
