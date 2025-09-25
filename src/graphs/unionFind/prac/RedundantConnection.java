package graphs.unionFind.prac;

import java.util.List;

public class RedundantConnection {
    static int[] parent;
    public static int[] findRedundantConnection(int[][]connections){
        //Step-1
        parent = new int[connections.length+1];
        for (int i = 1; i < connections.length+1; i++) {
            parent[i] = i;
        }

        //Step-2
        for (int[]conn : connections){
            int u = conn[0];
            int v = conn[1];
            if (find(parent, u) == find(parent, v)) {
                return conn;
            }
            union(parent, u, v);
        }

        return new int[]{};
    }

    public static void union(int[]parent, int x, int y){
        int group1 = find(parent, x);
        int group2 = find(parent, y);
        if(group1 != group2){
            parent[group1] = group2;
        }
    }

    public static int find(int[]parent, int node){
        if(parent[node] != node){
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    public static void main(String[] args) {
        // Test 1: Triangle cycle
        System.out.println("Test 1: Triangle cycle");
        int[][] edges1 = {{1,2},{1,3},{2,3}};              // Cycle: 1-2-3-1
        int[] result1 = findRedundantConnection(edges1);   // [2,3] creates cycle last
        System.out.println("Redundant edge: [" + result1[0] + "," + result1[1] + "]");  // Expected: [2,3]
        System.out.println();

        // Test 2: Complex graph
        System.out.println("Test 2: Complex graph");
        int[][] edges2 = {{1,2},{2,3},{3,4},{1,4},{1,5}};  // [1,4] creates cycle
        int[] result2 = findRedundantConnection(edges2);   // Path 1-2-3-4 exists, [1,4] redundant
        System.out.println("Redundant edge: [" + result2[0] + "," + result2[1] + "]");  // Expected: [1,4]
        System.out.println();

        // Test 3: Simple cycle
        System.out.println("Test 3: Simple cycle");
        int[][] edges3 = {{1,2},{2,3},{1,3}};              // Last edge creates cycle
        int[] result3 = findRedundantConnection(edges3);
        System.out.println("Redundant edge: [" + result3[0] + "," + result3[1] + "]");  // Expected: [1,3]
        System.out.println();

        // Test 4: Chain with cycle at end
        System.out.println("Test 4: Chain with cycle");
        int[][] edges4 = {{1,2},{2,3},{3,4},{4,5},{2,5}};  // [2,5] creates cycle
        int[] result4 = findRedundantConnection(edges4);
        System.out.println("Redundant edge: [" + result4[0] + "," + result4[1] + "]");  // Expected: [2,5]
    }
}
