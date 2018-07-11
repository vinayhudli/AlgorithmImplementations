package com.ds.dp;

public class PainterPartition {
	
	int[] boardLength  ;
	int numberOfPainters ;
	int[][] timeRequired ;
	int[] currentIterationTime ;
	int minimun = Integer.MAX_VALUE ;
	
	public PainterPartition(int[] boardLength, int numberOfPainters) {
		this.boardLength = boardLength ;
		this.numberOfPainters = numberOfPainters ;
		timeRequired = new int[numberOfPainters][boardLength.length] ;
		currentIterationTime = new int[numberOfPainters] ;
		constructTimeRequiredMatrix();
	}
	
	private void constructTimeRequiredMatrix() {
		int previousSum = 0 ;
		for(int i=0;i<numberOfPainters;i++) {
			for(int j=i;j<boardLength.length;j++) {
				timeRequired[i][j] = previousSum + boardLength[j] ;
				System.out.print(timeRequired[i][j]+" ");
				previousSum = timeRequired[i][j] ;
			}
			System.out.println();
			previousSum = 0 ;
		}
	}
	
	public int getMinimumTimeForJob(int painter, int startOfBoard) {
		if(painter > numberOfPainters)
			return 0 ;
		int paintersRemaining = numberOfPainters - painter ;
		int currentBoard = startOfBoard ;
		
		while(currentBoard<(boardLength.length-paintersRemaining)) {
			int diff = startOfBoard > painter-1 ? timeRequired[painter-1][startOfBoard-1] : 0 ;
			currentIterationTime[painter-1] = timeRequired[painter-1][currentBoard] - diff ;
			System.out.println("for painter : "+painter+" current board : "+currentBoard+" diff "+diff+" current iteration : "+currentIterationTime[painter-1]);
			currentBoard++ ;
			getMinimumTimeForJob(painter + 1, currentBoard) ;
		}
		int max = getMaxTime() ;
		System.out.println("max : "+max+" minimum : "+minimun);
		minimun = minimun < max ? minimun : max ; 
		return  minimun ;
	}
	
	private int getMaxTime() {
		int max = -1 ;
		for(int i=0;i<currentIterationTime.length;i++) {
			if(max<currentIterationTime[i])
				max = currentIterationTime[i] ;
		}
		return max ;
	}
}
