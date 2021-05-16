package algorithm;


//���̿켱Ž��(dfs)
public class depth_first_search {

	static boolean[] check;
	static int[][] map;
	
	static void dfs(int x) {
		
		//�ش� ��� �湮�Ѱ�� ���ÿ��� ����
		if(check[x]) return;
		
		//�湮���� �ʾҴٸ� �湮 ó��
		check[x] = true;
		System.out.println(x);
		
		//�ش� ����� ���� ��� Ȯ��
		for (int i = 0; i < map[x].length; i++) {
			int c = map[x][i];
			
			//������ �����鼭 �湮���� �ʾҴٸ� 
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
		
		//���� ����
		for (int i = 0; i < edgeArr.length; i++) {
			int temp1 = edgeArr[i][0];
			int temp2 = edgeArr[i][1];
			map[temp1][temp2] = map[temp2][temp1] = 1; 
		}
		
		dfs(1);
		
	}

}
