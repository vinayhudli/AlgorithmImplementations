package com.ds.tree;

public class LevelOrder {
	
	Node root ;
	
	public LevelOrder(Node root) {
		this.root = root ;
	}
	
	/**
	 * This method prints level order traversal without extra space but time complexity O(n^2)
	 */
	public void printLevelOrder() {
		int height = height(root) ;
		for(int i=1;i<=height;i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
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
			System.out.print(parent.data+"	");
		else {
			printGivenLevel(parent.left, level-1);
			printGivenLevel(parent.right, level-1);
		}
	}
}
