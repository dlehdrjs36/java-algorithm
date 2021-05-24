package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * ����
 * �����̴� ��ǻ�Ϳ� ��ǻ�͸� ��� �����ϴ� ��Ʈ��ũ�� �����Ϸ� �Ѵ�. 
 * ������ �ƽ��Ե� ��갡 ���� �ʾ� ��ǻ�Ϳ� ��ǻ�͸� ���� �����Ͽ��� �Ѵ�. 
 * �׷��� ��ΰ� �ڷḦ �����ϱ� ���ؼ��� ��� ��ǻ�Ͱ� ������ �Ǿ� �־�� �Ѵ�. 
 * (a�� b�� ������ �Ǿ� �ִٴ� ���� a���� b���� ��ΰ� �����Ѵٴ� ���� �ǹ��Ѵ�. 
 * a���� b�� �����ϴ� ���� �ְ�, b�� c�� �����ϴ� ���� ������ a�� c�� ������ �Ǿ� �ִ�.)
 * 
 * �׷��� �̿��̸� ��ǻ�͸� �����ϴ� ����� �ּҷ� �Ͽ��� ��ǻ�͸� �����ϴ� ��� �ܿ� �ٸ� ���� ���� �� �� �� ���� ���̴�. 
 * ���� �� ��ǻ�͸� �����ϴµ� �ʿ��� ����� �־����� �� ��� ��ǻ�͸� �����ϴµ� �ʿ��� �ּҺ���� ����϶�. 
 * ��� ��ǻ�͸� ������ �� ���� ���� ����.
 * 
 * �Է�
 * ù° �ٿ� ��ǻ���� �� N (1 �� N �� 1000)�� �־�����.
 * ��° �ٿ��� ������ �� �ִ� ���� �� M (1 �� M �� 100,000)�� �־�����.
 * ��° �ٺ��� M+2��° �ٱ��� �� M���� �ٿ� �� ��ǻ�͸� �����ϴµ� ��� ����� �־�����. 
 * �� ����� ������ �� ���� ������ �־����µ�, ���࿡ a b c �� �־��� �ִٰ� �ϸ� a��ǻ�Ϳ� b��ǻ�͸� �����ϴµ� ����� c (1 �� c �� 10,000) ��ŭ ��ٴ� ���� �ǹ��Ѵ�. 
 * a�� b�� ���� ���� �ִ�.
 * 
 * ���
 * ��� ��ǻ�͸� �����ϴµ� �ʿ��� �ּҺ���� ù° �ٿ� ����Ѵ�.
 * 
 * ���� �Է� 1
 * 6
 * 9
 * 1 2 5
 * 1 3 4
 * 2 3 2
 * 2 4 7
 * 3 4 6
 * 3 5 11
 * 4 5 3
 * 4 6 8
 * 5 6 8
 * 
 * ���� ��� 1
 * 23
 * 
 * ��Ʈ
 * �� ��쿡 1-3, 2-3, 3-4, 4-5, 4-6�� �����ϸ� �־��� output�� ������ �ȴ�.
 * 
 * https://www.acmicpc.net/problem/1922
*/
public class Q_1922 {

	static class Edge {
		private int[] node = new int[2];
		private int distance;
		
		public Edge(int a, int b, int distance) {
			node[0] = a;
			node[1] = b;
			this.distance = distance;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int[] getNode() {
			return node;
		}

		public void setNode(int[] node) {
			this.node = node;
		}
		
	}

	static int getParent(int[] parent, int a) {
		if(parent[a] == a) return a;
		return parent[a] = getParent(parent, parent[a]); 
	}
	
	static void union(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static boolean parentCompare(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		if(a == b) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nodeCount = Integer.parseInt(br.readLine());
		int edgeCount = Integer.parseInt(br.readLine());
		
		int[] parent = new int[nodeCount+1];
		List<Edge> list = new ArrayList<>();

		//�ʱ� �θ��� �ʱ�ȭ
		for (int i = 1; i < nodeCount+1; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < edgeCount; i++) {
			String nodeInfo = br.readLine();
			String[] nodeInfoArr = nodeInfo.split(" ");
			list.add(new Edge(Integer.parseInt(nodeInfoArr[0]), Integer.parseInt(nodeInfoArr[1]), Integer.parseInt(nodeInfoArr[2])));
		}
		
		Collections.sort(list, 
				(a, b) -> a.getDistance()-b.getDistance()
		);

		int sum = 0;		
		for (int i = 0; i < list.size(); i++) {
			if (!parentCompare(parent, list.get(i).getNode()[0], list.get(i).getNode()[1])) {
				sum += list.get(i).getDistance();
				union(parent, list.get(i).getNode()[0], list.get(i).getNode()[1]);
			}
		}
		System.out.print(sum);
	}
}
