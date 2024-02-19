package problems.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

    MaximumSubarray maxiumSubarray;

    @BeforeEach
    void init() {
        maxiumSubarray = new MaximumSubarray();
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