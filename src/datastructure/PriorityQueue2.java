package datastructure;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * 힙 개선
 * 우선순위를 전달하지 않고 데이터만 전달해서 우선순위 판단하도록 개선
 * 
 * 데이터를 저장할 때 우선순위 정보를 별도로 전달하는 것은 적합하지 않은 경우가 많다.
 * 일반적으로 데이터의 우선순위는 데이터를 근거로 판단이 이뤄지기 때문이다.
 * @author DevHistory
 *
 * @param <T>
 */
public class PriorityQueue2<T> {

	final int HEAP_LEN = 100;
	
	class Heap<T>{
		Comparator<T> comp;
		int numOfData;
		T[] heapArr;

		public Heap(Class<T> clazz, Comparator<T> comp) {
			this.comp = comp;
			this.numOfData = 0;
			heapArr = (T[]) Array.newInstance(clazz, HEAP_LEN);
		}
	}
	
	/**
	 * 힙이 비었는지 확인하는 메소드
	 * @param ph
	 * @return
	 */
	public boolean HIsEmpty(Heap ph) {
		if(ph.numOfData == 0) return true;
		else return false;
	}
	
	/**
	 * 부모 노드의 인덱스 값을 반환하는 메소드
	 * @param idx
	 * @return
	 */
	public int GetParentIDX(int idx) {
		return idx/2;
	}
	
	/**
	 * 왼쪽 자식 노드의 인덱스 값을 반환하는 메소드
	 * @param idx
	 * @return
	 */
	public int GetLChildIDX(int idx) {
		return idx*2;
	}

	/**
	 * 오른쪽 자식 노드의 인덱스 값을 반환하는 메소드
	 * @param idx
	 * @return
	 */
	public int GetRChildIDX(int idx) {
		return GetLChildIDX(idx)+1;
	}
	
	/**
	 * 두 개의 자식 노드 중 높은 우선순위의 자식 노드 인덱스 값을 반환하는 메소드(완전이진트리의 특성을 이용하여 작성된 메소드)
	 * @param ph
	 * @param idx
	 * @return
	 */
	public int GetHiPriChildIDX(Heap ph, int idx) {
		//자식 노드가 존재하지 않는다면, 0 반환
		if(GetLChildIDX(idx) > ph.numOfData) //numOfData는 마지막 노드의 고유번호이니, 자식 노드의 값이 이보다 크면 존재하지 않는 자식 노드이다.
			return 0;

		//자식 노드가 왼쪽 자식 노드 하나만 존재한다면,
		//==왼쪽 자식 노드 하나만 존재할 때 그 자식 노드는 마지막 노드이다. 이는 완전 이진 트리의 특성
		else if(GetLChildIDX(idx) == ph.numOfData) //자식 노드가 하나 존재하면 이는 왼쪽 자식 노드이다. 완전 이진 트리 이므로 왼쪽 자식 노드가 없거나 하나만 존재할 수 밖에없다. 자식 노드가 존재한다면 이는 마지막 노드가 된다. 
			return GetLChildIDX(idx);
		//자식 노드가 둘 다 존재한다면,
		else {
			//오른쪽 자식 노드의 우선순위가 높다면
			if(ph.comp.compare(ph.heapArr[GetLChildIDX(idx)], ph.heapArr[GetRChildIDX(idx)]) < 0) { // comp에 등록된 함수의 호출결과를 통해서 우선순위를 판단한다.
				return GetRChildIDX(idx); //오른쪽 자식 노드의 인덱스 값 반환
			}
			//왼쪽 자식 노드의 우선순위가 높다면,
			else {
				return GetLChildIDX(idx); //왼쪽 자식 노드의 인덱스 값 반환
			}
		
		}
	}

	/**
	 * 힙에 데이터 저장하는 메소드
	 * @param ph
	 * @param data
	 */
	public void HInsert(Heap ph, T data) {
		int idx = ph.numOfData+1; //새 노드가 저장될 인덱스 값을 idx에 저장
		
		//새 노드가 저장될 위치가 루트 노드의 위치가 아니라면 while문 반복
		while(idx != 1) {
			//새 노드와 부모 노드의 우선순위 비교
			if(ph.comp.compare(data, ph.heapArr[GetParentIDX(idx)]) > 0){ //새 노드의 우선순위가 높다면
				//부모 노드를 한 레벨 내림, 실제로 내림
				ph.heapArr[idx] = ph.heapArr[GetParentIDX(idx)];
				//새 노드를 한 레벨 올림, 실제로 올리지는 않고 인덱스 값만 갱신
				idx = GetParentIDX(idx);
			}else {
				break;
			}
		}
		ph.heapArr[idx] = data; //새 노드 최종 저장
		ph.numOfData += 1;
	}
	
