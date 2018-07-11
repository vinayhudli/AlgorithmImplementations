package com.ds.runner;

import com.ds.stack.InfixExpression;

public class Demo {
	
	public static void main(String[] args) {
		InfixExpression infixExpression = new InfixExpression("100 * ( 2 + 12 ) / 14") ;
		System.out.println(infixExpression.evaluateExpression());
	}
}
