package com.ds.runner;

import com.ds.stack.InfixToPostfix;

public class Demo {
	
	public static void main(String[] args) {
		InfixToPostfix inToPost = new InfixToPostfix() ;
		System.out.println("expression : "+inToPost.getExpression("1+1*(1^1-1)^(1+1*1)-1")) ;
	}
}
