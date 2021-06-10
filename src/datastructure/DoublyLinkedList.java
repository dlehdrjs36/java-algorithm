package datastructure;

/**
 * 양방향 연결리스트
 * @author Dev History
 *
 * @param <T>
 */
public class DoublyLinkedList<T> {
	
	//노드를 표현한 클래스
	private class Node{
		private T data;
		private Node prevLink;
		private Node nextLink;
		
		private Node(T data) {
			this.data = data;
			this.prevLink = null;
			this.nextLink = null;
		}
	}

	private Node head;					//연결리스트 시작 부분을 가리키는 멤버
	private Node cur;					//참조 및 삭제를 돕는 멤버
	private int numOfData;				//저장된 데이터의 수를 기록하기 위한 멤버
	private T data;
	
	/**
	 * 리스트에 데이터 저장(head)
	 * @param data
	 */
	public void LInsert(T data) {
		Node newNode = new Node(data);
		
		newNode.nextLink = head;
		if(head != null)
			head.prevLink = newNode;
		
		newNode.prevLink = null;
		head = newNode;
		numOfData++;
	}
	
	/**
	 * 저장된 첫 번째 데이터 탐색 및 탐색 초기화 용도
	 * @return
	 */
	public boolean LFirst() {
		if (head == null) {
			return false;
		}
		cur = head;
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
		cur = cur.nextLink;	 //현재 노드를 가리키는 cur을 한칸 우측 이동
		data = cur.data;
		return true;
	}
	
	/**
	 * 이전 데이터 탐색 
	 * @return
	 */
	public boolean LPrevious() {
		if (cur.prevLink == null) {
			return false;
		}
		cur = cur.prevLink;	 //현재 노드를 가리키는 cur을 한칸 좌측 이동
		data = cur.data;
		return true;
	}
	
	/**
	 * 참조한 데이터 삭제
	 * @return
	 */
	public T LRemove() {
		Node rpos = cur;
		T rdata = rpos.data;
		
		//현재 삭제노드가 가리키는 다음 노드를 이전 노드의 next가 가리키게 만든다.
		cur.prevLink.nextLink = cur.nextLink;
		
		//현재 삭제노드가 가리키는 다음 노드의 prev가 현재 삭제노드의 prev를 가리키게 만든다.
		cur.nextLink.prevLink = cur.prevLink;
		
		//현재 참조 위치 좌측으로 이동
		cur = cur.prevLink;
		
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
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> DoublyLinkedList = new DoublyLinkedList<>();
		
		// 9개의 데이터 저장  ///////////////
		DoublyLinkedList.LInsert(1);
		DoublyLinkedList.LInsert(2);
		DoublyLinkedList.LInsert(3);
		DoublyLinkedList.LInsert(4);
		DoublyLinkedList.LInsert(5);
		DoublyLinkedList.LInsert(6);
		DoublyLinkedList.LInsert(2);
		DoublyLinkedList.LInsert(7);
		DoublyLinkedList.LInsert(8);
		
		// 저장된 데이터의 조회  ///////
		System.out.printf("현재 데이터의 수: %d \n", DoublyLinkedList.LCount());
		if(DoublyLinkedList.LFirst()) {
			System.out.printf("%d ", DoublyLinkedList.data);
			
			while(DoublyLinkedList.LNext()) 
				System.out.printf("%d ", DoublyLinkedList.data);
			
			while(DoublyLinkedList.LPrevious()) 
				System.out.printf("%d ", DoublyLinkedList.data);
		}
		System.out.printf("\n\n");

		// 숫자 2을 검색하여 모두 삭제 ////////////
		if(DoublyLinkedList.LFirst()) {
			if(DoublyLinkedList.data == 2)
				DoublyLinkedList.LRemove();
			
			while(DoublyLinkedList.LNext())
			{
				if(DoublyLinkedList.data == 2)
					DoublyLinkedList.LRemove();
			}
		}

		// 삭제 후 저장된 데이터의 조회 ////////////
		System.out.printf("현재 데이터의 수: %d \n", DoublyLinkedList.LCount());
		if(DoublyLinkedList.LFirst()) {
			System.out.printf("%d ", DoublyLinkedList.data);
			
			while(DoublyLinkedList.LNext()) 
				System.out.printf("%d ", DoublyLinkedList.data);
			
			while(DoublyLinkedList.LPrevious()) 
				System.out.printf("%d ", DoublyLinkedList.data);
		}
	}
}
