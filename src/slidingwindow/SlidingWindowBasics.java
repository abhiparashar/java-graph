package slidingwindow;

public class SlidingWindowBasics {
    public static void printAllWindows(int[]arr, int k){
        for (int i = 0; i <= arr.length-k; i++) {
            System.out.print("Window " + (i+1) + ": [");
            for (int j = i; j < i+k; j++) {
                System.out.print(arr[j]);
                if (j < i + k - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
    public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6};
            int k = 3;
            printAllWindows(arr, k);
    }
}
