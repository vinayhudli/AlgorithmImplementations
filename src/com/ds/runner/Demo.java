package com.ds.runner;

import com.ds.tree.Inorder;
import com.ds.tree.Node;

public class Demo {
	
	public static void main(String[] args) {
		Node root = new Node(1) ;
		Inorder inOrder = new Inorder(root) ;
		
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		root.getLeft().setLeft(new Node(4));
		root.getLeft().setRight(new Node(5));
//		root.getRight().setLeft(new Node(6));
//		root.getRight().getLeft().setRight(new Node(7));
		
		inOrder.traversal();
	}
	
}
