package prefixsum;

public class ProductofArray {
    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        //left product
        result[0] = 1;
        for (int i = 1; i < nums.length ; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        //right product
        int rightProduct = 1;
        for (int i = nums.length-1; i>=0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
    // Helper method to print arrays
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        ProductofArray solution = new ProductofArray();

        // Test Case 1: Basic example
        System.out.println("Test 1:");
        int[] test1 = {1, 2, 3, 4};
        System.out.print("Input:  ");
        printArray(test1);
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(test1));
        System.out.println("Expected: [24, 12, 8, 6]\n");

        // Test Case 2: With zeros
        System.out.println("Test 2:");
        int[] test2 = {-1, 1, 0, -3, 3};
        System.out.print("Input:  ");
        printArray(test2);
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(test2));
        System.out.println("Expected: [0, 0, 9, 0, 0]\n");

        // Test Case 3: All same numbers
        System.out.println("Test 3:");
        int[] test3 = {2, 2, 2, 2};
        System.out.print("Input:  ");
        printArray(test3);
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(test3));
        System.out.println("Expected: [8, 8, 8, 8]\n");

        // Test Case 4: Two elements
        System.out.println("Test 4:");
        int[] test4 = {3, 4};
        System.out.print("Input:  ");
        printArray(test4);
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(test4));
        System.out.println("Expected: [4, 3]\n");

        // Test Case 5: Negative numbers
        System.out.println("Test 5:");
        int[] test5 = {-1, -2, -3, -4};
        System.out.print("Input:  ");
        printArray(test5);
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(test5));
        System.out.println("Expected: [-24, -12, -8, -6]\n");

        // Test Case 6: Mix of positive and negative
        System.out.println("Test 6:");
        int[] test6 = {1, -1, 2, -2};
        System.out.print("Input:  ");
        printArray(test6);
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(test6));
        System.out.println("Expected: [4, -4, -2, 2]\n");

        // Test Case 7: Single zero in array
        System.out.println("Test 7:");
        int[] test7 = {1, 2, 0, 4};
        System.out.print("Input:  ");
        printArray(test7);
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(test7));
        System.out.println("Expected: [0, 0, 8, 0]\n");

        // Test Case 8: Large numbers
        System.out.println("Test 8:");
        int[] test8 = {10, 20, 30};
        System.out.print("Input:  ");
        printArray(test8);
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(test8));
        System.out.println("Expected: [600, 300, 200]\n");
    }
}
