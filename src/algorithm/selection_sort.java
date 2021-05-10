package algorithm;

public class selection_sort {

	//선택 정렬
	public static void main(String[] args) {
		int min, temp;
	    
		int[] array = { 1, 3, 5, 2, 4, 6, 9, 8, 7, 10 };
		
		//대상자 선택, a[i]부터 a[n-1] 까지 
	    for (int i = 0; i < array.length - 1; i++) {
	        min = i;
	        // a[i+1]부터 a[n]까지 대상자보다 작은값 탐색   
	        for (int j = i + 1; j < array.length; j++) {
	        	//대상자보다 값이 작은 경우, 해당 값을 대상자와 위치를 바꾼다.
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
