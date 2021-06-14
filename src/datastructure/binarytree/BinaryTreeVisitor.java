package datastructure.binarytree;

/**
 * 노드의 방문 목적을 표현하기 위한 인터페이스
 * @author Dev History
 *
 * @param <T>
 */
public interface BinaryTreeVisitor<T> {
	void action(T data);
}
