package com.ps.ds.hash;

public class LargestSubArr {
	
	public int getMaxSubArrLength(int[] arr) {
		int numOfOnes = 0 ;
		int numOfZeros = 0 ;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 0)
				numOfZeros++ ;
			else
				numOfOnes++ ;
		}
		
		if(numOfOnes == numOfZeros)
			return arr.length ;
		
		int low = 0 ;
		int high = arr.length-1 ;
		int key = numOfOnes > numOfZeros ? 1 : 0 ;
		while(numOfOnes != numOfZeros && low != high) {
			if(arr[low] == key)
				low++ ;
			else
				high-- ;
			
			if(key == 1)
				numOfOnes-- ;
			else
				numOfZeros-- ;
			
			if(numOfOnes == numOfZeros)
				return high-low+1 ;
		}
		return 0 ;
	}
}
