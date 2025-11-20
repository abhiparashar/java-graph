package slidingwindow;

import java.util.HashMap;

public class LongestSubsString {
    public static int longestSubstring(String str){
        int maxLength = 0;
        int left = 0;
        HashMap<Character, Integer>map = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left,map.get(ch)+1);
            }
            map.put(ch,right);
            maxLength = Math.max(maxLength, right - left+1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(longestSubstring(str));
    }
}
