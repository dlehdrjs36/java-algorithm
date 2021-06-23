package datastructure;

public class PriorityQueue {

	final int HEAP_LEN = 100;
	
	/* 힙을 우선순위 큐처럼 사용하기 위해 구현 */
	class HeapElem{
		int pr;	//값이 작을수록 높은 우선순위, 이는 우선 순위 큐와 관련된 내용
		char data;
		
		public HeapElem(int pr, char data) {
			this.pr = pr;
			this.data = data;
		}
	}
	
	class Heap{
		int numOfData;
		HeapElem[] heapArr;

		public Heap() {
			this.numOfData = 0;
			heapArr = new HeapElem[HEAP_LEN];
		}
	}
	
	//힙 비었는지 확인
	public boolean HIsEmpty(Heap ph) {
		if(ph.numOfData == 0) return true;
		else return false;
	}
	
	/* 헬퍼 메소드 */ 
	//부모 노드의 인덱스 얻기
	public int GetParentIDX(int idx) {
		return idx/2;
	}
	
	//왼쪽 자식 노드의 인덱스 값
	public int GetLChildIDX(int idx) {
		return idx*2;
	}

	//오른쪽 자식 노드의 인덱스 값
	public int GetRChildIDX(int idx) {
		return GetLChildIDX(idx)+1;
	}
	
	//우선 순위가 높은 자식의 인덱스 값 반환(완전이진트리의 특성을 이용하여 작성된 메소드)
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
			if(ph.heapArr[GetLChildIDX(idx)].pr > ph.heapArr[GetRChildIDX(idx)].pr) {
				return GetRChildIDX(idx); //오른쪽 자식 노드의 인덱스 값 반환
			}
			//왼쪽 자식 노드의 우선순위가 높다면,
			else {
				return GetLChildIDX(idx); //왼쪽 자식 노드의 인덱스 값 반환
			}
		
		}
			
		
	}
	/*//헬퍼 메소드 */
	
	//힙 등록
	public void HInsert(Heap ph, char data, int pr) {
		int idx = ph.numOfData+1; //새 노드가 저장될 인덱스 값을 idx에 저장
		HeapElem newNode = new HeapElem(pr, data); //새 노드의 생성 및 초기화
		
		//새 노드가 저장될 위치가 루트 노드의 위치가 아니라면 while문 반복
		while(idx != 1) {
			//새 노드와 부모 노드의 우선순위 비교
			if(pr <  ph.heapArr[GetParentIDX(idx)].pr) { //새 노드의 우선순위가 높다면
				//부모 노드를 한 레벨 내림, 실제로 내림
				ph.heapArr[idx] = ph.heapArr[GetParentIDX(idx)];
				//새 노드를 한 레벨 올림, 실제로 올리지는 않고 인덱스 값만 갱신
				idx = GetParentIDX(idx);
			}else {
				break;
			}
		}
		ph.heapArr[idx] = newNode; //새 노드 최종 저장
		ph.numOfData += 1;
	}
	
	//힙 삭제
	//삭제 후에는 완전이진트리가 유지되어야하지만 삭제 과정 중에는 편의상 필요하다면 유지되지 않아도 된다.
	//힙의 마지막 노드를 굳이 루트 노드에 저장하지않고 따로 빼서 비교를 완료한 후 루트 노드에 값 저장 
	public char HDelete(Heap ph) {
		char retData = ph.heapArr[1].data; //반환을 위해서 삭제할 데이터 저장
		HeapElem lastElem = ph.heapArr[ph.numOfData]; //힙의 마지막 노드 저장
		
		int parentIdx = 1; //루트 노드가 위치해야 할 인덱스 값 저장
		
		//루트 노드의 우선순위가 높은 자식 노드를 시작으로 반복문 시작
		while(GetHiPriChildIDX(ph, parentIdx) != 0 ){
			int childIdx = GetHiPriChildIDX(ph, parentIdx);
					
			if(lastElem.pr <= ph.heapArr[childIdx].pr) //마지막 노드와 우선순위 비교
				break; //마지막 노드의 우선순위가 높으면 루트 노드로 설정 
			
			//마지막 노드보다 우선순위 높으니, 비교대상 노드의 위치를 한 레벨 올림
			ph.heapArr[parentIdx] = ph.heapArr[childIdx];
			parentIdx = childIdx; //마지막 노드가 저장될 위치정보를 한 레벨 내림
		}//반복문 탈출하면 parentIdx에는 마지막 노드의 위치정보가 저장됨
		
		ph.heapArr[parentIdx] = lastElem; //마지막 노드 최종 저장
		ph.numOfData -= 1;
		return retData;
	}
	
	public static void main(String[] args) {
		//데이터를 저장할 때 우선순위 정보를 별도로 전달하는 것은 적합하지 않은 경우가 많다.
		//일반적으로 데이터의 우선순위는 데이터를 근거로 판단이 이뤄지기 때문이다.
		PriorityQueue pq = new PriorityQueue();
		PriorityQueue.Heap heap = pq.new Heap();
		
		pq.HInsert(heap, 'A', 1); // 문자 'A'를 최고의 우선순위로 저장
		pq.HInsert(heap, 'B', 2); // 문자 'B'를 두 번째 우선순위로 저장
		pq.HInsert(heap, 'C', 3); // 문자 'C'를 세 번째 우선순위로 저장
		System.out.printf("%c \n", pq.HDelete(heap));
		pq.HInsert(heap, 'A', 1); // 문자 'A' 한 번 더 저장
		pq.HInsert(heap, 'B', 2); // 문자 'B' 한 번 더 저장
		pq.HInsert(heap, 'C', 3); // 문자 'C' 한 번 더 저장
		System.out.printf("%c \n", pq.HDelete(heap));
		
		while(!pq.HIsEmpty(heap))
			System.out.printf("%c \n", pq.HDelete(heap));
	}

}
