package com.ds.tree;

import java.util.Stack;

public class PostOrder {
	
	/*
	 * postorder tree traversal using 2 stacks
	 */
	public void printUsingTwoStacks(Node node) {
		if(!isTreeValid(node))
			return ;
		
		Stack<Node> intermittant = new Stack<>() ;
		Stack<Node> result = new Stack<>() ;
		
		intermittant.push(node) ;
		
		while(!intermittant.isEmpty()) {
			Node tempNode = intermittant.pop() ;
			result.push(tempNode) ;
			if(tempNode.left != null) intermittant.push(tempNode.left) ;
			if(tempNode.right != null) intermittant.push(tempNode.right) ;
		}
		
		while(!result.isEmpty()) {
			System.out.println(result.pop().data);
		}
	}
	
	public void printUsingOneStack(Node node) {
		if(!isTreeValid(node))
			return ;
		
		Stack<Node> stack = new Stack<>() ;
		Node previous = null ;
		Node current =  node.left ;
		if(node.right != null)
			stack.push(node.right) ;
		stack.push(node) ;
		while(!stack.isEmpty()) {
			if(current != null) {
				if(current.right != null)
					stack.push(current.right) ;
				stack.push(current) ;
				current = current.left ;
			}else {
				previous = stack.pop() ;
				if(!stack.isEmpty() && previous.right == stack.peek()) {
					current = stack.pop() ;
					stack.push(previous) ;
				}else {
					System.out.println(previous.data);
				}
			}
		}
	}
	
	private boolean isTreeValid(Node node) {
		return node != null ;
	}
}
