package algorithm;

//�� ����
public class heap_sort {

	static int number = 9;
	static int[] heap = {7,6,5,8,3,5,9,1,6};
	// ���� �ּڰ��̳� �ִ��� ������ ã�Ƴ��� ���� ���� ����Ʈ���� ������� �ϴ� Ʈ��
	// �ִ� �� ������ �θ� ��尡 �ڽĵ麸�� �׻� ũ��
	public static void main(String[] args) {
		//1. ���� ��ü Ʈ�� ������ �ִ� �� ������ �ٲ۴�.
		for (int i = 0; i < number; i++) {
			int c = i;
			do {
				int root = (c - 1) /2; //�ڱ��ڽ��� �θ� �ε����� �ǹ�
				//�θ� �ڽĺ��� ������ ��ü
				if(heap[root] < heap[c]) {
					int temp = heap[root];
					heap[root] = heap[c];
					heap[c] = temp;
				}
				//��ü�� ���� �������� �ٽ��ѹ� �� �������� �˻�
				c = root;
			} while( c != 0);
		}
		//2. ũ�⸦ �ٿ����� �ݺ������� ���� ����
		for (int i=number-1; i >= 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			
			//3. ������ ������
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				//�ڽ� �߿� �� ū���� ã�Ƽ� �� ���� ���� 
				if(c < (i-1) && heap[c] < heap[c+1]) {
					c++;
				}
				//��Ʈ���� �ڽ��� �� ũ�ٸ� ��ȯ
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
