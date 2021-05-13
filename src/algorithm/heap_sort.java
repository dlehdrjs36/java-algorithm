package algorithm;

//힙 정렬
public class heap_sort {

	static int number = 9;
	static int[] heap = {7,6,5,8,3,5,9,1,6};
	// 힙은 최솟값이나 최댓값을 빠르게 찾아내기 위해 완전 이진트리를 기반으로 하는 트리
	// 최대 힙 구조는 부모 노드가 자식들보다 항상 크다
	public static void main(String[] args) {
		//1. 먼저 전체 트리 구조를 최대 힙 구조로 바꾼다.
		for (int i = 0; i < number; i++) {
			int c = i;
			do {
				int root = (c - 1) /2; //자기자신의 부모 인덱스를 의미
				//부모가 자식보다 작으면 교체
				if(heap[root] < heap[c]) {
					int temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				//교체한 값을 기준으로 다시한번 힙 구조인지 검사
				c = root;
			} while( c != 0);
		}
		//2. 크기를 줄여가며 반복적으로 힙을 구성
		for (int i=number-1; i >= 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			
			//3. 힙구조 재형성
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				//자식 중에 더 큰값을 찾아서 힙 구조 유지 
				if(c < (i-1) && heap[c] < heap[c+1]) {
					c++;
				}
				//루트보다 자식이 더 크다면 교환
				if(c < i && heap[root] < heap[c]) {
					temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				root = c;
			} while (c < i);
		}
		
		for (int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
	}
}
