package graphs.unionFind;

import java.util.Arrays;

public class FriendCircles {
    static int[] parent;
    public static int findCircleNum(int[][]isConnected){
        int nodes=  isConnected.length;

        // STEP 1: Initialize - each person is their own circle
        parent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
        }

        // STEP 2: Process adjacency matrix
        for (int i = 0; i < nodes; i++) {
            for (int j = i+1; j <nodes ; j++) {
                if(isConnected[i][j]==1){
                    int group1 = findGroup(i);
                    int group2 = findGroup(j);
                    if(group1!=group2){
                        parent[group1] = group2;
                    }
                }
            }
        }

        // STEP 3: Count unique circles
        int circles = 0;
        for (int i = 0; i < nodes; i++) {
            if(parent[i]==i){
                circles++;
            }
        }

        return circles;
    }

    private static int findGroup(int node){
        if(parent[node]== node){
            return node;
        }
        return findGroup(parent[node]);
    }

    public static void main(String[] args) {
        // Test Case 1: Two circles
        System.out.println("=== TEST CASE 1: TWO CIRCLES ===");
        int[][] isConnected1 = {{1,1,0},
                {1,1,0},
                {0,0,1}};
        System.out.println("Input: isConnected = " + Arrays.deepToString(isConnected1));
        int result1 = findCircleNum(isConnected1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2");

        // Test Case 2: All separate
        System.out.println("\n=== TEST CASE 2: ALL SEPARATE ===");
        int[][] isConnected2 = {{1,0,0},
                {0,1,0},
                {0,0,1}};
        System.out.println("Input: isConnected = " + Arrays.deepToString(isConnected2));
        int result2 = findCircleNum(isConnected2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 3");

        // Test Case 3: All connected
        System.out.println("\n=== TEST CASE 3: ALL CONNECTED ===");
        int[][] isConnected3 = {{1,1,1},
                {1,1,1},
                {1,1,1}};
        System.out.println("Input: isConnected = " + Arrays.deepToString(isConnected3));
        int result3 = findCircleNum(isConnected3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: 1");

        // Test Case 4: Chain connection
        System.out.println("\n=== TEST CASE 4: CHAIN CONNECTION ===");
        int[][] isConnected4 = {{1,1,0,0},
                {1,1,1,0},
                {0,1,1,0},
                {0,0,0,1}};
        System.out.println("Input: isConnected = " + Arrays.deepToString(isConnected4));
        int result4 = findCircleNum(isConnected4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: 2");
    }
}
