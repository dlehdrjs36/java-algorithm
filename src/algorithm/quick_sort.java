package algorithm;

//������
public class quick_sort {

	private void quickSort(int[] list, int start, int end) {
		/*
		 * start ���� ������ġ
		 * end ������ ������ġ
		 */
		int pivot, i, j, temp;
		
		if(start >= end) { // �迭�� ���Ұ� 1���� ��� ���� - ������� ����
			return;
		}
		
		pivot = start; //���� ���� ù��° ���ҷ� ����
		i = start+1; //���� ������ ū ���� pivot �������� �迭 ������ Ž��
		j = end; //���� ������ ���� ���� �迭 ������ �������� Ž��
		
		//������->����(���� �� Ž��)���� Ž���� ��ġ�� ����->������(ū �� Ž��)���� Ž���� ��ġ���� ���� ��ġ�� �� ������ �ݺ�(������������ �ݺ�)
		while(i <= j) { 
			//1. Ž������ ����(����->������ ū�� Ž��) 
			while(i <= end && list[i] <= list[pivot]) { //������ pivot ������ ū �� Ž��
				i++;
			}
			//2. Ž������ ����(������->���� ������ Ž��)
			while (j > start && list[j] >= list[pivot]) { //�������� pivot ������ ���� �� Ž��, Ž������ �迭������ �Ѿ���ʵ��� ������ġ�� Ž������ ����
				j--;
			}
			//3. ��ġ ����(pivot���� ū��, �������� ��ġ �˻�(i, j))
			if(i > j) { //���� ������ ���¸�, pivot ���� j �� ��ü(pivot���� ������ ��ġ ���� ��ü)
				temp = list[j];
				list[j] = list[pivot];
				list[pivot] = temp;
			} else { //������ ���°� �ƴ϶��, i�� j �� ��ü(ū���� ������ ��ġ ���� ��ü)
				temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		//�����Ͱ� �������� ������ ���� ���, �ش� pivot ���� �������� ���� ���հ� ���� ������ ���� ����		
		//���� �׷�
		quickSort(list, start, j-1);
		//���� �׷�
		quickSort(list, j+1, end);
	}
	
	private void print(int[] list) {
		for (int i : list) {
			System.out.print(i+" ");	
		}
	}
	
	public static void main(String[] args) {
		int[] list = {1, 10, 9, 5, 6, 7, 3, 4, 2, 8 }; 
		quick_sort qs = new quick_sort();
		qs.quickSort(list, 0, list.length-1);
		qs.print(list);
	}

}
