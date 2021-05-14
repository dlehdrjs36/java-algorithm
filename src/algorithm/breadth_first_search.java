package algorithm;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

//bfs
//시작노드를 큐에 넣고 시작한다. 
//시작노드를 기준으로 아직 방문하지 않은 노드는 큐에 넣고 방문처리를 해준다. 이 과정을 반복수행하고 모든 노드를 방문하면 출력
public class breadth_first_search {
	
	static boolean[] check;
	static int[][] map;

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.println(x);
			for (int i = 0; i < map[x].length; i++) {
				//현재 노드와 연결된 간선이 존재하는지 확인
				int y = map[x][i];
				//연결된 간선이 존재하고, 현재 그 노드가 방문을 한 상태가 아니면 큐에 담고 방문처리
				if(map[x][i] == 1 && !check[i] ) {
					q.offer(i);
					check[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int[][] edgeArr = {
							{1,2}
							,{1,3}
							,{2,3}
							,{2,4}
							,{3,5}
						  };
		
		map = new int[6][6];
		check = new boolean[6];
		
		//간선 설정
		for (int i = 0; i < edgeArr.length; i++) {
			int temp1 = edgeArr[i][0];
			int temp2 = edgeArr[i][1];
			map[temp1][temp2] = map[temp2][temp1] = 1; 
		}
		
		bfs(1);
		
	}
}
