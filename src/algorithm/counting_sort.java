package algorithm;

//�������
public class counting_sort {

	static final int NUMBER = 5;
	static int[] count = new int[NUMBER];
	static int[] array = {
							  1, 2, 3, 2, 1, 3 ,5, 4, 3, 5,
							  2, 3, 5, 4, 2, 3, 1, 2, 3, 2,
							  1, 1, 2, 3, 4, 1, 5, 5, 4, 3				  
						 };
	
	static void countingSort(int[] arr) {
		//�迭 �ʱ�ȭ
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		//�� ���ں� ���� ����
		for (int i = 0; i < arr.length; i++) {
			count[array[i]-1]++;
		}
		
		for (int i = 0; i < count.length; i++) {
			if(count[i] != 0) {
				for (int j = 0; j < count[i]; j++) {
					System.out.printf(i+1+" ");
				}
			}
		}
	}
	public static void main(String[] args) {
		countingSort(array);
	}
}
