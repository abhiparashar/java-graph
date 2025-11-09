package twoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String str){
        if(str==null || str.isEmpty()){
            return true;
        }
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            // Skip non-alphanumeric from left
            while (left<right && !Character.isLetterOrDigit(str.charAt(left))){
                left++;
            }
            // Skip non-alphanumeric from left
            while (left<right && !Character.isLetterOrDigit(str.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(str.charAt(left))!=Character.toLowerCase(str.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        // Test Case 1: Valid palindrome with spaces and punctuation
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Expected: true, Got: " + solution.isPalindrome(test1));
        System.out.println();

        // Test Case 2: Not a palindrome
        String test2 = "race a car";
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Expected: false, Got: " + solution.isPalindrome(test2));
        System.out.println();

        // Test Case 3: Empty string (only spaces/punctuation)
        String test3 = " ";
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Expected: true, Got: " + solution.isPalindrome(test3));
        System.out.println();

        // Test Case 4: Single character
        String test4 = "a";
        System.out.println("Test 4: \"" + test4 + "\"");
        System.out.println("Expected: true, Got: " + solution.isPalindrome(test4));
        System.out.println();

        // Test Case 5: Two different characters
        String test5 = "ab";
        System.out.println("Test 5: \"" + test5 + "\"");
        System.out.println("Expected: false, Got: " + solution.isPalindrome(test5));
        System.out.println();

        // Test Case 6: Alphanumeric palindrome
        String test6 = "0P";
        System.out.println("Test 6: \"" + test6 + "\"");
        System.out.println("Expected: false, Got: " + solution.isPalindrome(test6));
        System.out.println();

        // Test Case 7: Numbers included
        String test7 = "A1b2B1a";
        System.out.println("Test 7: \"" + test7 + "\"");
        System.out.println("Expected: true, Got: " + solution.isPalindrome(test7));
        System.out.println();

        // Test Case 8: Only special characters
        String test8 = ".,!@#";
        System.out.println("Test 8: \"" + test8 + "\"");
        System.out.println("Expected: true, Got: " + solution.isPalindrome(test8));
    }
}
