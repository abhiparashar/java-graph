package slidingwindow;

public class MaxSumSlidingWindow {
    public static int maxSumSlidingWindow(int[]arr, int k){
        int sum = 0;
        //Calculate First Window
        for (int i = 0; i < k; i++) {
            sum+=arr[i];
        }
        int maxSum = sum;
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i-k] + arr[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max Sum: " + maxSumSlidingWindow(arr, k));
    }
}
