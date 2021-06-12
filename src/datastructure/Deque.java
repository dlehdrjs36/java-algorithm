package datastructure;

/**
 * 덱(양방향 연결리스트)
 * @author Dev History
 *
 * @param <T>
 */
public class Deque<T> {

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
	private Node tail;					//연결리스트 마지막 부분을 가리키는 멤버
	
	/**
	 * 덱이 비어있는지 확인하는 메소드
	 */
	private boolean DQIsEmpty() {
		if(head == null)
			return true;
		
		return false;
	}

	/**
	 * 덱의 앞부분에 데이터를 저장하는 메소드
	 * @param data
	 */
	private void DQAddFirst(T data) {
		Node newNode = new Node(data);
		newNode.nextLink = head;
		
		if(DQIsEmpty()) {
			tail = newNode;	
		}else {
			head.prevLink = newNode;
		}
		
		newNode.prevLink = null;
		head = newNode;
	}
	
	/**
	 * 덱의 뒷부분에 데이터를 저장하는 메소드
	 * @param data
	 */
	private void DQAddLast(T data) {
		Node newNode = new Node(data);
		newNode.prevLink = tail;
		
		if(DQIsEmpty()) {
			head = newNode;
		}else {
			tail.nextLink = newNode;
		}
		newNode.nextLink = null;
		tail = newNode;
	}

	/**
	 * 덱의 앞부분에 위치한 데이터를 삭제하는 메소드
	 * @return
	 */
	private T DQRemoveFirst() {
		if(DQIsEmpty())
			new ArrayIndexOutOfBoundsException("Queue Memory Empty!");
		
		Node rNode = head;
		head = rNode.nextLink;
		
		if(head == null) {
			tail = null;
		}else {
			head.prevLink = null;			
		}
		
		return rNode.data;
	}
	
	/**
	 * 덱의 뒷부분에 위치한 데이터를 삭제하는 메소드
	 * @return
	 */
	private T DQRemoveLast() {
		if(DQIsEmpty())
			new ArrayIndexOutOfBoundsException("Queue Memory Empty!");

		Node rNode = tail;
		tail = tail.prevLink;

		if(tail == null) {
			head = null;
		}else {
			tail.nextLink = null;		
		}
		
		return rNode.data;
	}

	/**
	 * 덱의 앞부분에 위치한 데이터를 조회하는 메소드
	 * @return
	 */
	private T DQGetFirst() {
		if(DQIsEmpty())
			new ArrayIndexOutOfBoundsException("Queue Memory Error!");
		
		return head.data;
	}
	
	/**
	 * 덱의 뒷부분에 위치한 데이터를 조회하는 메소드
	 * @return
	 */
	private T DQGetLast() {
		if(DQIsEmpty())
			new ArrayIndexOutOfBoundsException("Queue Memory Error!");
		
		return tail.data;
	}
	
	public static void main(String[] args) {
		Deque<Integer> Deque = new Deque<>();
		
		// 데이터 넣기 1차 ///////
		Deque.DQAddFirst(3); 
		Deque.DQAddFirst(2); 
		Deque.DQAddFirst(1); 

		Deque.DQAddLast(5); 
		Deque.DQAddLast(6);
		Deque.DQAddLast(4); 

		// 데이터 꺼내기 1차 ///////
		while(!Deque.DQIsEmpty())
			System.out.printf("%d ", Deque.DQRemoveFirst());

		System.out.printf("\n");

		// 데이터 넣기 2차 ///////
		Deque.DQAddFirst(3); 
		Deque.DQAddFirst(2); 
		Deque.DQAddFirst(1);
		
		Deque.DQAddLast(4); 
		Deque.DQAddLast(5); 
		Deque.DQAddLast(6);

		// 데이터 꺼내기 2차 ///////
		while(!Deque.DQIsEmpty())
			System.out.printf("%d ", Deque.DQRemoveLast());
	}
}
