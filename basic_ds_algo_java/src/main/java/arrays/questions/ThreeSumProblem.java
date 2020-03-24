package arrays.questions;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.*;

public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = threeSum(nums);

        for(List item: result) {
            System.out.println(item.toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, String> sums = new HashMap<Integer, String>();

        Map<String, List<Integer>> sumOut = new HashMap<String, List<Integer>>();

        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    // System.out.println("sum="+sum);

                    if(sum==0){
                        List<Integer> numList = new LinkedList<Integer>();
                        numList.add(nums[i]);
                        numList.add(nums[j]);
                        numList.add(nums[k]);
                        // System.out.println(numList.toString());
                        Collections.sort(numList);
                        sumOut.put(numList.toString(), numList);
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList(sumOut.values());
        return result;
    }
}
