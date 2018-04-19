package com.ds.tree;

import java.util.Stack;

/**
 * 
 * @author vinay.deshpande
 * Preorder without recursion
 */
public class PreOrder {
	
	public void traversal(Node node) {
		if(node == null )
			return ;
		
		Stack<Node> stack = new Stack<>() ;
		stack.push(node) ;
		
		while(!stack.isEmpty()) {
			Node tempNode = stack.pop() ;
			System.out.println(tempNode.data);
			
			if(tempNode.right != null) {
				stack.push(tempNode.right) ;
			}
			
			if(tempNode.left != null)
				stack.push(tempNode.left) ;
		}
	}
}
