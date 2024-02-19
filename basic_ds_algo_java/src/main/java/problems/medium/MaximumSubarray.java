package problems.medium;

/**
 * Hello world!
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = -100000;

        for (Integer curPos = 0; curPos<nums.length; curPos++) {
            int curSum = maxSubArray(nums, curPos);

            if(curSum>maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

    public int maxSubArray(int[] nums, Integer curPos) {
        int numsLength = nums.length;
        int maxSum = -100000;
        int curSum = 0;
        for(int i = curPos; i<numsLength; i++){
            int num = nums[i];
            curSum = curSum+num;
            if(curSum>maxSum) {
                maxSum = curSum;
            }
            else if (num<=0){
                curPos = i;
            }
        }

        Tuple tuple = new Tuple();
        tuple.sum = maxSum;
        tuple.pos = curPos;

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Tuple {
    int sum;
    int pos;
}
