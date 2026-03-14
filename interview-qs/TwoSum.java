package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,3,4,8,10,7,15};
		int target = 14;
		
		int[] solution = new TwoSum().twoSum(nums, target);
		
		System.out.println("The indexes of the solution are [" + solution[0] + "," + solution[1] + "]");
	}
	
	// This function returns the indexes of the 2 numbers in the array which satisfy the solution condition.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            int req = target - nums[i];
            if(map.containsKey(req)) {
                result[0] = map.get(req);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
