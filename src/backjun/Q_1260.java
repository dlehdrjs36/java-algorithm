package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 
 * 문제
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
 * 정점 번호는 1번부터 N번까지이다.
 * 
 * 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
 * 입력으로 주어지는 간선은 양방향이다.
 * 
 * 출력
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 * 
 * 예제 입력 1
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * 
 * 예제 출력 1
 * 1 2 4 3
 * 1 2 3 4
 * 
 * 예제 입력 2 
 * 5 5 3
 * 5 4
 * 5 2
 * 1 2
 * 3 4
 * 3 1
 * 
 * 예제 출력 2
 * 3 1 2 5 4
 * 3 1 4 2 5
 * 
 * 예제 입력 3
 * 1000 1 1000
 * 999 1000
 * 
 * 예제 출력 3
 * 1000 999
 * 1000 999
 * 
 *  https://www.acmicpc.net/problem/1260 
*/
public class Q_1260 {
	
	static boolean[] dfsCheck;
	static boolean[] bfsCheck;
	static int[][] map;
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		bfsCheck[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.printf(x+" ");
			for (int t = 0; t < map[x].length; t++) {
				int c = map[x][t]; //현재 정점의 간선 존재여부 판단
				if(c == 1 && !bfsCheck[t]) {
					q.offer(t);
					bfsCheck[t] = true;
				}
			}
		}
		
	}
	static void dfs(int x) {
		if(dfsCheck[x]) return;
		
		dfsCheck[x] = true;
		System.out.print(x+" ");
		
		for(int t=0; t<map[x].length; t++) {
			int c = map[x][t]; //현재 정점의 간선 존재여부 판단
			//간선이 있고 방문한적이 없으면
			if(c == 1 && !dfsCheck[t]) {
				dfs(t);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String option = br.readLine();
		String[] optionArr = option.split(" ");
		
		int vertexCount = Integer.parseInt(optionArr[0].trim());
		int edgeCount = Integer.parseInt(optionArr[1].trim());
		int index = Integer.parseInt(optionArr[2].trim());
		
		bfsCheck = new boolean[vertexCount+1];
		dfsCheck = new boolean[vertexCount+1];
		map = new int[vertexCount+1][vertexCount+1];
		
		for (int i = 0; i < edgeCount; i++) {	
			String edgeInfo = br.readLine();
			String[] edgeArr = edgeInfo.split(" ");
			int edge1 = Integer.parseInt(edgeArr[0].trim());
			int edge2 = Integer.parseInt(edgeArr[1].trim());

			map[edge1][edge2] = map[edge2][edge1] = 1;
			
		}
		dfs(index);
		System.out.println();
		bfs(index);
	}

}
