package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 
 * ����
 * �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. 
 * ���� ��ȣ�� 1������ N�������̴�.
 * 
 * �Է�
 * ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����. 
 * ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. 
 * � �� ���� ���̿� ���� ���� ������ ���� �� �ִ�. 
 * �Է����� �־����� ������ ������̴�.
 * 
 * ���
 * ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�. V���� �湮�� ���� ������� ����ϸ� �ȴ�.
 * 
 * ���� �Է� 1
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * 
 * ���� ��� 1
 * 1 2 4 3
 * 1 2 3 4
 * 
 * ���� �Է� 2 
 * 5 5 3
 * 5 4
 * 5 2
 * 1 2
 * 3 4
 * 3 1
 * 
 * ���� ��� 2
 * 3 1 2 5 4
 * 3 1 4 2 5
 * 
 * ���� �Է� 3
 * 1000 1 1000
 * 999 1000
 * 
 * ���� ��� 3
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
				int c = map[x][t]; //���� ������ ���� ���翩�� �Ǵ�
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
			int c = map[x][t]; //���� ������ ���� ���翩�� �Ǵ�
			//������ �ְ� �湮������ ������
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
