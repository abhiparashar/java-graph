package slidingwindow;

public class WindowSum {
    public static void printWindowSumsBrute(int[]arr, int k){
        for (int i = 0; i <= arr.length-k; i++) {
            System.out.println("Window " + (i+1) + " sum is: ");
            int sum = 0;
            for (int j = i; j <i+k ; j++) {
                sum += arr[j];
            }
            System.out.println(sum);
        }
    }

    public static void printWindowSumsOptimal(int[]arr, int k){
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=arr[i];
        }
        System.out.println("Window 1 sum: " + sum);
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i-k] + arr[i];
            System.out.println("Window " + (i-k+2) + " sum: " + sum);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3;

        System.out.println("=== Brute Force ===");
        printWindowSumsBrute(arr, k);

        System.out.println("\n=== Sliding Window ===");
        printWindowSumsOptimal(arr, k);
    }
}
