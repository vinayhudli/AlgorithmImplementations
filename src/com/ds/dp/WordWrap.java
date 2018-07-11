package com.ds.dp;

public class WordWrap {
	
	public void solve(int[] l, int n, int lineWidth) {
		
		int[][] extraSpaces = new int[n+1][n+1];
		int[][] lineCost = new int[n+1][n+1];
		
		int[] optimalCost = new int[n+1] ;
		int[] solutionToPrint = new int[n+1] ;
		
		for (int i = 1; i <= n; i++){
            extraSpaces[i][i] = lineWidth - l[i-1];
            for (int j = i+1; j <= n; j++)
            		extraSpaces[i][j] = extraSpaces[i][j-1] - l[j-1] - 1;
        }
		
		for (int i = 1; i <= n; i++){
            for (int j = i; j <= n; j++){
                if (extraSpaces[i][j] < 0)
                    lineCost[i][j] = Integer.MAX_VALUE;
                else if (j == n && extraSpaces[i][j] >= 0)
                		lineCost[i][j] = 0;
                else
                		lineCost[i][j] = extraSpaces[i][j]*extraSpaces[i][j];
            }
        }
		
		optimalCost[0] = 0;
        for (int j = 1; j <= n; j++){
        		optimalCost[j] = Integer.MAX_VALUE;
            for (int i = 1; i <= j; i++){
                if (optimalCost[i-1] != Integer.MAX_VALUE && lineCost[i][j] != Integer.MAX_VALUE &&  
                		(optimalCost[i-1] + lineCost[i][j] < optimalCost[j])){
                	
                    optimalCost[j] = optimalCost[i-1] + lineCost[i][j];
                    solutionToPrint[j] = i;
                }
            }
        }
        
        for(int i=0;i<optimalCost.length;i++) {
        		System.out.println("index : "+i+" optimal cost : "+optimalCost[i]);
        }
        printSolution(solutionToPrint, n) ;
	}
	
	int printSolution (int p[], int n){
        int k;
        if (p[n] == 1)
        k = 1;
        else
        k = printSolution (p, p[n]-1) + 1;
        System.out.println("Line number" + " " + k + ": " + 
                    "From word no." +" "+ p[n] + " " + "to" + " " + n);
        return k;
    }
}
