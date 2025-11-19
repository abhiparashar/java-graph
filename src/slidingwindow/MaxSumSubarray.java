package slidingwindow;

public class MaxSumSubarray {
    public static int maxSumSubarray(int[] arr, int k){
        if (arr.length < k) {
            System.out.println("Invalid: array size < k");
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=arr[i];
        }
       int maxSum = sum;
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i-k] + arr[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        System.out.println("Max sum: " + maxSumSubarray(arr1, k1)); // Output: 9

        int[] arr2 = {2, 3, 4, 1, 5};
        int k2 = 2;
        System.out.println("Max sum: " + maxSumSubarray(arr2, k2)); // Output: 7
    }
}
