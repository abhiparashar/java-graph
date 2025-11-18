package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[]nums, int target){
        HashMap<Integer, Integer>map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           if(map.containsKey(target-nums[i])){
               return new int[]{map.get(target-nums[i]),i};
           }
           map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test Case 1: Basic case from problem
        System.out.println("Test Case 1:");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Expected: [0, 1]");
        System.out.println("Pass: " + Arrays.equals(result1, new int[]{0, 1}));
        System.out.println();

        // Test Case 2: Solution not at beginning
        System.out.println("Test Case 2:");
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Expected: [1, 2]");
        System.out.println("Pass: " + Arrays.equals(result2, new int[]{1, 2}));
        System.out.println();

        // Test Case 3: Same number used twice (but different indices)
        System.out.println("Test Case 3:");
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3));
        System.out.println("Expected: [0, 1]");
        System.out.println("Pass: " + Arrays.equals(result3, new int[]{0, 1}));
        System.out.println();

        // Test Case 4: Negative numbers
        System.out.println("Test Case 4:");
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(result4));
        System.out.println("Expected: [2, 4]");
        System.out.println("Pass: " + Arrays.equals(result4, new int[]{2, 4}));
        System.out.println();

        // Test Case 5: Zero in array
        System.out.println("Test Case 5:");
        int[] nums5 = {0, 4, 3, 0};
        int target5 = 0;
        int[] result5 = solution.twoSum(nums5, target5);
        System.out.println("Input: nums = " + Arrays.toString(nums5) + ", target = " + target5);
        System.out.println("Output: " + Arrays.toString(result5));
        System.out.println("Expected: [0, 3]");
        System.out.println("Pass: " + Arrays.equals(result5, new int[]{0, 3}));
        System.out.println();

        // Test Case 6: Large numbers
        System.out.println("Test Case 6:");
        int[] nums6 = {1000000, 2000000, 3000000};
        int target6 = 5000000;
        int[] result6 = solution.twoSum(nums6, target6);
        System.out.println("Input: nums = " + Arrays.toString(nums6) + ", target = " + target6);
        System.out.println("Output: " + Arrays.toString(result6));
        System.out.println("Expected: [1, 2]");
        System.out.println("Pass: " + Arrays.equals(result6, new int[]{1, 2}));
        System.out.println();

        // Test Case 7: Answer at the end
        System.out.println("Test Case 7:");
        int[] nums7 = {1, 2, 3, 4, 5, 6};
        int target7 = 11;
        int[] result7 = solution.twoSum(nums7, target7);
        System.out.println("Input: nums = " + Arrays.toString(nums7) + ", target = " + target7);
        System.out.println("Output: " + Arrays.toString(result7));
        System.out.println("Expected: [4, 5]");
        System.out.println("Pass: " + Arrays.equals(result7, new int[]{4, 5}));
        System.out.println();

        // Test Case 8: Mixed positive and negative
        System.out.println("Test Case 8:");
        int[] nums8 = {-3, 4, 3, 90};
        int target8 = 0;
        int[] result8 = solution.twoSum(nums8, target8);
        System.out.println("Input: nums = " + Arrays.toString(nums8) + ", target = " + target8);
        System.out.println("Output: " + Arrays.toString(result8));
        System.out.println("Expected: [0, 2]");
        System.out.println("Pass: " + Arrays.equals(result8, new int[]{0, 2}));
        System.out.println();
    }
}
