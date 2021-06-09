package datastructure;

/**
 * 원형 연결리스트
 * @author Dev History
 *
 * @param <T>
 */
public class CircularLinkedList<T> {
	
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

	private Node tail;					
	private Node cur;					//참조 및 삭제를 돕는 멤버
	private Node before;				//삭제를 돕는 멤버
	private int numOfData;				//저장된 데이터의 수를 기록하기 위한 멤버
	private T data;
	
	public CircularLinkedList() {
		this.tail = null;
		this.cur = null;
		this.before = null;
		this.numOfData = 0;
	}

	/**
	 * 리스트에 데이터 저장(tail에 노드 추가 == tail이 신규노드로 변경)
	 * @param data
	 */
	public void LInsert(T data) {
		Node newNode = new Node(data);
		//첫 번째 노드는 머리이자 꼬리이다.
		if(tail == null) {
			tail = newNode; //tail
			newNode.nextLink = newNode; //head		 
		}else {
			newNode.nextLink = tail.nextLink;
			tail.nextLink = newNode;
			tail = newNode;
		}
		numOfData++;
	}
	
	/**
	 * 리스트에 데이터 저장(head에 노드 추가 == head가 신규노드로 변경)
	 * @param data
	 */
	public void LInsertFront(T data) {
		
		Node newNode = new Node(data);
		//첫 번째 노드는 머리이자 꼬리이다.
		if(tail == null) {
			tail = newNode; //tail
			newNode.nextLink = newNode; //head		 
		}else {
			newNode.nextLink = tail.nextLink;
			tail.nextLink = newNode;
		}
		numOfData++;
	}
	
	/**
	 * 저장된 첫 번째 데이터 탐색 및 탐색 초기화 용도
	 * @return
	 */
	public boolean LFirst() {
		if (tail == null) {
			return false;
		}
		before = tail;			//노드 삭제를 위해 필요한 멤버
		cur = tail.nextLink;	//첫 번째 노드를 가리키게 함
		data = cur.data;	//첫 번째 노드의 데이터 전달
		return true;
	}
	
	/**
	 * 두 번째 이후 데이터 참조
	 * @return
	 */
	public boolean LNext() {
		//원형 연결리스트이므로 리스트의 끝을 검사하는 코드가 없다.
		if (tail == null) {
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
	 * 원형 연결리스트에는 더미 노드가 없기 떄문에 삭제의 과정이 상황에 따라서 달라진다. 
	 * @return
	 */
	public T LRemove() {
		Node rpos = cur;
		T rdata = rpos.data;
		if(cur == tail) {
			//삭제 시, tail의 위치 조정
			if(tail == tail.nextLink) {
				tail = null;
			}else {
				tail = before;
			}
		}
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
		
	public static void main(String[] args) {
		CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
		
		// 5개의 데이터 저장  ///////////////
		circularLinkedList.LInsert(3);
		circularLinkedList.LInsert(4);
		circularLinkedList.LInsert(5);
		circularLinkedList.LInsertFront(2);
		circularLinkedList.LInsertFront(1);
		
		// 리스트에 저장된 데이터를 연속 3회 출력 ///////
		if(circularLinkedList.LFirst()) {
			System.out.printf("%d ", circularLinkedList.data);
			
			for (int i = 0; i < circularLinkedList.LCount()*3-1; i++) {
				if(circularLinkedList.LNext())
					System.out.printf("%d ", circularLinkedList.data);	
			}
		}
		System.out.printf("\n\n");

		// 2의 배수를 찾아서 모두 삭제 ///////
		int nodeNum = circularLinkedList.LCount();
		if(nodeNum != 0) {
			circularLinkedList.LFirst();
			if(circularLinkedList.data%2 == 0)
				circularLinkedList.LRemove();
			
			for(int i=0; i < nodeNum-1; i++) {
				circularLinkedList.LNext();
				if(circularLinkedList.data%2 == 0)
					circularLinkedList.LRemove();
			}
		}
		// 전체 데이터 1회 출력 ///////
		if(circularLinkedList.LFirst()) {
			System.out.printf("%d ", circularLinkedList.data);
			for(int i=0; i<circularLinkedList.LCount()-1; i++) {
				if(circularLinkedList.LNext())
					System.out.printf("%d ", circularLinkedList.data);
			}
		}
	}
}
