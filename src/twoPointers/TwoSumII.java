package twoPointers;

public class TwoSumII {
    public int[] twoSum(int[]numbers, int target){
        if(numbers==null || numbers.length<2){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = numbers.length-1;
        while (left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }
            else if(sum<target){
                left++;
            }else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();

        // Test 1: Basic case
        int[] nums1 = {2, 7, 11, 15};
        int[] result1 = solution.twoSum(nums1, 9);
        System.out.println("Test 1: [" + result1[0] + ", " + result1[1] + "]"); // [1, 2]

        // Test 2: Multiple valid pairs (returns first found)
        int[] nums2 = {2, 3, 4};
        int[] result2 = solution.twoSum(nums2, 6);
        System.out.println("Test 2: [" + result2[0] + ", " + result2[1] + "]"); // [1, 3]

        // Test 3: EDGE CASE - Negative numbers
        int[] nums3 = {-1, 0};
        int[] result3 = solution.twoSum(nums3, -1);
        System.out.println("Test 3: [" + result3[0] + ", " + result3[1] + "]"); // [1, 2]

        // Test 4: EDGE CASE - All negative numbers
        int[] nums4 = {-10, -5, -3, -1};
        int[] result4 = solution.twoSum(nums4, -8);
        System.out.println("Test 4: [" + result4[0] + ", " + result4[1] + "]"); // [2, 3]

        // Test 5: EDGE CASE - Large numbers
        int[] nums5 = {1, 2, 3, 4, 5, 1000};
        int[] result5 = solution.twoSum(nums5, 1001);
        System.out.println("Test 5: [" + result5[0] + ", " + result5[1] + "]"); // [1, 6]

        // Test 6: EDGE CASE - Duplicates
        int[] nums6 = {1, 2, 2, 3};
        int[] result6 = solution.twoSum(nums6, 4);
        System.out.println("Test 6: [" + result6[0] + ", " + result6[1] + "]"); // [2, 3]
    }
}
