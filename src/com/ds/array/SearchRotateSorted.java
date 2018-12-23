package com.ds.array;

public class SearchRotateSorted {
	
	public int searchElement(int[] arr, int element, int low, int high) {
		if(low>high)
			return -1 ;
		int mid = (low+high)/2 ;
		if(arr[mid] == element) {
			return mid ;
		}
		if(arr[low] < arr[mid]) {
			if(element > arr[low])
				return searchElement(arr, element, low, mid-1) ;
			else
				return searchElement(arr, element, mid+1, high) ;
		}else{
			if(element < arr[high])
				return searchElement(arr, element, mid+1, high) ;
			else
				return searchElement(arr, element, low, mid-1) ;
		}
		
		
	}
	
}
