package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class countSubarraysWithSum {
    public int countSubarraysWithSum(int[]nums, int target){
        Map<Integer, Integer>prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  // Base case: empty subarray
        int count = 0;
        int prefixSum = 0;
        for (int num : nums){
            prefixSum = prefixSum+num;
            if(prefixCount.containsKey(prefixSum-target)){
                count = count+ prefixCount.get(prefixSum-target);
            }
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        countSubarraysWithSum ssc = new countSubarraysWithSum();

        int[] nums1 = {1, 2, 3};
        int target1 = 3;
        System.out.println("Test 1 Output: " + ssc.countSubarraysWithSum(nums1, target1));
        // Expected: 2 → [1,2], [3]

        int[] nums2 = {1, 1, 1};
        int target2 = 2;
        System.out.println("Test 2 Output: " + ssc.countSubarraysWithSum(nums2, target2));
        // Expected: 2 → [1,1] at (0,1) and (1,2)
    }
}
