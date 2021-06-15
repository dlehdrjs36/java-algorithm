package datastructure.binarytree;

import datastructure.ArrayStack;

/**
 * 수식 트리
 * @author Dev History
 *
 */
public class ExpressionTree<T> {
	
	/*
	 * 이진 트리의 노드이자 이진 트리를 표현한 클래스
	 * 이진 트리의 모든 노드는 직/간접적으로 연결되어 있다. 
	 * 따라서 루트 노드의 값만 기억하면, 이진 트리 전체를 가리키는 것과 다름이 없다.
	 * 
	 * 논리적으로도 하나의 노드는 그 자체로 이진트리이다.
	 * 따라서 노드를 표현한 클래스는 실제로 이진 트리를 표현한 클래스가 된다.
	 */
	private class BinaryNode{
		private T data;
		private BinaryNode left;
		private BinaryNode right;
		
		public BinaryNode(){
			data = null;
			left = null;
			right = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}
	}
	
	/* 도구 */
	/**
	 * 수식 트리 노드 생성
	 * @return
	 */
	public BinaryNode MakeBinaryTreeNode() {
		BinaryNode binaryNode = new BinaryNode();
		return binaryNode;
	}
	
	/**
	 * 수식 트리 노드에 저장된 데이터를 반환
	 * @param bn
	 * @return
	 */
	public T GetData(BinaryNode bn) {
		return bn.getData();
	}
	
	/**
	 * 수식 트리 노드에 데이터를 저장
	 * @param bn
	 * @param data
	 */
	public void SetData(BinaryNode bn, T data) {
		bn.setData(data);
	}
	
	/**
	 * 수식 트리 왼쪽 서브 트리의 주소 값 반환
	 * @param bn
	 * @return
	 */
	public BinaryNode GetLeftSubTree(BinaryNode bn) {
		return bn.left; 
	}
	
	/**
	 * 수식 트리 오른쪽 서브 트리의 주소 값 반환
	 * @param bn
	 * @return
	 */
	public BinaryNode GetRightSubTree(BinaryNode bn) {
		return bn.right; 
	}

	/**
	 * 수식 트리 왼쪽 서브 트리 설정
	 * main의 왼쪽의 서브 트리를 sub로 설정
	 * @param main
	 * @param sub
	 * @return
	 */
	public void MakeLeftSubTree(BinaryNode main, BinaryNode sub) {
		main.left = sub; 
	}
	
	/**
	 * 수식 트리 오른쪽 서브 트리 설정
	 * main의 오른쪽의 서브 트리를 sub로 설정
	 * @param main
	 * @param sub
	 * @return
	 */
	public void MakeRightSubTree(BinaryNode main, BinaryNode sub) {
		main.right = sub;
	}
	
	
	/**
	 * 수식 트리의 중위 순회
	 * @param bn
	 */
	public void InorderTraverse(BinaryNode bn) {
		if(bn == null) return;	//현재 노드가 자식이 없는 경우 탈출. 즉, 서브 트리가 없고 단순히 노드일 경우

		//일단 서브트리가 존재하는 것으로 가정하고 순회
		InorderTraverse(bn.left);
		System.out.printf("%d \t", bn.data); //루트 노드의 데이터 출력
		InorderTraverse(bn.right);
	}

	/**
	 * 수식 트리의 중위 순회(방문 목적 사용)
	 * @param bn
	 */
	public void InorderTraverse(BinaryNode bn, BinaryTreeVisitor<T> visitFuncPtr) {
		if(bn == null) return;	//현재 노드가 자식이 없는 경우 탈출. 즉, 서브 트리가 없고 단순히 노드일 경우

		//일단 서브트리가 존재하는 것으로 가정하고 순회
		InorderTraverse(bn.left, visitFuncPtr);
		visitFuncPtr.action(bn.data); //루트 노드의 데이터 출력(방문 목적)
		InorderTraverse(bn.right, visitFuncPtr);
	}
	
	/**
	 * 수식 트리의 후위 순회
	 * @param bn
	 */
	public void PostorderTraverse(BinaryNode bn) {
		if(bn == null) return;	//현재 노드가 자식이 없는 경우 탈출. 즉, 서브 트리가 없고 단순히 노드일 경우

		//일단 서브트리가 존재하는 것으로 가정하고 순회
		PostorderTraverse(bn.left);
		PostorderTraverse(bn.right);
		System.out.printf("%d \t", bn.data); //루트 노드의 데이터 출력
	}
	
	/**
	 * 수식 트리의 후위 순회(방문 목적 사용)
	 * @param bn
	 */
	public void PostorderTraverse(BinaryNode bn, BinaryTreeVisitor<T> visitFuncPtr) {
		if(bn == null) return;	//현재 노드가 자식이 없는 경우 탈출. 즉, 서브 트리가 없고 단순히 노드일 경우

		//일단 서브트리가 존재하는 것으로 가정하고 순회
		PostorderTraverse(bn.left, visitFuncPtr);
		PostorderTraverse(bn.right, visitFuncPtr);
		visitFuncPtr.action(bn.data); //루트 노드의 데이터 출력
	}

