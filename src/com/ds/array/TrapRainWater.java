package com.ds.array;

public class TrapRainWater {
	
	int[] container ;
	
	public TrapRainWater(int[] arr) {
		container = arr ;
	}
	
	public int findWater() {
		int numOfNonZeros = 1 ;
		int water = 0 ;
		while(numOfNonZeros > 0) {
			int lastNonZeroIndex = -1 ;
			if(container[0] != 0) {
				numOfNonZeros = 1 ;
				lastNonZeroIndex = 0 ;
			}
			else
				numOfNonZeros = 0 ;
			
			for(int i=1;i<container.length;i++) {
				if(container[i] > 0) {
					numOfNonZeros++ ;
				if(lastNonZeroIndex >= 0) {
					if(container[lastNonZeroIndex] > container[i]) {
						System.out.println("in if : i "+i+" lastNonZeroIndex : "+lastNonZeroIndex+" container : "+container[i]);
						water += container[i]*(i-lastNonZeroIndex-1) ;
						container[lastNonZeroIndex] -= container[i] ;
					}else {
						System.out.println("in else : i "+i+" lastNonZeroIndex : "+lastNonZeroIndex+" container : "+container[lastNonZeroIndex]);
						water += container[lastNonZeroIndex]*(i-lastNonZeroIndex-1) ; 
						container[lastNonZeroIndex] = 0 ;
					}
				}
				lastNonZeroIndex = i ;
				}
			}
			if(numOfNonZeros == 1)
				numOfNonZeros = 0 ;
		}
		return water ;
	}
}
