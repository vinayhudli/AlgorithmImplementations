package com.ds.tree;

public class LevelOrder {
	
	class Node{
		int data ;
		Node left ;
		Node right ;
	}
	
	Node root ;
	
	public LevelOrder(Node root) {
		this.root = root ;
	}
	
	/**
	 * This method prints level order traversal without extra space
	 */
	
	public void printLevelOrder() {
		
	}
	
	public int height(Node parent) {
		if(root == null || parent == null)
			return 0 ;
		
		int lHeight = height(parent.left) + 1 ;
		int rHeight = height(parent.right) + 1 ;
		
		return Math.max(lHeight, rHeight) ;
	}
	
	public void printGivenLevel(Node parent, int level) {
		if(level == 0 || parent == null)
			return ;
		if(level == 1)
			System.out.println(parent.data);
		else {
			printGivenLevel(parent.left, level-1);
			printGivenLevel(parent.right, level-1);
		}
	}
}
