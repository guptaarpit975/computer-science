package com.leetcode.dpandgreedyalgos;

//Leetcode - https://leetcode.com/problems/partition-equal-subset-sum/
public class EqualValueSubsets {

    public static void main(String[] args) {
        int[] nums = {1,3,20,5,17,4};
        boolean checkEqual = new EqualValueSubsets().canPartition(nums);
        System.out.println("Is Possible = " + checkEqual);
    }

    boolean[][] dpSum ;

    public boolean isTargetSumAchievedRecursive(int remainingSum , int idx, int n,int[] nums){
        if(remainingSum == 0) {
            //dpSum[remainingSum]
            return true;
        }

        if(remainingSum < 0) return false;

        if(idx> (n-1)) return false;

        boolean x = isTargetSumAchievedRecursive(remainingSum - nums[idx], idx+1, n, nums);
        boolean y = isTargetSumAchievedRecursive(remainingSum, idx+1, n, nums);
        dpSum[remainingSum][idx] = x||y;
        return x||y;
    }

    public boolean isTargetSumAchievedNonRecursive(int targetSum , int idx, int n,int[] nums){

        for(int i=1;i<=targetSum;i++) {
            for(int j=(n-1); j>=0; j--) {
                if(nums[j] == i) {
                    dpSum[i][j] = true; continue;
                }

                if(i-nums[j] > 0) {
                    dpSum[i][j] = dpSum[i-nums[j]][j+1] || dpSum[i][j+1];
                 } else {
                    dpSum[i][j] = dpSum[i][j+1];
                }
            }
        }

        return dpSum[targetSum][0];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) {
            sum+=x;
        }
        int requiredSum = sum/2;
        if (sum%2 == 1) return false;


        dpSum = new boolean[requiredSum+1][n+1];
        return isTargetSumAchievedNonRecursive(requiredSum, 0, nums.length, nums);
    }
}
