package slidingwindow;

import java.util.HashMap;

public class LongestSubarraySum {
    public static int longestSubarrayWithSumK(int[] arr, int k){
        int maxLength = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < arr.length; right++) {
            sum+=arr[right];
            while (sum>k){
                sum = sum - arr[left];
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void longestSubarrayWithSumKWithArray(int[]arr, int k){
        int left = 0;
        int sum = 0;
        int maxLength = 0;
        int bestLeft = 0, bestRight = -1;
        for (int right = 0; right < arr.length; right++) {
            sum = sum + arr[right];
            while (sum>k){
                sum = sum - arr[left];
                left++;
            }
            // Update max length and store indices
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                bestLeft = left;
                bestRight = right;
            }
        }
        // Print result
        System.out.println("Max Length: " + maxLength);
        System.out.print("Subarray: [");
        for (int i = bestLeft; i <= bestRight; i++) {
            System.out.print(arr[i]);
            if (i < bestRight) System.out.print(", ");
        }
        System.out.println("]");
        System.out.print("Indices: [" + bestLeft + " to " + bestRight + "]");
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int K = 8;
        // Method 1: Just return length
        int length = longestSubarrayWithSumK(arr, K);
        System.out.println("Longest subarray length: " + length);

        // Method 2: Return length and subarray
        longestSubarrayWithSumKWithArray(arr, K);
    }
}
