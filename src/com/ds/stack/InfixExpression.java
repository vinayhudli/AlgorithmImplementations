package com.ds.stack;

import java.util.Stack;

public class InfixExpression {
	
	private String expression ;
	private Stack<Integer> operand = new Stack<>() ;
	private Stack<Character> operator = new Stack<>() ;
	
	public InfixExpression(String exp) {
		expression = exp ;
	}
	
	private int getResult(int op1, int op2, char operator) {
		if(operator == '+')
			return op1+op2 ;
		else if(operator == '-')
			return op1-op2 ;
		else if(operator == '/')
			return op1/op2 ;
		else
			return op1*op2 ;
	}
	
	private boolean isDigit(String element) {
		if(element.compareTo("0")>=0 && element.compareTo("9")<=0)
			return true ;
		return false ;
	}
	
	private int getPrecedence(char token) {
		if(token == '/' || token == '*')
			return 0 ;
		else if(token == '+' || token == '-')
			return 1 ;
		return 2 ;
	}
	
	public int evaluateExpression() {
		for(int i=0;i<expression.length();i++) {
			String element = expression.substring(i, i+1) ;
			
			if(element.equals(" ")) {
				continue ;
			}else if(isDigit(element)) {
				String digits = "" ;
				while(i<expression.length() && isDigit(expression.substring(i, i+1))) {
					digits += expression.substring(i, i+1) ;
					i++ ;
				}
				operand.push(Integer.valueOf(digits)) ;
				i-- ;
			}else if(element.equals("(")) {
				operator.push('(') ;
			}else if(element.equals(")")) {
				while(!operator.peek().equals('(')) {
					int op1 = operand.pop() ;
					int op2 = operand.pop() ;
					char op = operator.pop() ;
					int result = getResult(op2, op1, op) ;
					operand.push(result) ;
				}
				operator.pop() ;
			}else {
				while(!operator.isEmpty() && getPrecedence(operator.peek())<getPrecedence(element.charAt(0))) {
					int op1 = operand.pop() ;
					int op2 = operand.pop() ;
					char op = operator.pop() ;
					int result = getResult(op2, op1, op) ;
					operand.push(result) ;
				}
				operator.push(element.charAt(0)) ;
			}
		}
		while(!operator.isEmpty()) {
			int op1 = operand.pop() ;
			int op2 = operand.pop() ;
			char op = operator.pop() ;
			int result = getResult(op2, op1, op) ;
			operand.push(result) ;
		}
		return operand.pop() ;
	}
}
