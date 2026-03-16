package dsa_dec_2025.misc;

import java.util.*;

// Problem Statement - Given an array of Integers.
// Find all unique triplets which have sum = 0.
public class ThreeSum {

    public static void main(String[] args) {
        int[] numbers = {-2,-3 , 0, 1, 0, -1 , 4, 2, 5};

        List<List<Integer>> solution = new ThreeSum().threeSum(numbers);
        for(List<Integer> solList : solution) {
            System.out.println(solList);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // For reducing memory footprint
        boolean[] numbers = new boolean[nums.length];
        for(int i = 0; i<nums.length; i++) {
            numbers[i] = true;
        }

        // Define an ArrayList
        List<List<Integer>> solution = new ArrayList<>();
        for(int i=0; i<=(nums.length-3); i++) {
            if(!numbers[i]) continue;
            int target = -(nums[i]);
            Set<Integer> temp = new HashSet<Integer>();

            for(int j=i+1; j<nums.length ; j++) {

                if(nums[j] == nums[i]) {
                    numbers[j] = false;
                }

                int req = target - nums[j];
                if(temp.contains(req)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(req);
                    Collections.sort(list);
                    solution.add(list);
                }
                temp.add(nums[j]);
            }
            temp = null;


        }
        Set<List<Integer>> listSet = new HashSet<>(solution);
        solution.clear();
        return new ArrayList<>(listSet);
        //return solution;
    }
}
