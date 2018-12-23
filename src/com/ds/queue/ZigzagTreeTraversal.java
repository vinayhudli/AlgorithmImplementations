package com.ds.queue;

import java.util.Stack;

import com.ds.custom_data_structure.BinaryTree;
import com.ds.custom_data_structure.Node;

public class ZigzagTreeTraversal {
	
	BinaryTree<Integer> tree = null ;
	
	public void populateBinaryTree() {
		Node<Integer> root = new Node<>() ;
		root.data = 1 ;
		tree = new BinaryTree<>(root) ;
		
		tree.root.left = new Node<>() ;
		tree.root.left.data = 2 ;
		tree.root.right = new Node<>() ;
		tree.root.right.data = 3 ;
		
		tree.root.left.left = new Node<>() ;
		tree.root.left.left.data = 7 ;
		tree.root.left.right = new Node<>() ;
		tree.root.left.right.data = 6 ;
		tree.root.right.left = new Node<>() ;
		tree.root.right.left.data = 5 ;
		tree.root.right.right = new Node<>() ;
		tree.root.right.right.data = 4 ;
	}
	
	public void printTreeZigZag() {
		Stack<Node<Integer>> currentStack = new Stack<>() ;
		currentStack.push(tree.root) ;
		startPrintingFromRoot(currentStack, new Stack<>(), true);
	}
	
	private void startPrintingFromRoot(Stack<Node<Integer>> currentStack, Stack<Node<Integer>> nextStack , boolean isLeftToRight) {
		while(!currentStack.isEmpty()) {
			Node<Integer> currentNode = currentStack.pop() ;
			System.out.println("node is : "+currentNode.data);
			if(isLeftToRight) {
				if(currentNode.right != null)	nextStack.push(currentNode.right) ;
				if(currentNode.left != null) 	nextStack.push(currentNode.left) ;
			}else {
				if(currentNode.left != null)		nextStack.push(currentNode.left) ;
				if(currentNode.right != null)	nextStack.push(currentNode.right) ;
			}
		}
		if(!nextStack.isEmpty())
			startPrintingFromRoot(nextStack, new Stack<>(), !isLeftToRight);
	}
}
