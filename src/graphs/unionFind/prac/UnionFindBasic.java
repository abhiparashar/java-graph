package graphs.unionFind.prac;

public class UnionFindBasic {
    static int[] parent;
    public static boolean areConnected(int nodes, int[][]connections,int x, int y ){
        //step-1 : initialize
        parent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
        }

        for (int[]conn:connections){
            union(parent,conn[0],conn[1]);
        }

        return find(parent, x) == find(parent, y);
    }

    private static void union(int[]parent, int x, int y){
        int px = find(parent,x);
        int py = find(parent,y);
        if(px != py){
            parent[px] = py;
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        // Test 1: Basic connection
        System.out.println("Test 1: Basic connections");
        int[][] connections1 = {{0,1}, {1,2}};                    // Connect 0-1 and 1-2
        boolean result1a = areConnected(4, connections1, 0, 2);   // parent=[0,1,2,3] → [1,1,2,3] → [1,2,2,3]
        boolean result1b = areConnected(4, connections1, 0, 3);   // find(0)→2, find(2)→2 → true; find(0)→2, find(3)→3 → false
        System.out.println("0 and 2 connected? " + result1a);    // Expected: true
        System.out.println("0 and 3 connected? " + result1b);    // Expected: false
        System.out.println();

        // Test 2: Chain connections
        System.out.println("Test 2: Chain connections");
        int[][] connections2 = {{0,1}, {2,3}, {1,3}};            // parent=[0,1,2,3,4] → [1,1,3,3,4] → [1,3,3,3,4]
        boolean result2a = areConnected(5, connections2, 0, 3);  // find(0)→3, find(3)→3 → true
        boolean result2b = areConnected(5, connections2, 0, 4);  // find(0)→3, find(4)→4 → false
        System.out.println("0 and 3 connected? " + result2a);   // Expected: true
        System.out.println("0 and 4 connected? " + result2b);   // Expected: false
        System.out.println();

        // Test 3: Already connected
        System.out.println("Test 3: Duplicate connections");
        int[][] connections3 = {{0,1}, {0,1}};                  // Connect same pair twice
        boolean result3 = areConnected(3, connections3, 0, 1);  // parent=[0,1,2] → [1,1,2] (no change on 2nd union)
        System.out.println("0 and 1 connected? " + result3);   // Expected: true
        System.out.println();

        // Test 4: No connections
        System.out.println("Test 4: No connections");
        int[][] connections4 = {};                              // Empty connections
        boolean result4a = areConnected(3, connections4, 0, 0); // find(0)→0, find(0)→0 → true
        boolean result4b = areConnected(3, connections4, 0, 1); // find(0)→0, find(1)→1 → false
        System.out.println("0 connected to itself? " + result4a); // Expected: true
        System.out.println("0 and 1 connected? " + result4b);
    }
}