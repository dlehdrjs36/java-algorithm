package algorithm;


//깊이우선탐색(dfs)
public class depth_first_search {

	static boolean[] check;
	static int[][] map;
	
	static void dfs(int x) {
		
		//해당 노드 방문한경우 스택에서 제거
		if(check[x]) return;
		
		//방문하지 않았다면 방문 처리
		check[x] = true;
		System.out.println(x);
		
		//해당 노드의 인접 노드 확인
		for (int i = 0; i < map[x].length; i++) {
			int c = map[x][i];
			
			//간선이 있으면서 방문하지 않았다면 
			if(c == 1 && !check[i]) {
				dfs(i);
			}
		}
		
	}
	public static void main(String[] args) {
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
		
		dfs(1);
		
	}

}
