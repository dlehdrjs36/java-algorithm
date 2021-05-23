package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제
 * 초기에 {0}, {1}, {2}, ... {n} 이 각각 n+1개의 집합을 이루고 있다. 
 * 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
 * 집합을 표현하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 n(1 ≤ n ≤ 1,000,000), m(1 ≤ m ≤ 100,000)이 주어진다. 
 * n은 입력으로 주어지는 연산의 개수이다. 다음 m개의 줄에는 각각의 연산이 주어진다. 
 * 합집합은 0 a b의 형태로 입력이 주어진다. 
 * 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다. 
 * 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 
 * 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다. 
 * a와 b는 n 이하의 자연수 또는 0이며 같을 수도 있다.
 * 
 * 출력
 * 1로 시작하는 입력에 대해서 한 줄에 하나씩 YES/NO로 결과를 출력한다. (yes/no 를 출력해도 된다)
 * 
 * 예제 입력 1 
 * 7 8
 * 0 1 3
 * 1 1 7
 * 0 7 6
 * 1 7 1
 * 0 3 7
 * 0 4 2
 * 0 1 1
 * 1 1 1
 * 
 * 예제 출력 1 
 * NO
 * NO
 * YES
 * 
 * https://www.acmicpc.net/problem/1717
 */
public class Q_1717 {

	static int getParent(int[] parent, int x) {
		if(parent[x] == x) return x;
		else return parent[x] = getParent(parent, parent[x]);
	}
	
	static void union(int[] parent, int x, int y) {
		int node1 = getParent(parent, x);
		int node2 = getParent(parent, y);
		
		if(node1 < node2) parent[node2] = node1;
		else parent[node1] = node2;
	}

	static String compare(int[] parent, int x, int y) {
		int node1 = getParent(parent, x);
		int node2 = getParent(parent, y);
		if(node1 == node2) return "YES";
		else return "NO";
	}
	
	public static void main(String[] args) throws IOException {
		int[] parent;
		String[] operArr;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] cmd1 = br.readLine().split(" ");
		
		int nodeCount = Integer.parseInt(cmd1[0]);
		int operCount = Integer.parseInt(cmd1[1]);
		
		parent = new int[nodeCount+1];
		operArr = new String[operCount];
		
		//노드 초기화
		for (int i = 1; i < nodeCount+1; i++) {
			parent[i] = i;
		}
		
		//연산 입력
		for (int i = 0; i < operCount; i++) {
			operArr[i] = br.readLine();
		}
		
		for (int i = 0; i < operArr.length; i++) {
			String[] oper = operArr[i].split(" ");

			//명령어 분기
			switch (oper[0]) {
			case "0":
				union(parent, Integer.parseInt(oper[1]), Integer.parseInt(oper[2]));
				break;
			case "1":
				System.out.println(compare(parent, Integer.parseInt(oper[1]), Integer.parseInt(oper[2])));
				break;
			default:
				break;
			}
		}
		
	}
}
