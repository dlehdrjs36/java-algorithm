package datastructure;

import java.lang.reflect.Array;

/**
 * 배열 기반 리스트
 * @author Dev History
 *
 * @param <T>
 */
public class SimpleArrayList<T> {

	private static final int DEFAULT_ARRAY_SIZE = 8; 
	private T[] plist;
	private T data;
	private int numOfData; //리스트에 저장된 데이터의 수
	private int curPosition; //마지막 참조 위치에 대한 정보 저장
	
	/**
	 * 제네릭 배열을 일반적으로 사용 시, 오류가 발생하는 이유는 
	 * array의 인스턴스 생성시 컴포넌트 종류(component type)를 미리 알고 있어야 하기 때문이다. 
	 * 사용 시에 컴포넌트의 종류를 알수있는 제네릭은 그래서 불가능하다.
	 * 
	 * 사용 시 컴포넌트 종류를 전달받아 생성해야하는데 그  방법으로 Array.newInstance를 사용해야 한다.
	 * 생성자 호출 시, 리플렉션 객체를 넘겨주어 제네릭 배열을 생성되도록 한다. 초기 배열의 길이는 8이다.
	 */
	public SimpleArrayList(Class<T> clazz) {
		plist = (T[])Array.newInstance(clazz, DEFAULT_ARRAY_SIZE);
		this.numOfData = 0;
		this.curPosition = -1; // -1은 아무런 위치도 참조하지 않았음을 의미. 0이라면 0번째 위치를 참조
	}
	
	//리스트에 데이터 저장
	public void LInsert(T data) {
		if(numOfData > plist.length) { //더 이상 저장할 공간이 없다면
			System.out.println("저장이 불가능합니다.");
			return;
		}
		plist[numOfData] = data; //데이터 저장
		numOfData++; //저장된 데이터의 수 증가
	}
	
	//저장된 첫 번째 데이터 탐색 및 탐색 초기화 용도
	public boolean LFirst() {
		if(numOfData == 0) {
			return false; 
		}
		curPosition = 0;
		this.data = (T) plist[0];
		return true;
	}
	
	//두 번째 이후 데이터 참조
	public boolean LNext() {
		if(curPosition >= numOfData-1) { //더 이상 참조할 데이터가 없다면
			return false; 
		}
		curPosition++;		
		this.data = plist[curPosition];
		return true;
	}
	
	//참조한 데이터 삭제
	public T LRemove() {
		int rpos = curPosition;
		int num = numOfData;
		int i;
		T rdata = plist[rpos]; //삭제할 데이터를 임시로 저장
		//삭제를 위한 데이터의 이동을 진행하는 반복문
		for (i = rpos; i < num-1; i++) {
			plist[i] = plist[i+1]; 
		}
		numOfData--; //데이터의 수 감소
		curPosition--; //참조위치를 하나 되돌린다.
		return rdata;
	}
	
	//저장되어 있는 데이터의 수를 반환
	public int LCount() {
		return numOfData;
	}

	public static void main(String[] args) {
		//ArrayList 생성 및 초기화
		SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<Integer>(Integer.class);
		
		//5개의 데이터 저장
		simpleArrayList.LInsert(11);
		simpleArrayList.LInsert(11);
		simpleArrayList.LInsert(22);
		simpleArrayList.LInsert(22);
		simpleArrayList.LInsert(33);
		
		//저장된 데이터의 전체 출력
		System.out.println("현재 데이터의 수: " + simpleArrayList.LCount());
		if(simpleArrayList.LFirst()) { //첫 번째 데이터 조회
			System.out.print(simpleArrayList.data);
			
			while(simpleArrayList.LNext()) { //두 번째 이후의 데이터 조회
				System.out.print(" "+simpleArrayList.data);
			}
		}
		System.out.println();
		System.out.println();
		//숫자 22를 탐색하여 모두 삭제
		if(simpleArrayList.LFirst()) { //첫 번째 데이터 조회
			if(simpleArrayList.data == 22)
				simpleArrayList.LRemove();
			
			while(simpleArrayList.LNext()) { //두 번째 이후의 데이터 조회
				if(simpleArrayList.data == 22)
					simpleArrayList.LRemove();
			}
		}
		//삭제 후 저장된 데이터 전체 출력
		System.out.println("현재 데이터의 수: " + simpleArrayList.LCount());
		if(simpleArrayList.LFirst()) { //첫 번째 데이터 조회
			System.out.print(simpleArrayList.data);
			
			while(simpleArrayList.LNext()) { //두 번째 이후의 데이터 조회
				System.out.print(" "+simpleArrayList.data);
			}
		}
	}
}
