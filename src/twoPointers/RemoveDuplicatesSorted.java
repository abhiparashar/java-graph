package twoPointers;

public class RemoveDuplicatesSorted {

    // returns k: number of unique elements
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 0) return 0;

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1; // length = index + 1
    }

    // prints only first k elements as [a,b,c]
    public void printArray(int[] nums, int k) {
        System.out.print("[");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        RemoveDuplicatesSorted solution = new RemoveDuplicatesSorted();

        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.print("Test 1: k=" + k1 + ", nums=");
        solution.printArray(nums1, k1); // expected: Test 1: k=2, nums=[1,2]

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.print("Test 2: k=" + k2 + ", nums=");
        solution.printArray(nums2, k2); // expected: Test 2: k=5, nums=[0,1,2,3,4]

        int[] nums3 = {1, 1, 1, 1, 1};
        int k3 = solution.removeDuplicates(nums3);
        System.out.print("Test 3: k=" + k3 + ", nums=");
        solution.printArray(nums3, k3); // expected: Test 3: k=1, nums=[1]

        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = solution.removeDuplicates(nums4);
        System.out.print("Test 4: k=" + k4 + ", nums=");
        solution.printArray(nums4, k4); // expected: Test 4: k=5, nums=[1,2,3,4,5]

        int[] nums5 = {1};
        int k5 = solution.removeDuplicates(nums5);
        System.out.print("Test 5: k=" + k5 + ", nums=");
        solution.printArray(nums5, k5); // expected: Test 5: k=1, nums=[1]

        int[] nums6 = {1, 1};
        int k6 = solution.removeDuplicates(nums6);
        System.out.print("Test 6: k=" + k6 + ", nums=");
        solution.printArray(nums6, k6); // expected: Test 6: k=1, nums=[1]

        int[] nums7 = {1, 2};
        int k7 = solution.removeDuplicates(nums7);
        System.out.print("Test 7: k=" + k7 + ", nums=");
        solution.printArray(nums7, k7); // expected: Test 7: k=2, nums=[1,2]

        int[] nums8 = {-3, -3, -2, -1, -1, 0, 0, 0, 1};
        int k8 = solution.removeDuplicates(nums8);
        System.out.print("Test 8: k=" + k8 + ", nums=");
        solution.printArray(nums8, k8); // expected: Test 8: k=5, nums=[-3,-2,-1,0,1]

        int[] nums9 = {1000, 1000, 1001, 1002, 1002, 1002};
        int k9 = solution.removeDuplicates(nums9);
        System.out.print("Test 9: k=" + k9 + ", nums=");
        solution.printArray(nums9, k9); // expected: Test 9: k=3, nums=[1000,1001,1002]
    }
}
