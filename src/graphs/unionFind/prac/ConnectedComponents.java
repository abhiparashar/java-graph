package graphs.unionFind.prac;

public class ConnectedComponents {
    static int[]parent;
    static int components;
    public static int countComponents(int nodes, int[][]connections){
        //Step-1 : Initialization
        parent = new int[nodes];
        components = nodes;
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
        }

        //Step-2 : Check connection
        for (int[]conn : connections){
            union(parent, conn[0],conn[1]);
        }

        return components;
    }

    private static void union(int[]parent,int x, int y){
       int group1 = find(parent, x);
       int group2 = find(parent, y);
       if(group1 != group2){
           parent[group1] = group2;
           components--;
       }
    }

    private static int find(int[]parent, int node){
        if(parent[node]!= node){
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    public static void main(String[] args) {
        // Test 1: Two components
        System.out.println("Test 1: Two separate components");
        int[][] edges1 = {{0,1},{1,2},{3,4}};              // Connect 0-1-2 and 3-4
        int result1 = countComponents(5, edges1);          // Start with 5 → 4 → 3 → 2
        System.out.println("Components: " + result1);      // Expected: 2
        System.out.println();

        // Test 2: One big component
        System.out.println("Test 2: All connected");
        int[][] edges2 = {{0,1},{1,2},{2,3},{3,4}};        // Chain: 0-1-2-3-4
        int result2 = countComponents(5, edges2);          // Start with 5 → 4 → 3 → 2 → 1
        System.out.println("Components: " + result2);      // Expected: 1
        System.out.println();

        // Test 3: No edges - all separate
        System.out.println("Test 3: No connections");
        int[][] edges3 = {};                               // No edges
        int result3 = countComponents(4, edges3);          // Start with 4, no unions → 4
        System.out.println("Components: " + result3);      // Expected: 4
        System.out.println();

        // Test 4: Triangle connection
        System.out.println("Test 4: Triangle");
        int[][] edges4 = {{0,1},{1,2},{2,0}};              // Cycle: 0-1-2-0
        int result4 = countComponents(3, edges4);          // Start with 3 → 2 → 1 (3rd edge does nothing)
        System.out.println("Components: " + result4);      // Expected: 1
        System.out.println();

        // Test 5: Multiple components
        System.out.println("Test 5: Three components");
        int[][] edges5 = {{0,1},{2,3}};                    // Two pairs: 0-1 and 2-3, node 4 alone
        int result5 = countComponents(5, edges5);          // Start with 5 → 4 → 3
        System.out.println("Components: " + result5);      // Expected: 3 ({0,1}, {2,3}, {4})
    }
}
