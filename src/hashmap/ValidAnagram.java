package hashmap;

import java.util.HashMap;
import java.util.Objects;

public class ValidAnagram {
    public boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        HashMap<Character,Integer>map = new HashMap<>();
        // Count characters in s
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrease count for characters in t
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        // Test 1
        System.out.println("Test 1: \"anagram\", \"nagaram\"");
        System.out.println("Output: " + solution.isAnagram("anagram", "nagaram"));
        System.out.println("Expected: true\n");

        // Test 2
        System.out.println("Test 2: \"rat\", \"car\"");
        System.out.println("Output: " + solution.isAnagram("rat", "car"));
        System.out.println("Expected: false\n");

        // Test 3
        System.out.println("Test 3: \"a\", \"ab\"");
        System.out.println("Output: " + solution.isAnagram("a", "ab"));
        System.out.println("Expected: false");
    }
}
