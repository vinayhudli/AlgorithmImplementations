package com.ds.tree;

import com.ds.custom_data_structure.BinaryTree;
import com.ds.custom_data_structure.Node;

public class SymmetricTree {
	
	public BinaryTree<Integer> tree = null ;
	
	public void populateTree() {
		Node<Integer> root = new Node<>() ;
		root.data = 1 ;
		tree = new BinaryTree<>(root) ;
		
		root.left = new Node<>() ;
		root.left.data = 2 ;
		root.right = new Node<>() ;
		root.right.data = 2 ;
		
		root.left.left = new Node<>() ;
		root.left.right = new Node<>() ;
		root.left.right.data = 3 ;
		
		root.right.right = new Node<>() ;
		root.right.right.data = 3 ;
	}
	
	public boolean isMirror(Node<Integer> left, Node<Integer> right) {
		if(left == null && right == null)
			return true ;
		else if(left == null || right == null)
			return false ;
		
		boolean isMirror = (left.data == right.data) && isMirror(left.left, right.right) && isMirror(left.right, right.left) ;
		return isMirror ;
	}
}
