package com.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioning {
	
	private Map<String, Integer> minNumberOfParitionsForIndices = new HashMap<>() ;
	
	private String inputString ;
	
	public PalindromePartitioning(String inputStr) {
		inputString = inputStr ;
	}
	public int getMinNumberOfPalindromePartitions(int startIndex, int highIndex, int numbOftimes) {
		if(numbOftimes >= 200)
			return -5;
		if(startIndex == highIndex)
			return 0 ;
		String key = startIndex+"-"+highIndex ;
		if(minNumberOfParitionsForIndices.containsKey(key)) {
			System.out.println("key : "+key+" number of iterations : "+numbOftimes);
			return minNumberOfParitionsForIndices.get(key) ;
		}
		
		if(isPalindrome(startIndex, highIndex)) {
			minNumberOfParitionsForIndices.put(key, 0) ;
			return 0 ;
		}
		int minPartitions = Integer.MAX_VALUE ;
		for(int i= startIndex;i<=highIndex;i++) {
			int currentPalindrome = getMinNumberOfPalindromePartitions(startIndex, i, ++numbOftimes) + 1 +
					getMinNumberOfPalindromePartitions(i+1, highIndex, ++numbOftimes) ;
			minPartitions = minPartitions < currentPalindrome ? minPartitions : currentPalindrome ; 
		}
		System.out.println("start : "+startIndex+" and end : "+highIndex+" and key : "+key+" min partitions : "+minPartitions);
		minNumberOfParitionsForIndices.put(key, minPartitions) ;
		return minPartitions ;
	}
	
	public boolean isPalindrome(int low, int high) {
		for(int i=0;i<=(high+low)/2;i++) {
			String lowInput = inputString.substring(i, i+1) ;
			String highInput = inputString.substring(high-i, high-i+1) ;
			if(lowInput.compareTo(highInput) != 0)
				return false ;
		}
		return true ;
	}
}
