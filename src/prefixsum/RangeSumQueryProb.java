package prefixsum;

import java.util.Arrays;

public class RangeSumQueryProb {
    private int[] prefixSum;
    public RangeSumQueryProb(int[]nums){
       prefixSum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }
    }
    public int sumRange(int i, int j){
        return prefixSum[j+1] - prefixSum[i];
    }
    public static void main(String[] args) {
        int[]numArray = {1, 2, 3, 4, 5};
        RangeSumQueryProb obj = new RangeSumQueryProb(numArray);
        // Now call sumRange multiple times - O(1) each time!
        System.out.println(obj.sumRange(0, 2)); // Returns: 6
        System.out.println(obj.sumRange(1, 4)); // Returns: 14
        System.out.println(obj.sumRange(2, 2)); // Returns: 3
        System.out.println(obj.sumRange(0, 4)); // Returns: 15
    }
}
