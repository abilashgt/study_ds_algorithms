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

More...

Input = [3,0,-2,-1,1,2],

Expected = [[-2,-1,3],[-2,0,2],[-1,0,1]]

*/

import java.util.*;

public class ThreeSumProblem {
    public static void main(String[] args) {
        // int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{3,0,-2,-1,1,2};


        threeSumBruteForce(nums);

        List<List<Integer>> result = threeSum(nums);
        for(List item: result) {
            System.out.println(item.toString());
        }

        findThreeSumUsingHash(nums, 0);

    }

    public static void threeSumBruteForce(int[] nums) {
        System.out.println("Approach 1: Brute Force");

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

        // result
        for(List item: result) {
            System.out.println(item.toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        System.out.println("Approach 2: Not finished - bugs");
        // sort
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + ";");
        }

        // sum result
        Map<String, List<Integer>> sumOut = new HashMap<String, List<Integer>>();

        if(nums.length>=3) {
            int start = 0;
            int start2 = start + 1;
            int end = nums.length-1;
            int end2 = end - 1;

            while(start2<=end2) {
                int sum1 = nums[start] + nums[start2] + nums[end];
                int sum2 = nums[start] + nums[end2] + nums[end];
                int sum3 = nums[start] + nums[start2] + nums[end2];
                int sum4 = nums[start2] + nums[end2] + nums[end];
                System.out.println(start + "=" + start2 + "=" + end2 + "=" + end);
                System.out.println(nums[start] + "=" + nums[start2] + "=" + nums[end2] + "=" + nums[end]);

                if(sum1==0){
                    List<Integer> numList = new LinkedList<Integer>();
                    numList.add(nums[start]);
                    numList.add(nums[start2]);
                    numList.add(nums[end]);
                    System.out.println(numList.toString());
                    sumOut.put(numList.toString(), numList);
                    end--;
                    end2--;
                }
                else if(sum2==0){
                    List<Integer> numList = new LinkedList<Integer>();
                    numList.add(nums[start]);
                    numList.add(nums[end2]);
                    numList.add(nums[end]);
                    System.out.println(numList.toString());
                    sumOut.put(numList.toString(), numList);
                    start++;
                    start2++;
                }
                else if(sum1>0) {
                    end--;
                    end2--;
                }
                else if(sum2<0) {
                    start++;
                    start2++;
                }
                else if(Math.abs(sum1)<Math.abs(sum2)) {
                    end--;
                    end2--;
                }
                else {
                    start++;
                    start2++;
                }

            }

        }

        List<List<Integer>> result = new ArrayList(sumOut.values());
        return result;
    }

    public static void findThreeSumUsingHash(int a[], int T){
        for(int i=0; i<a.length-2; i++) {
            HashSet<Integer> hashA = new HashSet();

            int curr_sum = T-a[i];

            for (int j = i + 1; j < a.length; j++) {
                if(hashA.contains(curr_sum-a[j])){
                    System.out.println(a[i] + " " +a[j] + " " + (curr_sum - a[j]));
                    //break;
                }
                hashA.add(a[j]);
            }
        }
    }
}
