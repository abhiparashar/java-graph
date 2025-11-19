package slidingwindow;

//Problem: Maximum Sum of K Consecutive Elements without sliding window
public class MaximumSum {
    public static int maxSumBruteForce(int[]arr, int k){
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length-k; i++ ) {
            int sum = 0;
            for (int j = i; j < i+k; j++) {
                sum+=arr[j];
            }
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumBruteForce(arr,k));
        //step-1 : 2+1+5 = 8
        //step-2 : 1+5+1 = 7
        //step-3 : 5+1+3 = 9
        //step-4 : 1+3+2 = 6
        //max = 9
    }
}
