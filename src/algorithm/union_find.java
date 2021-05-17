package algorithm;

//유니온 파인드
public class union_find {

	//부모 노드를 찾는 메소드
	static int getParent(int[] parent, int x) {
		//x가 부모의 값과 동일할 경우 자신이 부모라는 의미.
		if(parent[x] == x) return x;
		
		return parent[x] = getParent(parent, parent[x]);
	}
	
	//두 부모 노드를 합치는 메소드(경로 압축 최적화를 위해 작은 값을 부모로 설정 )
	static void unionParent(int[] parent, int a, int b){
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		if(a<b) parent[b] = a;
		else parent[a] = b;
		
	}
	
	//같은 부모를 가지는지 확인(같은 그래프에 속해있는지 확인)
	static int findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		if(a==b) return 1;
		else return 0;
		
	}
	
	public static void main(String[] args) {
		int[] parent = new int[11];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}

		unionParent(parent, 1, 2); 
		unionParent(parent, 2, 3);
		unionParent(parent, 4, 5);
		System.out.printf("1과 4는 같은 집합에 속하는가? %d\n", findParent(parent, 1, 4));
		unionParent(parent, 1, 4);
		System.out.printf("1과 4는 같은 집합에 속하는가? %d\n", findParent(parent, 1, 4));
		
		for (int i = 1; i < parent.length; i++) {
			 System.out.println(getParent(parent, i));
		}
			
	}
}
