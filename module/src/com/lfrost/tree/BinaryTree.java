package com.lfrost.tree;

public class BinaryTree {
	Node2 root = new Node2(0);
	public BinaryTree() {
		int i = 1;
		root.left = new Node2(i++);
		root.right = new Node2(i++);

		root.left.left = new Node2(i++);
		root.left.right = new Node2(i++);

		root.right.left = new Node2(i++);
		root.right.right = new Node2(i++);
	}
	
	public int visit(Node2 node, int a, int b) {
		if( node == null )
			return 0;
		
		int found = 0;
		found += visit(node.left, a, b);
		found += visit(node.right, a, b);
		if(found >= 2) {
			System.out.println(node.val);
			return 0;
		}
		found += (node.val == a || node.val == b) ? 1 : 0;
		
		return found;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.visit(bt.root, 3, 1);
		bt.visit(bt.root, 3, 5);
		bt.visit(bt.root, 3, 4);
		bt.visit(bt.root, 0, 1);
	}
}

class Node2 {
	Node2(int val) {
		this.val = val;
	}

	Node2 left;
	Node2 right;
	int val;
}