package algorithm;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

//bfs
//���۳�带 ť�� �ְ� �����Ѵ�. 
//���۳�带 �������� ���� �湮���� ���� ���� ť�� �ְ� �湮ó���� ���ش�. �� ������ �ݺ������ϰ� ��� ��带 �湮�ϸ� ���
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
				//���� ���� ����� ������ �����ϴ��� Ȯ��
				int y = map[x][i];
				//����� ������ �����ϰ�, ���� �� ��尡 �湮�� �� ���°� �ƴϸ� ť�� ��� �湮ó��
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
		
		//���� ����
		for (int i = 0; i < edgeArr.length; i++) {
			int temp1 = edgeArr[i][0];
			int temp2 = edgeArr[i][1];
			map[temp1][temp2] = map[temp2][temp1] = 1; 
		}
		
		bfs(1);
		
	}
}