	/**
	 * 수식 트리의 전위 순회
	 * @param bn
	 */
	public void PreorderTraverse(BinaryNode bn) {
		if(bn == null) return;	//현재 노드가 자식이 없는 경우 탈출. 즉, 서브 트리가 없고 단순히 노드일 경우

		//일단 서브트리가 존재하는 것으로 가정하고 순회
		System.out.printf("%d \t", bn.data); //루트 노드의 데이터 출력
		PreorderTraverse(bn.left);
		PreorderTraverse(bn.right);
	}
	
	/**
	 * 수식 트리의 전위 순회(방문 목적 사용)
	 * @param bn
	 */
	public void PreorderTraverse(BinaryNode bn, BinaryTreeVisitor<T> visitFuncPtr) {
		if(bn == null) return;	//현재 노드가 자식이 없는 경우 탈출. 즉, 서브 트리가 없고 단순히 노드일 경우

		//일단 서브트리가 존재하는 것으로 가정하고 순회
		visitFuncPtr.action(bn.data); //루트 노드의 데이터 출력
		PreorderTraverse(bn.left, visitFuncPtr);
		PreorderTraverse(bn.right, visitFuncPtr);
	}
	/*//도구 */
	
	/**
	 * 수식 트리 구성
	 * 마지막으로 반환되는 스택은 해당 수식 트리의 루트 노드 주소가 반환된다.(최종 결과는 스택에서 반환)
	 * @param exp
	 * @return
	 */
	public BinaryNode MakeExpTree(char[] exp) {
		ArrayStack<BinaryNode> stack = new ArrayStack(BinaryNode.class);
		int expLen = exp.length;
		int i;
		
		for (i = 0; i < expLen; i++) {
			BinaryNode binaryNode = MakeBinaryTreeNode();
			if(Character.isDigit(exp[i])) { //피연산자 라면 무조건 스택으로 저장
				SetData(binaryNode, (T) Integer.valueOf((exp[i]-'0')));
			}else {// 연산자를 만나면 스택에 저장된(피연산자 또는 서브트리)것 두 개 꺼내어 트리 구성하고 스택으로 저장
				MakeRightSubTree(binaryNode, stack.SPop());
				MakeLeftSubTree(binaryNode, stack.SPop());
				SetData(binaryNode, (T) Character.valueOf(exp[i]));
			}
			stack.SPush(binaryNode);
		}
		//완성된 수식 트리의 루트 노드 주소 반환
		return stack.SPop();
	}
	
	/**
	 * 수식 트리 계산
	 * @param bn
	 * @return
	 */
	public int EvaluateExpTree(BinaryNode bn) {
		int op1, op2;

		//단말 노드의 경우 탈출조건으로 설정(단순히 데이터만 반환)
		if(GetLeftSubTree(bn) == null && GetRightSubTree(bn) == null)
			return (int) GetData(bn);
		
		//서브트리의 경우를 고려하여 재귀적으로 설정
		op1 = EvaluateExpTree(GetLeftSubTree(bn));
		op2 = EvaluateExpTree(GetRightSubTree(bn));
		switch ((char)GetData(bn)) {
			case '+': 
				return op1+op2;
			case '-':
				return op1-op2;
			case '*':
				return op1*op2;
			case '/':
				return op1/op2;
		}
		return 0;
	}
	
	public BinaryTreeVisitor<T> ShowNodeData() {
		BinaryTreeVisitor<T> showNodeData = 
				(T) -> {
					if(T instanceof Integer) {
						if(0 <= (int) T && (int) T <= 9)
							System.out.printf("%d ", T); //피연산자 출력	
					}else {
						System.out.printf("%c ", T); //연산자 출력
					}
				};
		
		return showNodeData;
	}
	/**
	 * 전위 표기법 기반 출력(방문 목적을 이용)
	 * @param bn
	 */
	public void ShowPrefixTypeExp(BinaryNode bn) {
		PreorderTraverse(bn, ShowNodeData());
	}
	
	/**
	 * 즁위 표기법 기반 출력(방문 목적을 이용)
	 * @param bn
	 */
	public void ShowInfixTypeExp(BinaryNode bn) {
		InorderTraverse(bn, ShowNodeData());
	}
	
	/**
	 * 후위 표기법 기반 출력(방문 목적을 이용)
	 * @param bn
	 */
	public void ShowPostfixTypeExp(BinaryNode bn) {
		PostorderTraverse(bn, ShowNodeData());
	}
	
	public static void main(String[] args) {
		ExpressionTree<?> expressionTree = new ExpressionTree<>();
		char exp[] = {'1','2','+','7','*'};
		
		ExpressionTree.BinaryNode eTree = expressionTree.MakeExpTree(exp);

		System.out.printf("전위 표기법의 수식: ");
		expressionTree.ShowPrefixTypeExp(eTree);
		System.out.printf("\n");

		System.out.printf("중위 표기법의 수식: ");
		expressionTree.ShowInfixTypeExp(eTree);
		System.out.printf("\n");

		System.out.printf("후위 표기법의 수식: ");
		expressionTree.ShowPostfixTypeExp(eTree);
		System.out.printf("\n");
		
		System.out.printf("연산의 결과: %d \n", expressionTree.EvaluateExpTree(eTree));
	}

}
