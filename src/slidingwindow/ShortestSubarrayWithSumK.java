package slidingwindow;

public class ShortestSubarrayWithSumK {

    // Sliding Window Approach - O(n)
    public static int shortestSubarrayWithSumK(int[] arr, int K) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            // Add current element to window
            sum += arr[right];

            // Shrink window from left while sum >= K
            while (sum >= K) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Method to also return the subarray
    public static void shortestSubarrayWithSumKWithArray(int[] arr, int K) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int bestLeft = 0, bestRight = -1;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= K) {
                // Update min length and store indices
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    bestLeft = left;
                    bestRight = right;
                }
                sum -= arr[left];
                left++;
            }
        }

        // Print result
        if (minLength == Integer.MAX_VALUE) {
            System.out.println("No subarray found with sum >= " + K);
        } else {
            System.out.println("Min Length: " + minLength);
            System.out.print("Subarray: [");
            for (int i = bestLeft; i <= bestRight; i++) {
                System.out.print(arr[i]);
                if (i < bestRight) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Indices: [" + bestLeft + " to " + bestRight + "]");

            // Calculate sum for verification
            int verifySum = 0;
            for (int i = bestLeft; i <= bestRight; i++) {
                verifySum += arr[i];
            }
            System.out.println("Sum: " + verifySum);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int K = 7;

        System.out.println("Array: [2, 3, 1, 2, 4, 3]");
        System.out.println("K = " + K);
        System.out.println();

        // Method 1: Just return length
        int length = shortestSubarrayWithSumK(arr, K);
        System.out.println("Shortest subarray length: " + length);
        System.out.println();

        // Method 2: Return length and subarray
        shortestSubarrayWithSumKWithArray(arr, K);
    }
}
