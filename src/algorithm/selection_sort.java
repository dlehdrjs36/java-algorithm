package algorithm;

public class selection_sort {

	//���� ����
	public static void main(String[] args) {
		int min, temp;
	    
		int[] array = { 1, 3, 5, 2, 4, 6, 9, 8, 7, 10 };
		
		//����� ����, a[i]���� a[n-1] ���� 
	    for (int i = 0; i < array.length - 1; i++) {
	        min = i;
	        // a[i+1]���� a[n]���� ����ں��� ������ Ž��   
	        for (int j = i + 1; j < array.length; j++) {
	        	//����ں��� ���� ���� ���, �ش� ���� ����ڿ� ��ġ�� �ٲ۴�.
	            if (array[j] < array[min]) {
	                min = j;
	            }
	        }
	        temp = array[min];
	        array[min] = array[i];
	        array[i] = temp;
	    }
	  
	    for (int i = 0; i < array.length; i++) {
	    	System.out.println(array[i]);
		}
	}
}
