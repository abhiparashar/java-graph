package prefixsum;

import java.util.Arrays;

public class PrefixSumBasics {
    public int[] buildPrefixSum(int[]nums){
        int[]ans = new int[nums.length+1];
        for (int i = 0; i < ans.length-1; i++) {
            ans[i+1] = ans[i]+nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        PrefixSumBasics ps = new PrefixSumBasics();
        int[] nums = {3, 1, 4, 2, 5};
        int[] prefix = ps.buildPrefixSum(nums);
        // Print: [0, 3, 4, 8, 10, 15]
        System.out.println(Arrays.toString(prefix));
    }
}
