import java.util.ArrayList;

public class BST<T extends Comparable<T>>{

	static class BSTNode<T extends Comparable<T>>{
		private T data;
		private BSTNode<T> left;
		private BSTNode<T> right;

		public BSTNode(T d){
			data = d;
			right = null;
			left = null;
		}
	}

	private BSTNode<T> root;
	//private BSTNode<T> smallest;

	public BST(){
		root = null;
		smallest = null;
	}

	public boolean find(T item){
		return find(root, item);
	}

	private boolean find(BSTNode<T> node, T key){
		if(node == null)
			return false;
		if(key.compareTo(node.data) == 0)
			return true;
		else if(key.compareTo(node.data) < 0)
			return find(node.left, key);
		else
			return find(node.right, key);
	}

	public void insert(T item){
		root = insert(root, item);
	}

	private BSTNode insert(BSTNode<T> node, T key){
		if(node == null)
			return new BSTNode(key);
		if(key.compareTo(node.data) < 0)
			node.left = insert(node.left, key);
		else
			node.right = insert(node.right, key);
		return node;
	}

	public void print(){
		print(root);
	}

	private void print(BSTNode<T> node){
		if(node != null){
			print(node.left);
			System.out.print(node.data);
			print(node.right);
		}
	}

	public void delete(T item){
		root = delete(root, item);
	}

	private BSTNode delete(BSTNode<T> node, T key){
		if(node == null)
			return null;
		if(node.data.compareTo(key) < 0){
			node.right = delete(node.right, key);
			return node;
		}
		else if (node.data.compareTo(key) > 0){
			node.left = delete(node.left, key);
			return node;
		}
		else{
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			else{
				if(node.right.left == null){
					node.data = node.right.data;
					node.right = node.right.right;
				}
				// else{
				// 	node.data = removeSmallest(node.right);
				// }
				return node;
			}
		}
	}

	// public BSTNode removeSmallest(BSTNode<T> node){
	// 	if(node.left.left == null){
	// 		smallest = node.left.data;
	// 		node.left = node.left.right;
	// 		return smallest;
	// 	}
	// 	else{
	// 		return removeSmallest(node.left);
	// 	} 
	// }
}