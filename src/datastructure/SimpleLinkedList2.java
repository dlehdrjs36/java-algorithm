package datastructure;

import java.util.Comparator;

/**
 * 단방향 연결리스트
 * @author Dev History
 *
 * @param <T>
 */
public class SimpleLinkedList2<T> {
	
	//노드를 표현한 클래스
	private class Node{
		private T data;
		private Node nextLink;
		
		private Node() {
			this.data = null;
			this.nextLink = null;
		}
		private Node(T data) {
			this.data = data;
			this.nextLink = null;
		}
	}

	private Node head;					//더미 노드를 가리키는 멤버
	private Node cur;					//참조 및 삭제를 돕는 멤버
	private Node before;				//삭제를 돕는 멤버
	private int numOfData;				//저장된 데이터의 수를 기록하기 위한 멤버
	private Comparator<T> comp;			//정렬의 기준을 등록하기 위한 멤버
	private T data;
	
	public SimpleLinkedList2() {
		this.head = new Node(); //더미노드
		this.head.nextLink = null;
		this.comp = null;
		this.numOfData = 0;
	}

	/**
	 * 리스트에 데이터 저장
	 * @param data
	 */
	public void LInsert(T data) {
		if(comp == null) { //정렬기준이 마련되지 않았다면,
			FInsert(data);	// 머리에 노드를 추가
		} else { //정렬기준이 마련되었다면,
			SInsert(data); //정렬기준에 근거하여 노드를 추가
		}
	}
	
	/**
	 * 정렬이 기준이 마련되지 않았을 경우 추가
	 * @param data
	 */
	public void FInsert(T data) {
		Node newNode = new Node(data);
		newNode.nextLink = head.nextLink;
		head.nextLink = newNode;		 
		numOfData++;
	}
	
	/**
	 * 정렬 기준이 마련된 경우 추가
	 * @param data
	 */
	public void SInsert(T data) {
		Node newNode = new Node(data);
		Node pred = head;	//추가를 돕는 멤버 
		newNode.data = data;
		
		while(pred.nextLink != null && comp.compare(data, pred.nextLink.data) != 0) {
			pred = pred.nextLink;
		}
		newNode.nextLink = pred.nextLink;
		pred.nextLink = newNode;
		numOfData++;
	} 
	
	/**
	 * 저장된 첫 번째 데이터 탐색 및 탐색 초기화 용도
	 * @return
	 */
	public boolean LFirst() {
		if (head.nextLink == null) {
			return false;
		}
		before = head;			//더미 노드를 가리키게 함
		cur = head.nextLink;	//첫 번째 노드를 가리키게 함
		data = cur.data;	//첫 번째 노드의 데이터 전달
		return true;
	}
	
	/**
	 * 두 번째 이후 데이터 참조
	 * @return
	 */
	public boolean LNext() {
		if (cur.nextLink == null) {
			return false;
		}
		before = cur;		 //이전 노드를 가리키는 before을 한칸 우측 이동
		cur = cur.nextLink;	 //현재 노드를 가리키는 cur을 한칸 우측 이동
		data = cur.data;
		return true;
	}
	
	/**
	 * 참조한 데이터 삭제
	 * 두 번 이상 호출 되면 안됨. 한 번 호출 후 LNext() 또는 LFirst() 호출 후 사용가능 
	 * @return
	 */
	public T LRemove() {
		Node rpos = cur;
		T rdata = rpos.data;
		before.nextLink = cur.nextLink;
		cur = before;		//cur은 삭제 후 재조정의 과정을 거쳐야 하지만 before는 LFirst 또는 LNext 호출 시 재설정되므로 재조정의 과정이 불필요
		numOfData--;
		return rdata;
	}
	
	/**
	 * 저장되어 있는 데이터의 수를 반환
	 * @return
	 */
	public int LCount() {
		return numOfData;
	}
	
	/**
	 * 정렬 기준 설정
	 * @param comp
	 */
	public void SetSortRule(Comparator<T> comp) {
		this.comp = comp;
	}
	
	public static void main(String[] args) {
		SimpleLinkedList2<Integer> simpleLinkedList2 = new SimpleLinkedList2<>();
		simpleLinkedList2.SetSortRule(
				(d1, d2) -> {
					if(d1 < d2)
						return 0;    // d1이 정렬 순서상 앞선다.(head 쪽에 가깝다)
					else
						return 1;
				}
		);
		
		// 5개의 데이터 저장  ///////////////
		simpleLinkedList2.LInsert(11);
		simpleLinkedList2.LInsert(11);
		simpleLinkedList2.LInsert(22);
		simpleLinkedList2.LInsert(22);
		simpleLinkedList2.LInsert(33);
		
		// 저장된 데이터의 전체 출력 ////////////
		System.out.printf("현재 데이터의 수: %d \n", simpleLinkedList2.LCount());
		
		if(simpleLinkedList2.LFirst())
		{
			System.out.printf("%d ", simpleLinkedList2.data);
			
			while(simpleLinkedList2.LNext()) 
				System.out.printf("%d ", simpleLinkedList2.data);
		}
		System.out.printf("\n\n");

		// 숫자 22을 검색하여 모두 삭제 ////////////
		if(simpleLinkedList2.LFirst())
		{
			if(simpleLinkedList2.data == 22)
				simpleLinkedList2.LRemove();
			
			while(simpleLinkedList2.LNext())
			{
				if(simpleLinkedList2.data == 22)
					simpleLinkedList2.LRemove();
			}
		}

		// 삭제 후 저장된 데이터 전체 출력 ////////////
		System.out.printf("현재 데이터의 수: %d \n", simpleLinkedList2.LCount());

		if(simpleLinkedList2.LFirst())
		{
			System.out.printf("%d ", simpleLinkedList2.data);
			
			while(simpleLinkedList2.LNext())
				System.out.printf("%d ", simpleLinkedList2.data);
		}
		System.out.printf("\n\n");
		
		// 데이터 등록 후 저장된 데이터 전체 출력 ////////////
		simpleLinkedList2.LInsert(15);
		simpleLinkedList2.LInsert(55);
		simpleLinkedList2.LInsert(32);
		System.out.printf("현재 데이터의 수: %d \n", simpleLinkedList2.LCount());
		if(simpleLinkedList2.LFirst()) {
			System.out.printf("%d ", simpleLinkedList2.data);
			
			while(simpleLinkedList2.LNext())
				System.out.printf("%d ", simpleLinkedList2.data);
		}
	}
}
