package datastructure;


/**
 * 
 * 단방향 연결리스트 구성요소 
 *
 * @param <T>
 */
class Node<T>{
	protected T data;
	protected Node<T> nextLink;
	
	public Node(T data) {
		this.data = data;
		this.nextLink = null;
	}
}

/**
 * 단방향 연결리스트
 * @author Dev History
 *
 * @param <T>
 */
public class SimpleLinkedList<T> {

	private Node<T> head;
	private int size;

	public SimpleLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * 입력한 데이터를 head로 설정
	 * @param nodeData 연결리스트 노드 데이터
	 */
	public void addFirst(T nodeData) {
		Node<T> newNode = new Node<T>(nodeData);
		newNode.nextLink = head;
		head = newNode;
		size++;
	}
	
	/**
	 * 입력한 데이터를 전달 받은 노드의 다음 노드로 설정
	 * @param prevNode 연결리스트 이전 노드  
	 * @param nodeData 연결리스트 노드 데이터
	 */
	public void addAfter(Node<T> prevNode, T nodeData) {
		Node<T> newNode = new Node<T>(nodeData);
		newNode.nextLink = prevNode.nextLink;
		prevNode.nextLink = newNode;
		size++;
	}
	
	/**
	 * 기존 헤드 노드 삭제
	 * @return 삭제된 노드 데이터
	 */
	public T removeFirst() {
		if(head != null) {
			Node<T> newHead = head.nextLink;
			T removeHeadData = head.data;
	
			head = newHead;
			size--;
			return removeHeadData;
		}
		return null;
	}
	
	/**
	 * 전달받은 노드의 다음 노드를 삭제
	 * @param prevNode 연결리스트 이전 노드  
	 * @return 삭제된 노드 데이터
	 */
	public T removeAfter(Node<T> prevNode) {
		if(prevNode.nextLink != null) {
			T removeNodeData = prevNode.nextLink.data;
			prevNode.nextLink = prevNode.nextLink.nextLink;
			size--;
			return removeNodeData;
		}
		return null;
	}
	
	/**
	 * 전달받은 데이터를 가지고 있는 노드의 번호를 찾는다.
	 * @param nodeData 연결리스트 노드 데이터
	 * @return 연결리스트 노드 위치 번호
	 */
	public int indexOf(T nodeData) {
		Node<T> searchNode = head;
		int index = 0;
		while(searchNode != null) {
			if(searchNode.data.equals(nodeData)) {
				return index;
			}
			searchNode = searchNode.nextLink;
			index++;
		}
		return -1;
	}
	
	/**
	 * 전달받은 번호의 노드를 반환한다.
	 * @param index 연결리스트 노드 위치 번호
	 * @return 전달받은 노드 위치에 해당하는 연결리스트 노드
	 */
	public Node<T> getNode(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
		Node<T> searchNode = head;
		for (int i = 0; i < index; i++) {
			searchNode = searchNode.nextLink;
		}
		return searchNode;
	}
	
	/**
	 * 전달받은 번호의 노드 데이터를 반환한다.
	 * @param index 연결리스트 노드 위치 번호
	 * @return 전달받은 노드 위치에 해당하는 연결리스트 노드 데이터
	 */
	public T get(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
		return getNode(index).data;
	}
	
	/**
	 * 전달받은 번호의 위치에 새로운 데이터를 삽입한다.
	 * @param index 연결리스트 노드 위치 번호
	 * @param nodeData 연결리스트 노드 데이터
	 */
	public void add(int index, T nodeData) {
		//노드 추가 시, size+1이 되기때문에 index값을 size까지 유효성 검사
		if(index < 0 || index > size) {
			return;
		}
		if(index == 0) {
			addFirst(nodeData);
		}else {
			Node<T> node = getNode(index-1);
			addAfter(node, nodeData);
		}
	}

	/**
	 * 전달받은 번호 위치의 노드를 삭제한다.
	 * @param index 연결리스트 노드 위치 번호
	 * @return 삭제된 노드 데이터
	 */
	public T remove(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
		if(index == 0) {
			return removeFirst();
		}
		Node<T> prevNode = getNode(index-1);
		return removeAfter(prevNode);
	}
	
	
	/**
	 * 전달받은 데이터를 가지고 있는 노드를 찾아 삭제한다.
	 * @param nodeData 연결리스트 노드 데이터
	 * @return 삭제된 노드 데이터
	 */
	public T remove(T nodeData) {
//		int index = indexOf(nodeData);
//
//		if(index == -1) {
//			return null;
//		}
//		
//		if(index == 0) {
//			return removeFirst();
//		}
//		
//		Node<T> prevNode = getNode(index-1);
//		
//		return removeAfter(prevNode);
		
		Node<T> p = head; //현재 노드
		Node<T> q = null; //이전 노드
		
		while(p != null && !p.data.equals(nodeData)) {
			q = p;
			p = p.nextLink;
		}
		if(p == null) {
			return null;
		}
		if(q == null) {
			return removeFirst();
		}else {
			return removeAfter(q);
		}
		
	}
	
	public static void main(String[] args) {

		SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();

		simpleLinkedList.add(0, "Data1");
		simpleLinkedList.add(1, "Data2");
		simpleLinkedList.add(2, "Data3");
		simpleLinkedList.add(3, "Data4");
		simpleLinkedList.add(4, "Data5");

		String str = simpleLinkedList.get(2);
		int pos = simpleLinkedList.indexOf("Data4");
		System.out.println(str);
		System.out.println(simpleLinkedList.remove(2));
		System.out.println();
		System.out.println(simpleLinkedList.get(2));
		System.out.println(pos);
		
	}
}
