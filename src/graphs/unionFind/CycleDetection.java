package graphs.unionFind;

import java.util.Arrays;

public class CycleDetection {
    static int parent[];
    public static boolean hasCycle(int nodes, int[][]edges){
        //Initialize the array
        parent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
        }

        //findGroup
        for (int[]edge : edges){
            int group1 = findGroup(edge[0]);
            int group2 = findGroup(edge[1]);;
            if(group1==group2){
                return true;
            }
            parent[group1] = group2;
        }
        return false;
    }

    private static int findGroup(int node){
        if(parent[node]==node){
            return node;
        }
        return findGroup(parent[node]);
    }

    public static void main(String[] args) {
        // Test Case 1: Has cycle
        System.out.println("=== TEST CASE 1: HAS CYCLE ===");
        int n1 = 4;
        int[][] edges1 = {{0,1}, {1,2}, {2,3}, {3,0}};
        System.out.println("Input: n = " + n1 + ", edges = " + Arrays.deepToString(edges1));
        boolean result1 = hasCycle(n1, edges1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: true");

        // Test Case 2: No cycle
        System.out.println("\n=== TEST CASE 2: NO CYCLE ===");
        int n2 = 4;
        int[][] edges2 = {{0,1}, {1,2}};
        System.out.println("Input: n = " + n2 + ", edges = " + Arrays.deepToString(edges2));
        boolean result2 = hasCycle(n2, edges2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: false");

        // Test Case 3: Simple cycle
        System.out.println("\n=== TEST CASE 3: SIMPLE CYCLE ===");
        int n3 = 3;
        int[][] edges3 = {{0,1}, {1,2}, {0,2}};
        System.out.println("Input: n = " + n3 + ", edges = " + Arrays.deepToString(edges3));
        boolean result3 = hasCycle(n3, edges3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: true");

        // Test Case 4: No edges
        System.out.println("\n=== TEST CASE 4: NO EDGES ===");
        int n4 = 3;
        int[][] edges4 = {};
        System.out.println("Input: n = " + n4 + ", edges = " + Arrays.deepToString(edges4));
        boolean result4 = hasCycle(n4, edges4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: false");
    }
}
