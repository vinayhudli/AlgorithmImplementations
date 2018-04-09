package com.ds.tree;

import java.util.Stack;

/**
 * 
 * @author vinay.deshpande
 *	Inorder tree traversal without recursion
 */
public class Inorder {
	
	Node root ;
	
	public Inorder(Node root) {
		this.root = root ;
	}
	
	public void traversal() {
		if(root == null)
			return ;
		Stack<Node> stack = new Stack<>() ;
		Node tempNode = root ; 
		while(tempNode != null) {
			stack.push(tempNode) ;
			tempNode = tempNode.left ;
		}
		
		while(!stack.isEmpty()) {
			Node currentNode = stack.pop() ;
			System.out.println(currentNode.data);
			if(currentNode.right != null) {
				tempNode = currentNode.right ;
				while(tempNode != null) {
					stack.push(tempNode) ;
					tempNode = tempNode.left ;
				}
			}
		}
	}
}
