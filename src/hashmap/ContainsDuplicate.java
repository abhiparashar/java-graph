package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[]nums){
        HashMap<Integer, Integer>map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], 0);
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Test 1: Has duplicate
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.containsDuplicate(nums1));
        System.out.println("Expected: true\n");

        // Test 2: No duplicate
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test 2: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.containsDuplicate(nums2));
        System.out.println("Expected: false\n");

        // Test 3: All same
        int[] nums3 = {1, 1, 1, 1};
        System.out.println("Test 3: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.containsDuplicate(nums3));
        System.out.println("Expected: true");
    }
}
