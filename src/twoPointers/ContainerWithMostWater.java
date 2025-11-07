package twoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[]height){
        int maxArea = 0;
        if(height==null|| height.length<2){
            return maxArea;
        }
        int left = 0;
        int right = height.length-1;
        while (left<right){
           int currentMaxArea = Math.min(height[left],height[right])*(right-left);
           maxArea = Math.max(maxArea,currentMaxArea);
           if(height[left]<height[right]){
                left++;
           }else {
               right--;
           }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test 1: Basic case
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test 1: " + solution.maxArea(height1)); // 49

        // Test 2: EDGE CASE - Minimum size
        int[] height2 = {1, 1};
        System.out.println("Test 2: " + solution.maxArea(height2)); // 1

        // Test 3: EDGE CASE - Ascending order
        int[] height3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + solution.maxArea(height3)); // 6 (2*3)

        // Test 4: EDGE CASE - Descending order
        int[] height4 = {5, 4, 3, 2, 1};
        System.out.println("Test 4: " + solution.maxArea(height4)); // 6 (2*3)

        // Test 5: EDGE CASE - All same height
        int[] height5 = {3, 3, 3, 3};
        System.out.println("Test 5: " + solution.maxArea(height5)); // 9 (3*3)

        // Test 6: EDGE CASE - Very tall edges
        int[] height6 = {100, 1, 1, 1, 1, 100};
        System.out.println("Test 6: " + solution.maxArea(height6)); // 500 (100*5)

        // Test 7: One very tall line
        int[] height7 = {1, 100, 1};
        System.out.println("Test 7: " + solution.maxArea(height7)); // 2 (1*2)

        // Test 8: EDGE CASE - Zero heights mixed in
        int[] height8 = {0, 2, 0, 3, 0};
        System.out.println("Test 8: " + solution.maxArea(height8)); // 6 (2*3)

        // Compare with optimized version
        System.out.println("\nOptimized version:");
//        System.out.println("Test 1 Optimized: " + solution.maxAreaOptimized(height1)); // 49
//        System.out.println("Test 6 Optimized: " + solution.maxAreaOptimized(height6)); // 500
    }
}
