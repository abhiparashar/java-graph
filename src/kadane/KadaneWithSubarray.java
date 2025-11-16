package kadane;

public class KadaneWithSubarray {
    public static int[] maxSubArray(int[]nums){
       int currentSum = nums[0];
       int maxSum = nums[0];
       int start = 0;
       int end = 0;
       int tempStart = 0;
        for (int i =1; i < nums.length ; i++) {
            if(nums[i]>currentSum+nums[i]){
                currentSum = nums[i];
                tempStart = i;
            }else {
                currentSum = currentSum+nums[i];
            }

            //Update max and fix indices
            if(currentSum>maxSum){
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        int[] result = new int[end - start + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[start + i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] subarray = maxSubArray(arr);

        System.out.print("Max Subarray: ");
        for (int num : subarray) {
            System.out.print(num + " ");
        }
        // Output: 4 -1 2 1
    }
}
