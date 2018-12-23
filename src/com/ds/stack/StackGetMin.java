package com.ds.stack;

import java.util.Stack;

public class StackGetMin<T extends Comparable<T>> {
	
	Stack<T> allElements = new Stack<>() ;
	Stack<T> minElementsStack = new Stack<>() ;
	
	public void push(T element) {
		allElements.push(element) ;
		if(minElementsStack.isEmpty()) {
			minElementsStack.push(element) ;
			return ;
		}
		T currentMin = minElementsStack.pop() ;
		minElementsStack.push(currentMin) ;
		if(currentMin.compareTo(element)> 0)
			minElementsStack.push(element) ;
	}
	
	public T pop() {
		return allElements.pop() ;
	}
	
	public T getMinimum() {
		T element = minElementsStack.pop() ;
		minElementsStack.push(element) ;
		return element ;
	}
}
