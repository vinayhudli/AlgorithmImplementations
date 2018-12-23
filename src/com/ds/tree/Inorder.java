package com.ds.tree;

import java.util.Stack;

import com.ds.custom_data_structure.BinaryTree;
import com.ds.custom_data_structure.Node ;

/**
 * 
 * @author vinay.deshpande
 *	Inorder tree traversal without recursion
 */
public class Inorder {
	
	BinaryTree<Integer> tree = null ;
	
	public Inorder(Node<Integer> root) {
		tree = new BinaryTree<>(root) ;
	}
	
	public BinaryTree<Integer> getTree(){
		return tree ;
	}
	
	public void traversal() {
		Node<Integer> root = tree.root ;
		if(root == null)
			return ;
		Stack<Node<Integer>> stack = new Stack<>() ;
		Node<Integer> tempNode = root ; 
		while(tempNode != null) {
			stack.push(tempNode) ;
			tempNode = tempNode.left ;
		}
		
		while(!stack.isEmpty()) {
			Node<Integer> currentNode = stack.pop() ;
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
