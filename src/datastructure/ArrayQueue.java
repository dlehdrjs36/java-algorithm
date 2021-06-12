package datastructure;

import java.lang.reflect.Array;

/**
 * 배열기반 큐(원형 큐)
 * @author Dev History
 *
 * @param <T>
 */
public class ArrayQueue<T> {

	private static final int DEFAULT_ARRAY_SIZE = 8; 
	private T[] queueArr;
	private int front;	//출구
	private int rear;	//입구
	
	public ArrayQueue(Class<T> type) {
		queueArr = (T[]) Array.newInstance(type, DEFAULT_ARRAY_SIZE);
		front = 0;
		rear = 0;
	}

	/**
	 * front, rear 위치 계산하는 메소드
	 * @param pos
	 * @return
	 */
	private int NextPosIdx(int pos) {
		if(pos == DEFAULT_ARRAY_SIZE-1) {
			return 0;
		}else {
			return pos+1;	
		}
	}
	
	/**
	 * 큐가 비어있는지 확인하는 메소드
	 */
	private boolean QIsEmpty() {
		if(front == rear)
			return true;
		
		return false;
	}

	/**
	 * 큐에 데이터를 저장하는 메소드
	 * @param data
	 */
	private void Enqueue(T data) {
		rear = NextPosIdx(rear);
		if(rear == front)
			new ArrayIndexOutOfBoundsException("Queue Memory Full!");
		
		queueArr[rear] = data;	
	}

	/**
	 * 큐에 처음으로 저장된 요소를 삭제하는 메소드
	 * @return
	 */
	private T Dequeue() {
		if(QIsEmpty())
			new ArrayIndexOutOfBoundsException("Queue Memory Empty!");
		
		front = NextPosIdx(front); //front의 위치는 이미 삭제된 데이터로 간주한다. 따로 초기화 하지 않음 
		return queueArr[front];
	}

	/**
	 * 큐의 마지막에 저장된 요소를 조회하는 메소드
	 * @return
	 */
	private T QPeek() {
		if(QIsEmpty())
			new ArrayIndexOutOfBoundsException("Queue Memory Error!");
		
		int rIdx = NextPosIdx(front);
		return queueArr[rIdx];
	}
	
	public static void main(String[] args) {
		// Queue의 생성 및 초기화 ///////
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(Integer.class);
		
		// 데이터 넣기 ///////
		arrayQueue.Enqueue(1);
		arrayQueue.Enqueue(2);
		arrayQueue.Enqueue(3);  
		arrayQueue.Enqueue(4);
		arrayQueue.Enqueue(5);

		// 큐의 처음 데이터 조회 ///////
		System.out.println(arrayQueue.QPeek());
		
		// 데이터 꺼내기 ///////
		while(!arrayQueue.QIsEmpty())
			System.out.printf("%d ", arrayQueue.Dequeue()); 
	}
}
