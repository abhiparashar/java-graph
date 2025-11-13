package prefixsum;

import java.util.Arrays;

public class RunningSum {
    public int[] runningSum(int[]nums){
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i]+ nums[i-1];
        }
        return nums;
    }
    public static void main(String[] args) {
        RunningSum rs = new RunningSum();
        int[]nums1 = { 1, 2, 3, 4};
        rs.runningSum(nums1);
        System.out.println("Test 1 Output: " + Arrays.toString(nums1));
//        Output: [1, 3, 6, 10]
        int[]nums2 = { 1, 1, 1, 1, 1};
        rs.runningSum(nums2);
        System.out.println("Test 2 Output: " + Arrays.toString(nums2));
//        Output: [1, 2, 3, 4, 5]
        int[]nums3 = {3, 1, 2, 10, 1};
        rs.runningSum(nums3);
        System.out.println("Test 3 Output: " + Arrays.toString(nums3));
//        Output: [3, 4, 6, 16, 17]
        int[]nums4 = {5};
        rs.runningSum(nums4);
        System.out.println("Test 4 Output: " + Arrays.toString(nums4));
//        Output: [5]
        int[]nums5 = { 10, -5, 3};
        rs.runningSum(nums5);
        System.out.println("Test 5 Output: " + Arrays.toString(nums5));
//        Output: [10, 5, 8]
    }
}
