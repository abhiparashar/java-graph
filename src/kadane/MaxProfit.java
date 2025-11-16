package kadane;

import kotlin.math.UMathKt;

public class MaxProfit {
    public int maxProfit(int[]prices){
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length ; i++) {
            maxProfit = Math.max(maxProfit,prices[i]-minPrice); // 5
            minPrice = Math.min(prices[i],minPrice); //1
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();

        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + sol.maxProfit(prices1)); // 5

        // Test Case 2: Prices keep falling
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test 2: " + sol.maxProfit(prices2)); // 0

        // Test Case 3: Single peak
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + sol.maxProfit(prices3)); // 4

        // Test Case 4: Two elements
        int[] prices4 = {2, 4};
        System.out.println("Test 4: " + sol.maxProfit(prices4)); // 2

        // Test Case 5: Buy and sell same day scenario
        int[] prices5 = {3, 3, 3, 3};
        System.out.println("Test 5: " + sol.maxProfit(prices5)); // 0
    }
}
