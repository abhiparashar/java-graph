package prefixsum;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[]nums, int target){
      HashMap<Integer,Integer>map = new HashMap<>();
      map.put(0,1);
      int count = 0;
      int prefixSum = 0;
      for (int num:nums){
          prefixSum+=num;
          if(map.containsKey(prefixSum-target)){
              count += map.get(prefixSum-target);
          }
          map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
      }
      return count;
    }
    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        // Test Case 1
        int[] nums1 = {1, 1, 1};
        System.out.println("Test 1: " + solution.subarraySum(nums1, 2));
        // Expected: 2

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        System.out.println("Test 2: " + solution.subarraySum(nums2, 3));
        // Expected: 2

        // Test Case 3
        int[] nums3 = {1, -1, 1, -1, 1};
        System.out.println("Test 3: " + solution.subarraySum(nums3, 0));
        // Expected: 4

        // Test Case 4
        int[] nums4 = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println("Test 4: " + solution.subarraySum(nums4, 7));
        // Expected: 4

        // Test Case 5
        int[] nums5 = {1};
        System.out.println("Test 5: " + solution.subarraySum(nums5, 1));
        // Expected: 1
    }
}
