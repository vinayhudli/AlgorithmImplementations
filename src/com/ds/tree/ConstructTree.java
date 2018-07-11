package com.ds.tree;

import java.util.List;
import java.util.Stack;

public class ConstructTree {
	
	/**
	 * @param inOrder : list of inorder traversal
	 * @param preOrder : list of preorder traversal
	 * @return root node with the hierarchy of tree linked
	 */
	public Node createFromPreOrderAndInOrder(List<Integer> inOrder, List<Integer> preOrder) {
		Node rootNode = new Node(preOrder.get(0)) ;
		
		return rootNode ;
	}
	
	private int getRootNodeIndex(List<Integer> inOrder, int rootData) {
		return -1 ;
	}
}
