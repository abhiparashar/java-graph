package slidingwindow.pattern2VariableLongestMaximum;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsStringLength {
    public static int longestSubstring(String str){
        int left = 0;
        int maxLength = 0;
        Set<Character>set = new HashSet<>();
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            while (set.contains(ch)){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(longestSubstring(str));
    }
}
