package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedComponents {
    public static class Solution{
       public static int numProvinces(List<List<Integer>>adjMatrix, int node){
           //adjacency matrix to adjacency list
           List<List<Integer>>graph = new ArrayList<>();
           for (int i = 0; i < node; i++) {
                graph.add(new ArrayList<>());
           }

           for (int i = 0; i < node ; i++) {
               for (int j = 0; j < adjMatrix.get(i).size() ; j++) {
                    if(adjMatrix.get(i).get(j)==1 && i != j){
                        graph.get(i).add(j);
                    }
               }
           }

           boolean[]visisted = new boolean[node];
           int count = 0;
           for(int i=0;i<node;i++){
               if(visisted[i] == false){
                   dfsOfGraphHelper(graph,i,visisted);
                   count++;
               }
           }
           return count;
       }

        public static void dfsOfGraphHelper(List<List<Integer>> adj, int src, boolean[] vis){
            vis[src] = true;

            List<Integer> nbrs = adj.get(src);

            for(int v: nbrs){
                if(vis[v] == false){
                    dfsOfGraphHelper(adj, v, vis);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Two separate provinces
        System.out.println("Test Case 1: Two separate provinces");

        List<List<Integer>> adj1 = new ArrayList<>();
        adj1.add(new ArrayList<>(Arrays.asList(1, 1, 0)));
        adj1.add(new ArrayList<>(Arrays.asList(1, 1, 0)));
        adj1.add(new ArrayList<>(Arrays.asList(0, 0, 1)));

        int result1 = Solution.numProvinces(adj1, 3);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2");
        System.out.println();

        // Test Case 2: All cities connected (1 province)
        System.out.println("Test Case 2: All cities connected");

        List<List<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        adj2.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        adj2.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int result2 = Solution.numProvinces(adj2, 3);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");
        System.out.println();

        // Test Case 3: All cities isolated
        System.out.println("Test Case 3: All cities isolated");

        List<List<Integer>> adj3 = new ArrayList<>();
        adj3.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0)));
        adj3.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0)));
        adj3.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0)));
        adj3.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1)));

        int result3 = Solution.numProvinces(adj3, 4);
        System.out.println("Output: " + result3);
        System.out.println("Expected: 4");
        System.out.println();

        // Test Case 4: Complex case with 3 provinces
        System.out.println("Test Case 4: Complex case with 3 provinces");

        List<List<Integer>> adj4 = new ArrayList<>();
        adj4.add(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0)));
        adj4.add(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0)));
        adj4.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0)));
        adj4.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0)));
        adj4.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1)));

        int result4 = Solution.numProvinces(adj4, 5);
        System.out.println("Output: " + result4);
        System.out.println("Expected: 3");
    }
}