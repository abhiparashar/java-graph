package prefixsum;

public class FindPivotIndex {
    public int pivotIndex(int[]nums){
        int total = 0;
        for (int num : nums){
            total = total + num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum  - nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum = leftSum+nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        FindPivotIndex solution = new FindPivotIndex();

        // Test Case 1
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println("Test 1: " + solution.pivotIndex(nums1));
        // Expected: 3

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        System.out.println("Test 2: " + solution.pivotIndex(nums2));
        // Expected: -1

        // Test Case 3
        int[] nums3 = {2, 1, -1};
        System.out.println("Test 3: " + solution.pivotIndex(nums3));
        // Expected: 0

        // Test Case 4
        int[] nums4 = {-1, -1, -1, 0, 1, 1};
        System.out.println("Test 4: " + solution.pivotIndex(nums4));
        // Expected: 0

        // Test Case 5
        int[] nums5 = {5};
        System.out.println("Test 5: " + solution.pivotIndex(nums5));
        // Expected: 0
    }
}
