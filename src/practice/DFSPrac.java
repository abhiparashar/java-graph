package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSPrac {
    public static List<List<Integer>>buildGraph(int node, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < node; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    };

    public static List<Integer> dfsOfGraph(int node, List<List<Integer>>graph){
        List<Integer>ans = new ArrayList<>();
        boolean[]visited = new boolean[node];
        dfsOfGraphHelper(graph,0,visited,ans);
        return ans;
    };

    private static void dfsOfGraphHelper(List<List<Integer>>graph, int src, boolean[]visited, List<Integer>ans){
        visited[src] = true;
        ans.add(src);
        for (Integer neighbor:graph.get(src)){
            if(!visited[neighbor]){
                dfsOfGraphHelper(graph,neighbor,visited,ans);
            }
        }
    };

    public static void main(String[] args) {
        // Test Case 1: Simple Linear Graph
        System.out.println("Test Case 1: Simple Linear Graph");
        System.out.println("Graph: 0 --- 1 --- 2 --- 3");

        int[][] edges1 = {{0,1}, {1,2}, {2,3}};
        List<List<Integer>> adj1 = buildGraph(4, edges1);

        List<Integer> result1 = DFSPrac.dfsOfGraph(4, adj1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: [0, 1, 2, 3]");
        System.out.println();

        // Test Case 2: Tree Structure
        System.out.println("Test Case 2: Tree Structure");
        System.out.println("Graph:");
        System.out.println("    0");
        System.out.println("   / \\");
        System.out.println("  1   2");
        System.out.println(" / \\");
        System.out.println("3   4");

        int[][] edges2 = {{0,1}, {0,2}, {1,3}, {1,4}};
        List<List<Integer>> adj2 = buildGraph(5, edges2);

        List<Integer> result2 = DFSPrac.dfsOfGraph(5, adj2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: [0, 1, 3, 4, 2]");
        System.out.println();

        // Test Case 3: Connected Graph with Cycles
        System.out.println("Test Case 3: Connected Graph with Cycles");
        System.out.println("Graph:");
        System.out.println("  0 --- 1 --- 2");
        System.out.println("  |   / |   /");
        System.out.println("  |  /  |  /");
        System.out.println("  | /   | /");
        System.out.println("  4 --- 3");

        int[][] edges3 = {{0,1}, {0,4}, {1,2}, {1,3}, {1,4}, {2,3}, {3,4}};
        List<List<Integer>> adj3 = buildGraph(5, edges3);

        List<Integer> result3 = DFSPrac.dfsOfGraph(5, adj3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: [0, 1, 2, 3, 4]");

    }
}