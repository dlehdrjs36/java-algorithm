package datastructure;

/**
 * 연결리스트 기반 큐
 * @author Dev History
 *
 * @param <T>
 */
public class LinkedListQueue<T> {

	private Node front;	//출구(머리, 삭제)
	private Node rear;	//입구(꼬리, 삽입)
	
	//노드를 표현한 클래스
	private class Node{
		private T data;
		private Node nextLink;
		
		private Node(T data) {
			this.data = data;
			this.nextLink = null;
		}
	}
		
	public LinkedListQueue() {
		front = null;
		rear = null;
	}

	/**
	 * 큐가 비어있는지 확인하는 메소드
	 */
	private boolean QIsEmpty() {
		if(front == null)
			return true;
		
		return false;
	}

	/**
	 * 큐에 데이터를 저장하는 메소드
	 * @param data
	 */
	private void Enqueue(T data) {
		Node newNode = new Node(data);
		
		if(QIsEmpty()) {
			front = newNode;
			rear = newNode;
		}else {
			rear.nextLink = newNode;
			rear = newNode;
		}
	}

	/**
	 * 큐에 처음으로 저장된 요소를 삭제하는 메소드
	 * @return
	 */
	private T Dequeue() {
		if(QIsEmpty()) {
			new ArrayIndexOutOfBoundsException("Queue Memory Empty!");
		}
		Node rNode = front;
		front = front.nextLink;
		
		return rNode.data;
	}

	/**
	 * 큐의 마지막에 저장된 요소를 조회하는 메소드
	 * @return
	 */
	private T QPeek() {
		if(QIsEmpty()) {
			new ArrayIndexOutOfBoundsException("Queue Memory Empty!");
		}
		Node rNode = front;
		
		return rNode.data;
	}
	
	public static void main(String[] args) {
		// Queue의 생성 및 초기화 ///////
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		
		// 데이터 넣기 ///////
		linkedListQueue.Enqueue(1);
		linkedListQueue.Enqueue(2);
		linkedListQueue.Enqueue(3);  
		linkedListQueue.Enqueue(4);
		linkedListQueue.Enqueue(5);

		// 큐의 처음 데이터 조회 ///////
		System.out.printf("%d ", linkedListQueue.QPeek());
		System.out.printf("%d \n", linkedListQueue.QPeek());
		
		// 큐의 데이터 삭제(꺼내기) ///////
		System.out.printf("%d ", linkedListQueue.Dequeue());
		System.out.printf("%d \n", linkedListQueue.Dequeue());
		
		// 남은 데이터 삭제(꺼내기) ///////
		while(!linkedListQueue.QIsEmpty())
			System.out.printf("%d ", linkedListQueue.Dequeue()); 
	}
}
