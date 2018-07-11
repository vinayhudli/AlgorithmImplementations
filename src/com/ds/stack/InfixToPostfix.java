package com.ds.stack;

import java.util.Stack;

public class InfixToPostfix {
	
	private boolean isDigit(String element) {
		if(element.compareTo("0")>=0 && element.compareTo("9")<=0)
			return true ;
		return false ;
	}
	
	private int getPrecedence(String element) {
		if(element.equals("^"))
			return 0 ;
		else if(element.equals("/") || element.equals("*"))
			return 1 ;
		else if(element.equals("+") || element.equals("-"))
			return 2 ;
		return 3 ;
	}
	
	public String getExpression(String expression) {
		Stack<String> operator = new Stack<>() ;
		StringBuilder str = new StringBuilder() ;
		for(int i=0;i<expression.length();i++) {
			String element = expression.substring(i, i+1) ;
			System.out.println("element is : "+element);
			if(isDigit(element))
				str.append(element) ;
			else if(element.equals("("))
				operator.push(element);
			else if(element.equals(")")){
				while(!operator.peek().equals("(")) {
					str.append(operator.pop()) ;
				}
				operator.pop() ;
			}else {
				while(!operator.isEmpty() && getPrecedence(operator.peek())<getPrecedence(element)) {
					str.append(operator.pop()) ;
				}
				operator.push(element) ;
			}
		}
		
		while(!operator.isEmpty()) {
			str.append(operator.pop()) ;
		}
		return str.toString() ;
	}
}
