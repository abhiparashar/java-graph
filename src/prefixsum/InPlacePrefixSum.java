package prefixsum;

import java.util.Arrays;

public class InPlacePrefixSum {
    public void inPlacePrefixSum(int[]nums){
        for (int i = 1; i < nums.length ; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
    }

    public static void main(String[] args) {
        InPlacePrefixSum ps = new InPlacePrefixSum();

        // Test Case 1
        int[] nums1 = {3, 1, 4, 2, 5};
        ps.inPlacePrefixSum(nums1);
        System.out.println("Test 1 Output: " + Arrays.toString(nums1));
        // Expected: [3, 4, 8, 10, 15]

        // Test Case 2
        int[] nums2 = {5, -2, 7, 3};
        ps.inPlacePrefixSum(nums2);
        System.out.println("Test 2 Output: " + Arrays.toString(nums2));
        // Expected: [5, 3, 10, 13]
    }
}
