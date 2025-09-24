package graphs.unionFind.prac;

public class ValidPathUnionFind {
    static int[] parent;
    public static boolean validPath(int nodes,int[][]connections, int x, int y){
        //step-1 : initialize
        parent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
        }

        //make connections
        for (int[]conn : connections){
            union(parent,conn[0],conn[1]);
        }

       return find(parent,x)==find(parent,y);
    }

    private static void union(int[]parent, int x, int y){
        int group1 = find(parent, x);
        int group2 = find(parent, y);

        if(group1 != group2){
           parent[group1] = group2;
        }
    }

    private static int find(int[]parent, int node){
        if(parent[node]!=node){
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    public static void main(String[] args) {
        // Test 1: Path exists
        System.out.println("Test 1: Path exists");
        int[][] edges1 = {{0,1},{1,2},{2,0}};                    // All connected in cycle
        boolean result1 = validPath(3, edges1, 0, 2);            // parent=[0,1,2] → [1,2,2] → find(0)=2, find(2)=2
        System.out.println("Path from 0 to 2? " + result1);      // Expected: true
        System.out.println();

        // Test 2: No path exists
        System.out.println("Test 2: No path exists");
        int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};        // Two separate groups: {0,1,2} and {3,4,5}
        boolean result2 = validPath(6, edges2, 0, 5);            // parent=[0,1,2,3,4,5] → find(0)≠find(5)
        System.out.println("Path from 0 to 5? " + result2);      // Expected: false
        System.out.println();

        // Test 3: Direct connection
        System.out.println("Test 3: Direct connection");
        int[][] edges3 = {{0,1}};                                // Simple edge 0-1
        boolean result3 = validPath(2, edges3, 0, 1);            // parent=[0,1] → [1,1] → find(0)=1, find(1)=1
        System.out.println("Path from 0 to 1? " + result3);      // Expected: true
        System.out.println();

        // Test 4: No edges, same node
        System.out.println("Test 4: Same source and destination");
        int[][] edges4 = {};                                     // No edges
        boolean result4 = validPath(1, edges4, 0, 0);            // parent=[0] → find(0)=0, find(0)=0
        System.out.println("Path from 0 to 0? " + result4);      // Expected: true (same node)
        System.out.println();

        // Test 5: No edges, different nodes
        System.out.println("Test 5: No connection");
        int[][] edges5 = {};                                     // No edges
        boolean result5 = validPath(3, edges5, 0, 2);            // parent=[0,1,2] → find(0)=0, find(2)=2
        System.out.println("Path from 0 to 2? " + result5);      // Expected: false

    }
}
