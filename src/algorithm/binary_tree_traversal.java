package algorithm;

public class binary_tree_traversal {

	//����� ����	
	static int nodeCount = 15;
	
	//��� ����
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
	
	//���� ��ȸ
	public static void preorder(Node node) {
		if(node != null) {
			//�ڽ��� �� ���
			System.out.print(node.getValue()+" ");
			//���� ��� �� ���
			preorder(node.getLeftNode());
			//������ ��� �� ���
			preorder(node.getRightNode());
		}
	}
	//���� ��ȸ
	public static void inorder(Node node) {
		if(node != null) {
			//���� ��� �� ���
			inorder(node.getLeftNode());
			//�ڽ��� �� ���
			System.out.print(node.getValue()+" ");
			//������ ��� �� ���
			inorder(node.getRightNode());
		}
	}
	//���� ��ȸ
	public static void postorder(Node node) {
		if(node != null) {
			//���� ��� �� ���
			postorder(node.getLeftNode());
			//������ ��� �� ���
			postorder(node.getRightNode());
			//�ڽ��� �� ���
			System.out.print(node.getValue()+" ");
		}
	}
	
	public static void main(String[] args) {
		//��� �ʱ�ȭ
		Node[] nodes = new Node[nodeCount+1];

		for (int i = 1; i <= nodeCount; i++) {
			nodes[i] = new Node();
			nodes[i].setValue(i);
			nodes[i].setLeftNode(null);
			nodes[i].setRightNode(null);
		}

		for (int i = 1; i <= nodeCount; i++) {
			//¦���� ����, Ȧ���� ������ ���� ����ǵ��� ����
			if(i != 1) {
				if(i % 2 == 0) {
					nodes[i/2].setLeftNode(nodes[i]);
				}else {
					nodes[i/2].setRightNode(nodes[i]);
				}
			}
		}
		//���� ��ȸ
		preorder(nodes[1]);
		System.out.println();
		//���� ��ȸ
		inorder(nodes[1]);
		System.out.println();
		//���� ��ȸ
		postorder(nodes[1]);
	}

}
