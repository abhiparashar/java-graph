package twoPointers;

public class TrappingRainWater {
    public int trap(int[]height){
        int ans=  0;
        if(height==null||height.length<2){
            return ans;
        }
        int left = 0;
        int right = height.length-1;
        return ans;
    }
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Test 1: Basic case from example
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Test 1: " + solution.trap(height1)); // 6

        // Test 2: Another example
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("\nTest 2: " + solution.trap(height2)); // 9

        // Test 3: EDGE CASE - No water can be trapped (ascending)
        int[] height3 = {1, 2, 3, 4, 5};
        System.out.println("\nTest 3: " + solution.trap(height3)); // 0

        // Test 4: EDGE CASE - No water (descending)
        int[] height4 = {5, 4, 3, 2, 1};
        System.out.println("Test 4: " + solution.trap(height4)); // 0

        // Test 5: EDGE CASE - Valley in middle
        int[] height5 = {3, 0, 0, 2, 0, 4};
        System.out.println("\nTest 5: " + solution.trap(height5)); // 10

        // Test 6: EDGE CASE - Single valley
        int[] height6 = {3, 0, 2};
        System.out.println("Test 6: " + solution.trap(height6)); // 2

        // Test 7: EDGE CASE - All same height
        int[] height7 = {2, 2, 2, 2};
        System.out.println("\nTest 7: " + solution.trap(height7)); // 0

        // Test 8: EDGE CASE - Empty spaces at edges
        int[] height8 = {0, 1, 0, 1, 0};
        System.out.println("Test 8: " + solution.trap(height8)); // 1

        // Test 9: EDGE CASE - Too few elements
        int[] height9 = {1, 2};
        System.out.println("\nTest 9: " + solution.trap(height9)); // 0

        // Test 10: EDGE CASE - Single peak
        int[] height10 = {0, 1, 0};
        System.out.println("Test 10: " + solution.trap(height10)); // 0
    }
}
