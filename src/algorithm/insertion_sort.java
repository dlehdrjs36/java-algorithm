package algorithm;

//삽입 정렬
public class insertion_sort {

	public static void main(String[] args) {
		int j, temp;
		int[] array = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
		
		for(int i = 0; i < array.length; i++ ) {
			j = i;
			//현재 값이 이전 값보다 작은경우 정렬 수행 
			while(j > 0 && array[j-1] > array[j]) {				
				temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;				
				j--;
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}