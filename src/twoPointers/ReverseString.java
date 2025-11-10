package twoPointers;

public class ReverseString {
    public String reverseString(char[]charArr){
        String ans = "";
        if(charArr==null || charArr.length==0){
            return "";
        }
        return ans;
    }
    public static void main(String[] args) {
        ReverseString solution = new ReverseString();

        // Test Case 1: Normal string
        char[] test1 = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Test 1: " + java.util.Arrays.toString(test1));
        solution.reverseString(test1);
        System.out.println("Expected: [o, l, l, e, h]");
        System.out.println("Got:      " + java.util.Arrays.toString(test1));
        System.out.println();

        // Test Case 2: Another string
        char[] test2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.println("Test 2: " + java.util.Arrays.toString(test2));
        solution.reverseString(test2);
        System.out.println("Expected: [h, a, n, n, a, H]");
        System.out.println("Got:      " + java.util.Arrays.toString(test2));
        System.out.println();

        // Test Case 3: Single character
        char[] test3 = {'a'};
        System.out.println("Test 3: " + java.util.Arrays.toString(test3));
        solution.reverseString(test3);
        System.out.println("Expected: [a]");
        System.out.println("Got:      " + java.util.Arrays.toString(test3));
        System.out.println();

        // Test Case 4: Two characters
        char[] test4 = {'a', 'b'};
        System.out.println("Test 4: " + java.util.Arrays.toString(test4));
        solution.reverseString(test4);
        System.out.println("Expected: [b, a]");
        System.out.println("Got:      " + java.util.Arrays.toString(test4));
        System.out.println();

        // Test Case 5: Even length
        char[] test5 = {'a', 'b', 'c', 'd'};
        System.out.println("Test 5: " + java.util.Arrays.toString(test5));
        solution.reverseString(test5);
        System.out.println("Expected: [d, c, b, a]");
        System.out.println("Got:      " + java.util.Arrays.toString(test5));
        System.out.println();

        // Test Case 6: Odd length
        char[] test6 = {'a', 'b', 'c', 'd', 'e'};
        System.out.println("Test 6: " + java.util.Arrays.toString(test6));
        solution.reverseString(test6);
        System.out.println("Expected: [e, d, c, b, a]");
        System.out.println("Got:      " + java.util.Arrays.toString(test6));
    }
}
