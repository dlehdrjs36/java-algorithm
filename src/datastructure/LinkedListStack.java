package datastructure;

/**
 * 연결리스트 기반 스택
 * @author Dev History
 *
 * @param <T>
 */
public class LinkedListStack<T> {

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
	
	private Node head;
	
	public LinkedListStack() {
		head = null;
	}

	/**
	 * 스택이 비었는지 확인
	 * @return
	 */
	public boolean SIsEmpty() {
		if(head == null)
			return true;	
		
		return false;
	}
	
	/**
	 * 스택의 push 연산
	 * @param data
	 */
	public void SPush(T data) {
		Node newNode = new Node(data);
		newNode.nextLink = head;
		head = newNode;
	}
	
	/**
	 * 스택의 pop 연산
	 * @return
	 */
	public T SPop() {
		if(SIsEmpty())
			new ArrayIndexOutOfBoundsException("Stack Memory Error!");
		
		T rdata = head.data;
		head = head.nextLink;
		return rdata;
	}
	
	/**
	 * 스택의 peek 연산
	 * @return
	 */
	public T SPeek() {
		if(SIsEmpty())
			new ArrayIndexOutOfBoundsException("Stack Memory Error!");
		
		return head.data;
	}
	
	public static void main(String[] args) {
		// Stack의 생성 및 초기화 ///////
		LinkedListStack<Integer> stack = new LinkedListStack<>();

		// 데이터 넣기 ///////
		stack.SPush(1);
		stack.SPush(2);
		stack.SPush(3);
		stack.SPush(4);
		stack.SPush(5);

		// 데이터 조회 ///////
		System.out.println(stack.SPeek());
		
		// 데이터 꺼내기 ///////
		while(!stack.SIsEmpty())
			System.out.printf("%d ", stack.SPop()); 
		
	}
}
