package algorithm;

//��������
public class merge_sort {

	static final int NUMBER = 8;
	int[] sortArray = new int[NUMBER];
	
	//�迭 ��ġ��
	void merge_array(int[] array, int start, int middle, int end) {
		int i = start;
		int k = start;
		int j = middle+1;
		//�迭�� ��ĥ ��, �� �κ� ������ ���Ͽ� ���� ���� ���� �迭�� �ִ´�.
		while(i <= middle && j <= end) {
			if(array[i] <= array[j]) {
				sortArray[k] = array[i];
				i++;
			}else {
				sortArray[k] = array[j];
				j++;
			}
			k++;
		}
		//���� �� �ϳ��� ���� ������ �Ϸ� �� ���¶��, ������ ������ ���� ���� �迭�� �ִ´�.		
		if(i > middle) {
			for (int l=j; l<=end; l++) {
				sortArray[k] = array[l];
				k++;
			}
		}else {
			for (int l=i; l<= middle; l++) {
				sortArray[k] = array[l];
				k++;
			}
		}
		//�ӽ÷� �����ص� ���� ���� ������ �����ϴ� �迭�� �̵� 
		for (int l=start; l <= end; l++) {
			array[l] = sortArray[l];
		}
	}
	
	//�迭 ������
	void divide_array(int[] array, int start, int end) {
		if( start < end ) {
			int middle = (start + end)/2;
			divide_array(array, start, middle);
			divide_array(array, middle+1, end);
			merge_array(array, start, middle, end);
		}
	}

	public static void main(String[] args) {
		int[] array = { 5, 8, 10, 8, 6, 3, 2, 4};
		merge_sort ms = new merge_sort();
		ms.divide_array(array, 0, NUMBER-1);
		for (int i = 0; i < NUMBER; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
