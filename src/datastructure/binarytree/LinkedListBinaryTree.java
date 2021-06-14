package datastructure.binarytree;

/**
 * 이진 트리
 * @author Dev History
 *
 * @param <T>
 */
public class LinkedListBinaryTree<T> {
	
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
	
	/**
	 * 이진 트리 노드 생성
	 * @return
	 */
	public BinaryNode MakeBinaryTreeNode() {
		BinaryNode binaryNode = new BinaryNode();
		return binaryNode;
	}
	
	/**
	 * 이진 트리 노드에 저장된 데이터를 반환
	 * @param bn
	 * @return
	 */
	public T GetData(BinaryNode bn) {
		return bn.getData();
	}
	
	/**
	 * 이진 트리 노드에 데이터를 저장
	 * @param bn
	 * @param data
	 */
	public void SetData(BinaryNode bn, T data) {
		bn.setData(data);
	}
	
	/**
	 * 이진 트리 왼쪽 서브 트리의 주소 값 반환
	 * @param bn
	 * @return
	 */
	public BinaryNode GetLeftSubTree(BinaryNode bn) {
		return bn.left; 
	}
	
	/**
	 * 이진 트리 오른쪽 서브 트리의 주소 값 반환
	 * @param bn
	 * @return
	 */
	public BinaryNode GetRightSubTree(BinaryNode bn) {
		return bn.right; 
	}

	/**
	 * 이진 트리 왼쪽 서브 트리 설정
	 * main의 왼쪽의 서브 트리를 sub로 설정
	 * @param main
	 * @param sub
	 * @return
	 */
	public void MakeLeftSubTree(BinaryNode main, BinaryNode sub) {
		main.left = sub; 
	}
	
	/**
	 * 이진 트리 오른쪽 서브 트리 설정
	 * main의 오른쪽의 서브 트리를 sub로 설정
	 * @param main
	 * @param sub
	 * @return
	 */
	public void MakeRightSubTree(BinaryNode main, BinaryNode sub) {
		main.right = sub;
	}
	
	
	/**
	 * 이진 트리의 중위 순회
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
	 * 이진 트리의 중위 순회(방문 목적 사용)
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
	 * 이진 트리의 후위 순회
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
	 * 이진 트리의 전위 순회
	 * @param bn
	 */
	public void PreorderTraverse(BinaryNode bn) {
		if(bn == null) return;	//현재 노드가 자식이 없는 경우 탈출. 즉, 서브 트리가 없고 단순히 노드일 경우

		//일단 서브트리가 존재하는 것으로 가정하고 순회
		System.out.printf("%d \t", bn.data); //루트 노드의 데이터 출력
		PreorderTraverse(bn.left);
		PreorderTraverse(bn.right);
	}
	
	public static void main(String[] args) {
		LinkedListBinaryTree<Integer> binaryTree = new LinkedListBinaryTree<>();
		
		//이진 트리 노드 4개 생성
		LinkedListBinaryTree<Integer>.BinaryNode binaryTreeNode1 = binaryTree.MakeBinaryTreeNode();
		LinkedListBinaryTree<Integer>.BinaryNode binaryTreeNode2 = binaryTree.MakeBinaryTreeNode();
		LinkedListBinaryTree<Integer>.BinaryNode binaryTreeNode3 = binaryTree.MakeBinaryTreeNode();
		LinkedListBinaryTree<Integer>.BinaryNode binaryTreeNode4 = binaryTree.MakeBinaryTreeNode();
		
		//이진트리 노드 데이터 저장
		binaryTree.SetData(binaryTreeNode1, 1);
		binaryTree.SetData(binaryTreeNode2, 2);
		binaryTree.SetData(binaryTreeNode3, 3);
		binaryTree.SetData(binaryTreeNode4, 4);
		
		//서브 트리 설정
		binaryTree.MakeLeftSubTree(binaryTreeNode1, binaryTreeNode2); // 노드2를 노드1의 왼쪽 서브 트리로
		binaryTree.MakeRightSubTree(binaryTreeNode1, binaryTreeNode3); // 노드3를 노드1의 오른쪽 서브 트리로
		binaryTree.MakeLeftSubTree(binaryTreeNode2, binaryTreeNode4); // 노드4를 노드2의 왼쪽 서브 트리로
		
		System.out.println("이진 트리의 서브트리 데이터 조회");
		System.out.printf("%d \t", binaryTree.GetData(binaryTree.GetLeftSubTree(binaryTreeNode1)));
		System.out.printf("%d \t", binaryTree.GetData(binaryTree.GetLeftSubTree(binaryTree.GetLeftSubTree(binaryTreeNode1))));
		System.out.println("\n중위 순회");
		binaryTree.InorderTraverse(binaryTreeNode1);
		System.out.println("\n후위 순회");
		binaryTree.PostorderTraverse(binaryTreeNode1);
		System.out.println("\n전위 순회");
		binaryTree.PreorderTraverse(binaryTreeNode1);
	
		//중위 순회(방문 목적 사용)
		System.out.println("\n중위 순회(방문 목적 사용)");
		binaryTree.InorderTraverse(binaryTreeNode1, 
				(T)-> System.out.printf("[%d] \t", T)
		);
	}
}
