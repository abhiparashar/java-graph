package graphs.unionFind;

import java.util.Arrays;

public class CountComponents {
    static int[] parent;
    public static int countComponents(int nodes, int[][]edges){
        int count = 0;
        // STEP 1: Initialize - each node is its own group
        parent = new int[nodes];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // STEP 2: Process each edge - merge groups
        for (int[]edge : edges){
            int group1 = findGroup(edge[0]);
            int group2 = findGroup(edge[1]);
            if(group1 != group2){
                parent[group1] = group2;
            }
        }

        // STEP 3: Count unique groups (components)
        for (int i = 0; i < nodes; i++) {
            if(parent[i]==i){
                count++;
            }
        }
        return count;
    }

    private static int findGroup(int node){
        if(node==parent[node]){
            return node; //Leader
        }
        return findGroup(parent[node]);
    }

    public static void main(String[] args) {
        // Test Case 1: Example from problem
        System.out.println("=== TEST CASE 1 ===");
        int n1 = 5;
        int[][] edges1 = {{0,1}, {1,2}, {3,4}};
        System.out.println("Input: n = " + n1 + ", edges = " + Arrays.deepToString(edges1));
        int result1 = countComponents(n1, edges1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2");

        // Test Case 2: All connected
        System.out.println("\n=== TEST CASE 2 ===");
        int n2 = 4;
        int[][] edges2 = {{0,1}, {1,2}, {2,3}};
        System.out.println("Input: n = " + n2 + ", edges = " + Arrays.deepToString(edges2));
        int result2 = countComponents(n2, edges2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");

        // Test Case 3: No edges (all separate)
        System.out.println("\n=== TEST CASE 3 ===");
        int n3 = 3;
        int[][] edges3 = {};
        System.out.println("Input: n = " + n3 + ", edges = " + Arrays.deepToString(edges3));
        int result3 = countComponents(n3, edges3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: 3");

        // Test Case 4: Single node
        System.out.println("\n=== TEST CASE 4 ===");
        int n4 = 1;
        int[][] edges4 = {};
        System.out.println("Input: n = " + n4 + ", edges = " + Arrays.deepToString(edges4));
        int result4 = countComponents(n4, edges4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: 1");

        // Test Case 5: Complex case
        System.out.println("\n=== TEST CASE 5 ===");
        int n5 = 6;
        int[][] edges5 = {{0,1}, {2,3}, {4,5}};
        System.out.println("Input: n = " + n5 + ", edges = " + Arrays.deepToString(edges5));
        int result5 = countComponents(n5, edges5);
        System.out.println("Output: " + result5);
        System.out.println("Expected: 3");

    }
}
