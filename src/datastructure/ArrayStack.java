package datastructure;

import java.lang.reflect.Array;

/**
 * 배열 기반 스택
 * @author Dev History
 *
 * @param <T>
 */
public class ArrayStack<T> {

	private static final int DEFAULT_ARRAY_SIZE = 8; 
	private T[] stackArr;
	private int top;
	
	public ArrayStack(Class<T> type) {
		stackArr = (T[]) Array.newInstance(type, DEFAULT_ARRAY_SIZE);
		top = -1;
	}

	/**
	 * 스택이 비었는지 확인
	 * @return
	 */
	public boolean SIsEmpty() {
		if(top == -1)
			return true;	
		
		return false;
	}
	
	/**
	 * 스택의 push 연산
	 * @param data
	 */
	public void SPush(T data) {
		top++;
		this.stackArr[top] = data;
	}
	
	/**
	 * 스택의 pop 연산
	 * @return
	 */
	public T SPop() {
		//Spop() 내부에서는 해당 위치가 유효한 데이터의 위치임을 보장한다.
		//배열에서의 삭제는 해당 위치의 값을 초기화 시켜주지 않아도 된다.
		//top의 위치가 변경되면 기존 위치에 데이터가 있더라도 유효한 데이터로 인정되지 못한다.
		if(SIsEmpty()) {
			new ArrayIndexOutOfBoundsException("Stack Memory Error!");
		}
		int rIdx = top;
		top--;
		return this.stackArr[rIdx];
	}
	
	/**
	 * 스택의 peek 연산
	 * @return
	 */
	public T SPeek() {
		if(SIsEmpty()) {
			System.out.println("Stack Memory Error!");
		}
		return this.stackArr[top];
	}
	
	public static void main(String[] args) {
		// Stack의 생성 및 초기화 ///////
		ArrayStack<Integer> stack = new ArrayStack<>(Integer.class);

		// 데이터 넣기 ///////
		stack.SPush(1);
		stack.SPush(2);
		stack.SPush(3);
		stack.SPush(4);
		stack.SPush(5);

		// 데이터 꺼내기 ///////
		while(!stack.SIsEmpty())
			System.out.printf("%d ", stack.SPop()); 
	}
}
