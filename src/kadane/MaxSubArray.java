package kadane;

public class MaxSubArray {
    public static int maxSum(int[]nums){
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[]nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSum(nums);
        System.out.println(result);
    }
}