	/**
	 * 힙에서 데이터 삭제하는 메소드
	 * 삭제 후에는 완전이진트리가 유지되어야하지만 삭제 과정 중에는 편의상 필요하다면 유지되지 않아도 된다.
	 * 힙의 마지막 노드를 굳이 루트 노드에 저장하지않고 따로 빼서 비교를 완료한 후 루트 노드에 값 저장
	 * @param ph
	 * @return
	 */
	public T HDelete(Heap ph) {
		T retData = (T) ph.heapArr[1]; //반환을 위해서 삭제할 데이터 저장
		T lastElem = (T) ph.heapArr[ph.numOfData]; //힙의 마지막 노드 저장
		
		int parentIdx = 1; //루트 노드가 위치해야 할 인덱스 값 저장
		
		//루트 노드의 우선순위가 높은 자식 노드를 시작으로 반복문 시작
		while(GetHiPriChildIDX(ph, parentIdx) != 0 ){
			int childIdx = GetHiPriChildIDX(ph, parentIdx);
					
			if(ph.comp.compare(lastElem, ph.heapArr[childIdx]) >= 0) //마지막 노드와 우선순위 비교
				break; //마지막 노드의 우선순위가 높으면 루트 노드로 설정 
			
			//마지막 노드보다 우선순위 높으니, 비교대상 노드의 위치를 한 레벨 올림
			ph.heapArr[parentIdx] = ph.heapArr[childIdx];
			parentIdx = childIdx; //마지막 노드가 저장될 위치정보를 한 레벨 내림
		}//반복문 탈출하면 parentIdx에는 마지막 노드의 위치정보가 저장됨
		
		ph.heapArr[parentIdx] = lastElem; //마지막 노드 최종 저장
		ph.numOfData -= 1;
		return retData;
	}
	
	/**
	 * 우선순위 큐가 빈 경우를 검사하는 메소드
	 * @param heap
	 * @return
	 */
	public boolean PQIsEmpty(Heap heap) {
		return HIsEmpty(heap);
	}
	
	/**
	 * 우선순위 큐에 데이터를 저장하는 메소드
	 * @param heap
	 * @param data
	 */
	public void PEnqueue(Heap heap, T data) {
		HInsert(heap, data);
	}
	
	/**
	 * 우선순위 큐의 데이터를 삭제하는 메소드
	 * @param heap
	 * @return
	 */
	public T PDequeue(Heap heap) {
		return HDelete(heap);
	}

	public static void main(String[] args) {
		/**
		 * 힙 구현자가 내부적으로 아래와 같이 우선순위 판단 기준을 정함 
		 * 
		 * 첫 번째 인자의 우선순위가 높다면, 0보다 큰 값 반환
		 * 두 번째 인자의 우선순위가 높다면, 0보다 작은 값 반환
		 * 첫 번째, 두 번째 인자의 우선순위가 동일하다면, 0이 반환
		 */
		PriorityQueue2<Character> pq = new PriorityQueue2<>(); 
		PriorityQueue2.Heap heap = pq.new Heap<Character>(Character.class, (ch1, ch2)-> ch2-ch1);
		
		pq.PEnqueue(heap, 'A'); // 문자 'A'를 최고의 우선순위로 저장
		pq.PEnqueue(heap, 'B'); // 문자 'B'를 두 번째 우선순위로 저장
		pq.PEnqueue(heap, 'C'); // 문자 'C'를 세 번째 우선순위로 저장
		System.out.printf("%c \n", pq.PDequeue(heap)); 

		pq.PEnqueue(heap, 'A'); // 문자 'A' 한 번 더 저장 
		pq.PEnqueue(heap, 'B'); // 문자 'B' 한 번 더 저장
		pq.PEnqueue(heap, 'C'); // 문자 'C' 한 번 더 저장
		System.out.printf("%c \n", pq.PDequeue(heap));

		while(!pq.PQIsEmpty(heap)) 
			System.out.printf("%c \n", pq.PDequeue(heap));
	}
}
