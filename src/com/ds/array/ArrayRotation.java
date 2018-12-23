package com.ds.array;

public class ArrayRotation {
	
	public int[] rotateUsingTempArray(int[] arr, int numberOfPlaces) {
		if(numberOfPlaces <= 0)
			return arr ;
		int[] tempArr = new int[numberOfPlaces] ;
		for(int i=0;i<arr.length;i++) {
			tempArr[i] = arr[i] ;
		}
		
		for(int i=numberOfPlaces;i<arr.length;i++) {
			arr[i-numberOfPlaces] = arr[i] ;
		}
		
		int counter = 0 ;
		for(int i=arr.length-numberOfPlaces;i<arr.length;i++) {
			arr[i] = tempArr[counter] ;
			counter++ ;
		}
		return arr ;
	}
	
	public int[] rotateUsingJuggling(int[] arr, int numberOfPlaces) {
		for(int i=0;i<gcd(arr.length, numberOfPlaces);i++) {
			int temp = arr[i] ;
			int j = i ;
			int k = -1 ;
			while(true) {
				k = j+numberOfPlaces ;
				if(k >= arr.length)
					k = k - arr.length ;
				if(k == i)
					break ;
				
				arr[j] = arr[k] ;
				j = k ;
			}
			arr[j] = temp ;
		}
		return arr ;
	}
	
	public int[] rotateByReversing(int[] arr, int numberOfPlaces) {
		arr = reverse(arr, 0, numberOfPlaces-1) ;
		arr = reverse(arr, numberOfPlaces, arr.length-1) ;
		arr = reverse(arr, 0, arr.length-1) ;
		return arr ;
	}
	
	public int[] reverse(int[] arr, int start, int end) {
		int temp = 0 ;
		while(start < end) {
			temp = arr[start] ;
			arr[start] = arr[end] ;
			arr[end] = temp ;
			start++ ;
			end++ ;
		}
		return arr ;
	}
	
	private int gcd(int a, int b) {
		if(b == 0)
			return a ;
		return gcd(b, a%b) ;
	}
	
}
