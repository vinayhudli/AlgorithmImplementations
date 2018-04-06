package com.ds.dp;

public class LongestCommonSubsequence {
	int[][] ans ;
	String str1 ;
	String str2 ;
	
	public LongestCommonSubsequence(String str1, String str2) {
		this.str1 = str1 ;
		this.str2 = str2 ;
		ans = new int[str1.length()][str2.length()] ;
	}
	
	public int maxSubsequence(int index1, int index2, int length) {
		if(index1 < 0 || index2 < 0) {
			return length ;
		}
		
		int tempLength = length ;
		if(ans[index1][index2] > -1)
			return ans[index1][index2] ;
		if(str1.substring(index1, index1+1).equalsIgnoreCase(str2.substring(index2, index2+1))) {
			
			tempLength++ ;
			ans[index1][index2] = tempLength ;
			if(index1==0 && index2 == 0)
				System.out.println("ans is updated "+tempLength);
			tempLength = maxSubsequence(index1-1, index2-1, tempLength)   ;
			
			return tempLength ;
		}
		
		
		tempLength = Math.max(maxSubsequence(index1, index2-1, tempLength), maxSubsequence(index1-1, index2, tempLength)) ;
		if(index1 == 0 && index2 == 0)
			System.out.println("ans is updayted outside "+tempLength);
		ans[index1][index2] = tempLength ;
		return tempLength ;
	}
	
}
