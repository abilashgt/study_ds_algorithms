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

        printOutput2(findThreeSumUsingHash(nums, 0));
        printOutput(threeSumCustom(nums));
    }

    public static void printOutput(List<List<Integer>> result) {
        for(List item: result) {
            System.out.println(item.toString());
        }
    }

    public static void printOutput2(List<Integer[]> result) {
        for(Integer[] item: result) {
            System.out.println(Arrays.stream(item).toList());
        }
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

    public static List<Integer[]> findThreeSumUsingHash(int[] array, int targetSum) {
        System.out.println("Approach 2: Using Hash");
        Map<String, Integer[]> output = new LinkedHashMap<>();

        Set<Integer> sumList = new HashSet<Integer>();

        Arrays.sort(array);

        for(int i=0; i<array.length; i++) {
            sumList.add(array[i]);
            // System.out.print(array[i] + " ");
        }

        // System.out.print("= input\n");
        // System.out.print(targetSum + " = target\n");
        // System.out.println(sumList + " = sumList\n");

        for(int i=0; i<array.length-1; i++) {
            Integer first = array[i];
            for(int j=i+1; j<array.length; j++) {
                Integer second = array[j];
                Integer requiredThird = targetSum - (first + second);

                if(requiredThird!=first && requiredThird!=second && sumList.contains(requiredThird)){
                    Integer[] result = new Integer[]{first, second, requiredThird};
                    Arrays.sort(result);

                    String hash = result[0] + " " + result[1] + " " + result[2];
                    output.put(hash, result);
                    //System.out.println("output = "+hash);
                }
            }
        }

//         System.out.println("Final output:");
//         for(Integer[] test: output.values()){
//           System.out.print(test[0]+" ");
//           System.out.print(test[1]+" ");
//           System.out.println(test[2]+" ");
//         }

        return new ArrayList(output.values());
    }

    public static void findThreeSumUsingHash2(int a[], int T){
        System.out.println("Approach 2: Using Hash : incomplete");
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

    public static List<List<Integer>> threeSumCustom(int[] nums) {
        System.out.println("Approach 3: Not finished - bugs");
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
}
