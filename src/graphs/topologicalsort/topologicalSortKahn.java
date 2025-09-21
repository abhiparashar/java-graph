package graphs.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topologicalSortKahn {

    public static List<List<Integer>>createGraph(int nodes, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        return graph;
    }

    public static List<Integer>topologicalSortKahn(int nodes, int[][]edges){
        List<Integer>result=  new ArrayList<>();
        List<List<Integer>>graph = createGraph(nodes, edges);
        int[] inDegree = new int[nodes];
        Queue<Integer>queue = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            for (int nbr : graph.get(i)){
                inDegree[nbr]++;
            }
        }
        for (int i = 0; i < nodes; i++) {
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int rem = queue.poll();
            result.add(rem);
            for (int nbr : graph.get(rem)){
                inDegree[nbr]--;
                if(inDegree[nbr]==0){
                    queue.offer(nbr);
                }
            }
        }

        if(result.size() != nodes){
            return new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Kahn's Algorithm ===");

        // Test Case 1: Valid DAG
        int[][] edges1 = {{1,0},{2,0},{3,1},{3,2}};
        List<Integer> result1 = topologicalSortKahn(4, edges1);
        System.out.println("Test 1: " + result1);
        System.out.println("Expected: [3,1,2,0] or [3,2,1,0]");

        // Test Case 2: Cycle detection
        int[][] edges2 = {{1,0},{0,1}};
        List<Integer> result2 = topologicalSortKahn(2, edges2);
        System.out.println("Test 2: " + result2);
        System.out.println("Expected: [] (empty - cycle detected)");

        // Test Case 3: Simple linear order
        int[][] edges3 = {{0,1},{0,2}};
        List<Integer> result3 = topologicalSortKahn(3, edges3);
        System.out.println("Test 3: " + result3);
        System.out.println("Expected: [0,1,2] or [0,2,1]");

        // Test Case 4: Single node
        int[][] edges4 = {};
        List<Integer> result4 = topologicalSortKahn(1, edges4);
        System.out.println("Test 4: " + result4);
        System.out.println("Expected: [0]");

        // Test Case 5: Chain
        int[][] edges5 = {{0,1},{1,2},{2,3}};
        List<Integer> result5 = topologicalSortKahn(4, edges5);
        System.out.println("Test 5: " + result5);
        System.out.println("Expected: [0,1,2,3]");

    }
}
