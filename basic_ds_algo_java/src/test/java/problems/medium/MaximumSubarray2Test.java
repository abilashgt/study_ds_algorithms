package problems.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarray2Test {

    MaximumSubarray2 maxiumSubarray;

    @BeforeEach
    void init() {
        maxiumSubarray = new MaximumSubarray2();
    }

    @Test
    void maxSubArray() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxiumSubarray.maxSubArray(nums);
        System.out.printf("result = " + result);

        assertEquals(result, 6);
    }


    @Test
    void limitExceeded() {
        File file = new File("MaxSubArray.txt");

    }
}