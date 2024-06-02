package com.clrs;


// Geeks for Geeks: https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class Knapsack_0_1 {

	public static void main(String[] args) {
		
		 
		int W=30;
		int[] wt = {1,3,6,10,12,15};
		int[] val = {2,7,9,25,30,35};
		int n = 6;
		/*
		int W = 4;
		int n = 3;
		int[] val = {1,2,3};
		int[] wt = {4,5,1};
		*/
		int maxTotalVal = knapSackNonrecursivePretty(W, wt, val, n);
		System.out.println("Max Total Value = " + maxTotalVal);
	}
	
	static int[] weight;
	static int[] price;
	static int[][] dpMaxVal;
	static int knapSack(int W, int wt[], int val[], int n) {
		weight = wt;
		price = val;
		dpMaxVal = new int[W][n];
		
		return knapSackRecursive(W, 0);
	}
	
	static int knapSackNonrecursivePretty(int W, int wt[], int val[], int n) {
		weight = wt;
		price = val;
		dpMaxVal = new int[W+1][n];
		
		for(int i=1;i<=W;i++) {
			for(int j=n-1;j>=0;j--) {
				
				int currentItemValue = (weight[j] <= i) ? price[j] : 0;
				
				int recursivePreviousItemsValue =((i-weight[j] >= 1) &&  (j<(n-1))) ? 
													dpMaxVal[i-weight[j]][j+1] : 0;
				
				int currentItemNotSelectedOtherItemsValue = (j<(n-1)) ? dpMaxVal[i][j+1] : 0;
				
				dpMaxVal[i][j] = Math.max(currentItemValue + recursivePreviousItemsValue,
											currentItemNotSelectedOtherItemsValue);
				
			}
		}
		return dpMaxVal[W][0];
	}

	
	static int knapSackNonrecursive(int W, int wt[], int val[], int n) {
		weight = wt;
		price = val;
		dpMaxVal = new int[W][n];
		
		for(int i=0;i<W;i++) {
			for(int j=n-1;j>=0;j--) {
				if(j<(n-1)) {
					if((i+1)<weight[j]) {
						dpMaxVal[i][j] = dpMaxVal[i][j+1]; continue;
					} else if((i)-weight[j] < 0){
						dpMaxVal[i][j] = Math.max(dpMaxVal[i][j+1], price[j]);
					} else {
						dpMaxVal[i][j] = Math.max(dpMaxVal[i][j+1],
													price[j] + dpMaxVal[i-weight[j]][j+1]);
					}
					
				} else {
					if((i+1)<weight[j])
						dpMaxVal[i][j] = 0;
					else 
						dpMaxVal[i][j] = val[j];
					continue;
				}
			}
		}
		return dpMaxVal[W-1][0];
	}
	
	static int knapSackRecursive(int cap, int startIndex) {
		
		
		int selectMaxValue;
		int nonSelectMaxValue;
		
		if(cap<=0 || startIndex>=weight.length) {
			return 0;
		}
		
		if(dpMaxVal[cap-1][startIndex] != 0) {
			return dpMaxVal[cap-1][startIndex];
		}
		
		// Calculating selectMaxValue
		if(cap >= weight[startIndex]) {
			selectMaxValue = price[startIndex] + knapSackRecursive(cap - weight[startIndex], startIndex+1);
		} else {
			selectMaxValue = 0;
		}
		
		// Calculating nonSelectmaxValue
		nonSelectMaxValue = knapSackRecursive(cap, startIndex+1);
		
		return Math.max(selectMaxValue, nonSelectMaxValue);
	}
}
