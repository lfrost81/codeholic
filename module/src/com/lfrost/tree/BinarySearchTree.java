package com.lfrost.tree;

public class BinarySearchTree {
	Node root = null;

	void insert(int n) {
		if( root == null ) {
			root = new Node(n);
			return;
		}

		Node node = new Node(n);
		Node found = traverse(n, root);
		if( n < found.val ) {
			found.left = node;
		}
		else if( n > found.val ) {
			found.right = node;
		}
	}
	
	boolean search(int n) {
		if( root == null )
			return false;
		
		Node found = traverse(n, root);
		if( found.val == n )
			return true;
		return false;
	}
	
	Node traverse(int n, Node node) {
		if( n == node.val )
			return node;
		else if( n < node.val ) {
			if( node.left == null )
				return node;
			node = node.left;
		}
		else {
			if( node.right == null )
				return node;
			node = node.right;
		}
		
		return traverse(n, node);
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(7);
		bst.insert(17);
		
		System.out.println(bst);
	}
}

class Node {
	int val;
	Node left;
	Node right;
	
	public Node( int n ) {
		this.val = n;
	}
	
	@Override
	public String toString() {
		return String.format("%d", val);
	}
}
