package slidingwindow;

import java.util.HashMap;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String str){
        HashMap<Character, Integer>map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            if(map.containsKey(c)){
               left = Math.max(left, map.get(c)+1);
            }
            map.put(c,right);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    }
}
