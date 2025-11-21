package slidingwindow.pattern2VariableLongestMaximum;

public class MaxConsOne {
    public static int findMaxConsecutiveOnes(int[]nums){
        int maxLen = 0;
        int count = 0;
       for (int num : nums){
           if(num==1){
               count++;
               maxLen = Math.max(maxLen, count);
           }else {
               count = 0;
           }
       }
        return maxLen;
    }
    public static void main(String[] args) {
        int[]nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
