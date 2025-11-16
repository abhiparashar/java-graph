package kadane;

public class MaxProduct {
    public int maxProduct(int[] nums){
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            int tempMax = maxProd;
            //Max Prod
            maxProd = Math.max(nums[i], Math.max(nums[i]*maxProd, nums[i]*minProd));
            //Min Prod
            minProd = Math.min(nums[i], Math.min(tempMax*maxProd, nums[i]*minProd));

            result = Math.max(result, maxProd);
        }
        return result;
    }
    public static void main(String[] args) {
        MaxProduct sol = new MaxProduct();

        // Test Case 1: Basic case
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Test 1: " + sol.maxProduct(nums1)); // 6

        // Test Case 2: With zero
        int[] nums2 = {-2, 0, -1};
        System.out.println("Test 2: " + sol.maxProduct(nums2)); // 0

        // Test Case 3: All negative (even count)
        int[] nums3 = {-2, -3, -4};
        System.out.println("Test 3: " + sol.maxProduct(nums3)); // 24

        // Test Case 4: All negative (odd count)
        int[] nums4 = {-2, -3};
        System.out.println("Test 4: " + sol.maxProduct(nums4)); // 6

        // Test Case 5: Single negative
        int[] nums5 = {-2};
        System.out.println("Test 5: " + sol.maxProduct(nums5)); // -2

        // Test Case 6: All positive
        int[] nums6 = {2, 3, 4};
        System.out.println("Test 6: " + sol.maxProduct(nums6)); // 24

        // Test Case 7: Large negative flip
        int[] nums7 = {2, -5, -2, -4, 3};
        System.out.println("Test 7: " + sol.maxProduct(nums7)); // 24
    }
}
