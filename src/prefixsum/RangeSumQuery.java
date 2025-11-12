package prefixsum;

public class RangeSumQuery {
    public int rangeSum(int[]prefix, int i, int j){
        return prefix[j+1]-prefix[i];
    }
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 5};
        int[] prefix = {0, 3, 4, 8, 10, 15};

        RangeSumQuery rsq = new RangeSumQuery();

        // Sum from index 1 to 3 (elements: 1, 4, 2)
        System.out.println(rsq.rangeSum(prefix, 1, 3)); // Output: 7

        // Sum from index 0 to 4 (all elements)
        System.out.println(rsq.rangeSum(prefix, 0, 4)); // Output: 15
    }
}
