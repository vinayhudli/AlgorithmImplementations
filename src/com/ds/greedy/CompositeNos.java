package com.ds.greedy;

public class CompositeNos {
	
	public int getMaxNumberOfCompositeSum(int num) {
		if(num < 4)
			return 0 ;
		
		if(num == 5 || num == 7 || num == 11) {
			return 0 ;
		}
		
		int maxNumOfCompositeSum = num/4 ;
		int rem = num % 4 ;
		
		if(rem == 1 || rem == 3 ) {
			maxNumOfCompositeSum -= 1 ;
		}
		
		return maxNumOfCompositeSum ;
	}
}
