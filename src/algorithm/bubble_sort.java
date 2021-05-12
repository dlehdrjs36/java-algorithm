package algorithm;

//버블정렬
public class bubble_sort {

	public static void main(String[] args) {
		int temp;
		int[] array = { 1, 3, 2, 4, 6, 5, 9, 7, 8, 10 };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < (array.length-1)-i; j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]+"\n");
		}
		System.out.println(sb);
	}
}
