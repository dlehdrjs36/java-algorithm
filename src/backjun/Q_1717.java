package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����
 * �ʱ⿡ {0}, {1}, {2}, ... {n} �� ���� n+1���� ������ �̷�� �ִ�. 
 * ���⿡ ������ �����, �� ���Ұ� ���� ���տ� ���ԵǾ� �ִ����� Ȯ���ϴ� ������ �����Ϸ��� �Ѵ�.
 * ������ ǥ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� n(1 �� n �� 1,000,000), m(1 �� m �� 100,000)�� �־�����. 
 * n�� �Է����� �־����� ������ �����̴�. ���� m���� �ٿ��� ������ ������ �־�����. 
 * �������� 0 a b�� ���·� �Է��� �־�����. 
 * �̴� a�� ���ԵǾ� �ִ� ���հ�, b�� ���ԵǾ� �ִ� ������ ��ģ�ٴ� �ǹ��̴�. 
 * �� ���Ұ� ���� ���տ� ���ԵǾ� �ִ����� Ȯ���ϴ� ������ 1 a b�� ���·� �Է��� �־�����. 
 * �̴� a�� b�� ���� ���տ� ���ԵǾ� �ִ����� Ȯ���ϴ� �����̴�. 
 * a�� b�� n ������ �ڿ��� �Ǵ� 0�̸� ���� ���� �ִ�.
 * 
 * ���
 * 1�� �����ϴ� �Է¿� ���ؼ� �� �ٿ� �ϳ��� YES/NO�� ����� ����Ѵ�. (yes/no �� ����ص� �ȴ�)
 * 
 * ���� �Է� 1 
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
 * ���� ��� 1 
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
		
		//��� �ʱ�ȭ
		for (int i = 1; i < nodeCount+1; i++) {
			parent[i] = i;
		}
		
		//���� �Է�
		for (int i = 0; i < operCount; i++) {
			operArr[i] = br.readLine();
		}
		
		for (int i = 0; i < operArr.length; i++) {
			String[] oper = operArr[i].split(" ");

			//��ɾ� �б�
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
