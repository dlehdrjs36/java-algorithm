package algorithm;

//퀵정렬
public class quick_sort {

	private void quickSort(int[] list, int start, int end) {
		/*
		 * start 시작 원소위치
		 * end 마지막 원소위치
		 */
		int pivot, i, j, temp;
		
		if(start >= end) { // 배열의 원소가 1개인 경우 종료 - 재귀종료 조건
			return;
		}
		
		pivot = start; //기준 값은 첫번째 원소로 설정
		i = start+1; //기준 값보다 큰 값을 pivot 우측부터 배열 끝까지 탐색
		j = end; //기준 값보다 작은 값을 배열 끝에서 좌측으로 탐색
		
		//오른쪽->왼쪽(작은 값 탐색)으로 탐색한 위치가 왼쪽->오른쪽(큰 값 탐색)으로 탐색한 위치보다 작은 위치가 될 때까지 반복(엇갈릴때까지 반복)
		while(i <= j) { 
			//1. 탐색수행 범위(왼쪽->오른쪽 큰값 탐색) 
			while(i <= end && list[i] <= list[pivot]) { //왼쪽은 pivot 값보다 큰 값 탐색
				i++;
			}
			//2. 탐색수행 범위(오른쪽->왼쪽 작은값 탐색)
			while (j > start && list[j] >= list[pivot]) { //오른쪽은 pivot 값보다 작은 값 탐색, 탐색값이 배열범위를 넘어가지않도록 시작위치로 탐색범위 제한
				j--;
			}
			//3. 위치 변경(pivot보다 큰값, 작은값의 위치 검사(i, j))
			if(i > j) { //현재 엇갈린 상태면, pivot 값과 j 값 교체(pivot값과 작은값 위치 서로 교체)
				temp = list[j];
				list[j] = list[pivot];
				list[pivot] = temp;
			} else { //엇갈린 상태가 아니라면, i와 j 값 교체(큰값과 작은값 위치 서로 교체)
				temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		//데이터가 엇갈려서 밖으로 나온 경우, 해당 pivot 값을 기준으로 좌측 집합과 우측 집합의 정렬 수행		
		//좌측 그룹
		quickSort(list, start, j-1);
		//우측 그룹
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
