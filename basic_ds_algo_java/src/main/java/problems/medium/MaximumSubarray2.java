package problems.medium;

/**
 * Hello world!
 */
public class MaximumSubarray2 {

    public int maxSubArray(int[] nums) {
        int maxSum = -100000;

        int curSum = 0;
        for (int curPos = 0; curPos<nums.length; curPos++) {
            int curNum = nums[curPos];

            if(curSum>maxSum) {
                maxSum = curSum;
            }

            curSum += curNum;
            if(curNum<0 && curSum<=0) {
                curSum = 0;
            }
        }

        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
