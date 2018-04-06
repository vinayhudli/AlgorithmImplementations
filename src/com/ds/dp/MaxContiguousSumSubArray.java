package com.ds.dp;

public class MaxContiguousSumSubArray {
	
	int[] arr ;
	
	public MaxContiguousSumSubArray(int[] arr) {
		this.arr = arr ;
	}
	
	public int maxContiguousSum() {
		if(arr == null || arr.length==0)
			return 0 ;
		int maxSum = arr[0] ;
		int sum = arr[0] ;
		
		for(int i=1;i<arr.length;i++) {
			sum = Math.max(arr[i], arr[i]+sum) ;
			maxSum = Math.max(sum, maxSum) ;
		}
		return maxSum ;
	}
}
