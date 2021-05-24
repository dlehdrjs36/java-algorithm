package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 문제
 * 도현이는 컴퓨터와 컴퓨터를 모두 연결하는 네트워크를 구축하려 한다. 
 * 하지만 아쉽게도 허브가 있지 않아 컴퓨터와 컴퓨터를 직접 연결하여야 한다. 
 * 그런데 모두가 자료를 공유하기 위해서는 모든 컴퓨터가 연결이 되어 있어야 한다. 
 * (a와 b가 연결이 되어 있다는 말은 a에서 b로의 경로가 존재한다는 것을 의미한다. 
 * a에서 b를 연결하는 선이 있고, b와 c를 연결하는 선이 있으면 a와 c는 연결이 되어 있다.)
 * 
 * 그런데 이왕이면 컴퓨터를 연결하는 비용을 최소로 하여야 컴퓨터를 연결하는 비용 외에 다른 곳에 돈을 더 쓸 수 있을 것이다. 
 * 이제 각 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때 모든 컴퓨터를 연결하는데 필요한 최소비용을 출력하라. 
 * 모든 컴퓨터를 연결할 수 없는 경우는 없다.
 * 
 * 입력
 * 첫째 줄에 컴퓨터의 수 N (1 ≤ N ≤ 1000)가 주어진다.
 * 둘째 줄에는 연결할 수 있는 선의 수 M (1 ≤ M ≤ 100,000)가 주어진다.
 * 셋째 줄부터 M+2번째 줄까지 총 M개의 줄에 각 컴퓨터를 연결하는데 드는 비용이 주어진다. 
 * 이 비용의 정보는 세 개의 정수로 주어지는데, 만약에 a b c 가 주어져 있다고 하면 a컴퓨터와 b컴퓨터를 연결하는데 비용이 c (1 ≤ c ≤ 10,000) 만큼 든다는 것을 의미한다. 
 * a와 b는 같을 수도 있다.
 * 
 * 출력
 * 모든 컴퓨터를 연결하는데 필요한 최소비용을 첫째 줄에 출력한다.
 * 
 * 예제 입력 1
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
 * 예제 출력 1
 * 23
 * 
 * 힌트
 * 이 경우에 1-3, 2-3, 3-4, 4-5, 4-6을 연결하면 주어진 output이 나오게 된다.
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

		//초기 부모노드 초기화
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
