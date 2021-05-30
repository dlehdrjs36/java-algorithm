package algorithm;

public class binary_tree_traversal {

	//노드의 갯수	
	static int nodeCount = 15;
	
	//노드 형태
	static class Node {
		private int value;
		private Node leftNode;
		private Node rightNode;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		
	}
	
	//전위 순회
	public static void preorder(Node node) {
		if(node != null) {
			//자신의 값 출력
			System.out.print(node.getValue()+" ");
			//왼쪽 노드 값 출력
			preorder(node.getLeftNode());
			//오른쪽 노드 값 출력
			preorder(node.getRightNode());
		}
	}
	//중위 순회
	public static void inorder(Node node) {
		if(node != null) {
			//왼쪽 노드 값 출력
			inorder(node.getLeftNode());
			//자신의 값 출력
			System.out.print(node.getValue()+" ");
			//오른쪽 노드 값 출력
			inorder(node.getRightNode());
		}
	}
	//후위 순회
	public static void postorder(Node node) {
		if(node != null) {
			//왼쪽 노드 값 출력
			postorder(node.getLeftNode());
			//오른쪽 노드 값 출력
			postorder(node.getRightNode());
			//자신의 값 출력
			System.out.print(node.getValue()+" ");
		}
	}
	
	public static void main(String[] args) {
		//노드 초기화
		Node[] nodes = new Node[nodeCount+1];

		for (int i = 1; i <= nodeCount; i++) {
			nodes[i] = new Node();
			nodes[i].setValue(i);
			nodes[i].setLeftNode(null);
			nodes[i].setRightNode(null);
		}

		for (int i = 1; i <= nodeCount; i++) {
			//짝수는 왼쪽, 홀수는 오른쪽 노드로 연결되도록 설정
			if(i != 1) {
				if(i % 2 == 0) {
					nodes[i/2].setLeftNode(nodes[i]);
				}else {
					nodes[i/2].setRightNode(nodes[i]);
				}
			}
		}
		//전위 순회
		preorder(nodes[1]);
		System.out.println();
		//중위 순회
		inorder(nodes[1]);
		System.out.println();
		//후위 순회
		postorder(nodes[1]);
	}

}
