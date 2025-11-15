package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums){
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        int maxLen = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]==0?-1:1;
            if(map.containsKey(prefixSum)){
                int length = i-map.get(prefixSum);
                maxLen = Math.max(maxLen,length);
            }else {
                // Store first occurrence of this prefix sum
                map.put(prefixSum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        ContiguousArray solution = new ContiguousArray();
        // Test Case 1: Basic case with equal 0s and 1s
        int[] test1 = {0, 1};
        System.out.println("Test 1: " + solution.findMaxLength(test1));
        // Expected: 2 (entire array)

        // Test Case 2: Longer array with subarray
        int[] test2 = {0, 1, 0};
        System.out.println("Test 2: " + solution.findMaxLength(test2));
        // Expected: 2 (subarray [0,1])

        // Test Case 3: No valid subarray
        int[] test3 = {0, 0, 0};
        System.out.println("Test 3: " + solution.findMaxLength(test3));
        // Expected: 0 (no equal 0s and 1s)

        // Test Case 4: Entire array is valid
        int[] test4 = {0, 1, 1, 0, 1, 0};
        System.out.println("Test 4: " + solution.findMaxLength(test4));
        // Expected: 6 (entire array: three 0s, three 1s)

        // Test Case 5: Valid subarray in middle
        int[] test5 = {0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println("Test 5: " + solution.findMaxLength(test5));
        // Expected: 6 (subarray [1,0,0,0,1,1] from index 2-7)

        // Test Case 6: Multiple valid subarrays
        int[] test6 = {1, 1, 1, 0, 0, 0, 1, 0};
        System.out.println("Test 6: " + solution.findMaxLength(test6));
        // Expected: 8 (entire array: four 0s, four 1s)

        // Test Case 7: Single element
        int[] test7 = {1};
        System.out.println("Test 7: " + solution.findMaxLength(test7));
        // Expected: 0 (can't have equal 0s and 1s)

        // Test Case 8: Two elements, same
        int[] test8 = {1, 1};
        System.out.println("Test 8: " + solution.findMaxLength(test8));
        // Expected: 0 (no equal 0s and 1s)

        // Test Case 9: Alternating pattern
        int[] test9 = {0, 1, 0, 1, 0, 1};
        System.out.println("Test 9: " + solution.findMaxLength(test9));
        // Expected: 6 (entire array)

        // Test Case 10: Large array with answer at end
        int[] test10 = {1, 1, 1, 1, 0, 0, 0, 0};
        System.out.println("Test 10: " + solution.findMaxLength(test10));
        // Expected: 8 (entire array)
    }
}
