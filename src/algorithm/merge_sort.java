package algorithm;

//병합정렬
public class merge_sort {

	static final int NUMBER = 8;
	int[] sortArray = new int[NUMBER];
	
	//배열 합치기
	void merge_array(int[] array, int start, int middle, int end) {
		int i = start;
		int k = start;
		int j = middle+1;
		//배열을 합칠 때, 각 부분 집합을 비교하여 가장 작은 값을 배열에 넣는다.
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
		//집합 중 하나가 먼저 정렬이 완료 된 상태라면, 나머지 집합의 남은 값도 배열에 넣는다.		
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
		//임시로 저장해둔 값을 실제 정렬을 수행하는 배열로 이동 
		for (int l=start; l <= end; l++) {
			array[l] = sortArray[l];
		}
	}
	
	//배열 나누기
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
