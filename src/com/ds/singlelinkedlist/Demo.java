package com.ds.singlelinkedlist;

public class Demo {
	static String str1 = "ABCDGH" ;
	static String str2 = "AEDFHR" ;
	static int[][] ans = new int[str1.length()][str2.length()] ;
	
	public static void main(String[] args) {
		for(int i=0;i<str1.length();i++) {
			for(int j=0;j<str2.length();j++) {
				ans[i][j] = -1 ;
			}
		}
		System.out.println(maxSubsequence(str1.length()-1, str2.length()-1, 0)) ;
		
	}
	
	public static int maxSubsequence(int index1, int index2, int length) {
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
