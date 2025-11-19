package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[]strs){
       HashMap<String,List<String>>map = new HashMap<>();
       for (String str : strs){
           char[]chars =str.toCharArray();
           Arrays.sort(chars);
           String key = new String(chars);
           if(!map.containsKey(key)){
               map.put(key, new ArrayList<>());
           }
           map.get(key).add(str);
       }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        GroupAnagram solution = new GroupAnagram();
        // Test 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test 1: " + Arrays.toString(strs1));
        System.out.println("Output: " + solution.groupAnagrams(strs1));
        System.out.println("Expected: [[eat, tea, ate], [tan, nat], [bat]]\n");

        // Test 2
        String[] strs2 = {""};
        System.out.println("Test 2: " + Arrays.toString(strs2));
        System.out.println("Output: " + solution.groupAnagrams(strs2));
        System.out.println("Expected: [[]]\n");

        // Test 3
        String[] strs3 = {"a"};
        System.out.println("Test 3: " + Arrays.toString(strs3));
        System.out.println("Output: " + solution.groupAnagrams(strs3));
        System.out.println("Expected: [[a]]");
    }
}
