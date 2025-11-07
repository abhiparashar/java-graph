package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>>threeSum(int[]nums){
        List<List<Integer>>ans = new ArrayList<>();
        if(nums==null||nums.length<3){
            return ans;
        }
        // Sort the array to use two pointers
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            // EDGE CASE: If first number is positive, no way to get sum = 0
            if(nums[i]>0) break;
            // IMPORTANT: Skip duplicates for first number
            if(i>0 && nums[i]== nums[i-1]) continue;
            // Two pointers for remaining two numbers
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left<right){
                int sum = nums[left] + nums[right];
                if(sum==target){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // IMPORTANT: Skip duplicates for second number
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // IMPORTANT: Skip duplicates for third number
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
                else if (sum < target) {
                    left++;  // Need larger sum
                } else {
                    right--;  // Need smaller sum
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Test 1: Basic case with solution
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1: " + solution.threeSum(nums1));
        // Output: [[-1, -1, 2], [-1, 0, 1]]

        // Test 2: No solution
        int[] nums2 = {0, 1, 1};
        System.out.println("Test 2: " + solution.threeSum(nums2));
        // Output: []

        // Test 3: EDGE CASE - All zeros
        int[] nums3 = {0, 0, 0};
        System.out.println("Test 3: " + solution.threeSum(nums3));
        // Output: [[0, 0, 0]]

        // Test 4: EDGE CASE - All same negative numbers
        int[] nums4 = {-1, -1, -1};
        System.out.println("Test 4: " + solution.threeSum(nums4));
        // Output: []

        // Test 5: EDGE CASE - Many duplicates
        int[] nums5 = {-2, 0, 0, 2, 2};
        System.out.println("Test 5: " + solution.threeSum(nums5));
        // Output: [[-2, 0, 2]]

        // Test 6: EDGE CASE - Minimum length
        int[] nums6 = {0, 0, 0, 0};
        System.out.println("Test 6: " + solution.threeSum(nums6));
        // Output: [[0, 0, 0]]

        // Test 7: EDGE CASE - All positive (no solution)
        int[] nums7 = {1, 2, 3};
        System.out.println("Test 7: " + solution.threeSum(nums7));
        // Output: []

        // Test 8: EDGE CASE - Mix of positives and negatives
        int[] nums8 = {-4, -1, -1, 0, 1, 2};
        System.out.println("Test 8: " + solution.threeSum(nums8));
        // Output: [[-1, -1, 2], [-1, 0, 1]]
    }
}
