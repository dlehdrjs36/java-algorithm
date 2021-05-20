package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//크루스칼 알고리즘
public class kruskal {

	//유니온 파인드 알고리즘으로 사이클 생성여부 검증
	static int getParent(int[] parent, int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = getParent(parent, parent[x]);
	}
	
	static void unionParent(int[] parent, int a, int b){
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static boolean findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		if(a == b) return true;
		else return false;
	}
	
	static class Edge {
		private int[] node = new int[2];
		private int distance;
		
		public Edge(int a, int b, int distance) {
			this.node[0] = a;
			this.node[1] = b;
			this.distance = distance;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}
		
	}
	
	public static void main(String[] args) {
		//정점 갯수
		int n = 6;
		//간선 갯수
		int m = 11;
		
		List<Edge> v = new ArrayList<>();
		v.add(new Edge(1,6,27));
		v.add(new Edge(1,3,36));
		v.add(new Edge(1,2,20));
		v.add(new Edge(1,5,29));
		v.add(new Edge(2,6,16));
		v.add(new Edge(2,3,22));
		v.add(new Edge(2,4,30));
		v.add(new Edge(2,5,27));
		v.add(new Edge(3,6,25));
		v.add(new Edge(3,4,34));
		v.add(new Edge(4,5,32));
		
		//간선의 비용을 기준으로 오름차순 정렬
		Collections.sort(v, (p1, p2) -> {
			return p1.getDistance()-p2.getDistance();
		});
		
		// 각 정점이 포함된 그래프가 어디인지 저장
		int[] parent = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			parent[i] = i;
		}
		
		//거리의 합
		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			// 사이클이 발생하지 않는 경우 그래프에 포함
			if(!findParent(parent, v.get(i).node[0], v.get(i).node[1])) {
				sum += v.get(i).getDistance();
				unionParent(parent, v.get(i).node[0], v.get(i).node[1]);
			}
		}
		System.out.println(sum);
	}

}
