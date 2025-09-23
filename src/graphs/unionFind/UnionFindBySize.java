package graphs.unionFind;

public class UnionFindBySize {

    public static int largestComponentSize(int nodes, int[][]edges){
        // Step 1: Initialize arrays
        int[] parent = new int[nodes];  // Track parent of each node
        int[] size = new int[nodes];    // Track size of each component
        int maxSize = 1;                // Track largest component size

        // Step 2: Initialize - each node is its own parent with size 1
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;              // Each node points to itself
            size[i] = 1;                // Each component starts with size 1
        }

        // Step 3: Process each edge - union connected nodes
        for (int[] edge : edges) {
            union(parent, size, edge[0], edge[1]);  // Merge components
            maxSize = Math.max(maxSize, getMaxSize(size));  // Update max
        }

        return maxSize;  // Return largest component size
    }

    // Step 4: Find root with path compression
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {           // If not root
            parent[x] = find(parent, parent[x]);  // Path compression
        }
        return parent[x];               // Return root
    }

    // Step 5: Union by size - merge smaller to larger
    private static void union(int[] parent, int[] size, int x, int y) {
        int rootX = find(parent, x);    // Find root of x
        int rootY = find(parent, y);    // Find root of y

        if (rootX != rootY) {           // If different components
            if (size[rootX] < size[rootY]) {    // If x's component smaller
                parent[rootX] = rootY;          // Attach x to y
                size[rootY] += size[rootX];     // Update y's size
            } else {                            // If y's component smaller or equal
                parent[rootY] = rootX;          // Attach y to x
                size[rootX] += size[rootY];     // Update x's size
            }
        }
    }

    // Step 6: Find maximum size from size array
    private static int getMaxSize(int[] size) {
        int max = 0;
        for (int s : size) {            // Check each component size
            max = Math.max(max, s);     // Track maximum
        }
        return max;
    }

    public static void main(String[] args) {
        // Test Case 1: Expected output = 3
        int n1 = 6;
        int[][] edges1 = {{0,1}, {1,2}, {3,4}};
        int result1 = largestComponentSize(n1, edges1);
        System.out.println("Test 1 - Expected: 3, Got: " + result1);

        // Test Case 2: Expected output = 2
        int n2 = 4;
        int[][] edges2 = {{0,1}, {2,3}};
        int result2 = largestComponentSize(n2, edges2);
        System.out.println("Test 2 - Expected: 2, Got: " + result2);

        // Test Case 3: Expected output = 5
        int n3 = 5;
        int[][] edges3 = {{0,1}, {1,2}, {2,3}, {3,4}};
        int result3 = largestComponentSize(n3, edges3);
        System.out.println("Test 3 - Expected: 5, Got: " + result3);
    }
}