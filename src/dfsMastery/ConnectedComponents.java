package dfsMastery;

import java.util.*;

/*
Graph 1:
0 -- 1    3 -- 4
|         |
2         5

Components: {0,1,2} and {3,4,5} → Answer: 2

Graph 2:
0 -- 1 -- 2
     |
     3 -- 4

Components: {0,1,2,3,4} → Answer: 1
 */

public class ConnectedComponents {
    public static int countConnectedComponents(Map<Integer, List<Integer>>graph){
        Set<Integer>visited = new HashSet<>();
        int componentsCount = 0;
        Set<Integer>nodesSet = graph.keySet();
        for(int node:nodesSet){
            if(!visited.contains(node)){
                dfs(graph,visited,node);
                componentsCount++;
            }
        }
        return componentsCount;
    }

    private static void dfs(Map<Integer, List<Integer>>graph,Set<Integer>visited,int node){
        visited.add(node);
        for (int nbr:graph.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(nbr)){
                dfs(graph,visited,nbr);
            }
        }
    }
    public static void main(String[] args) {
        // Test Case 1: Two separate components
        System.out.println("=== Test Case 1: Two Components ===");
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(0, Arrays.asList(1, 2));  // Component 1: {0,1,2}
        graph1.put(1, Arrays.asList(0));
        graph1.put(2, Arrays.asList(0));
        graph1.put(3, Arrays.asList(4, 5));  // Component 2: {3,4,5}
        graph1.put(4, Arrays.asList(3));
        graph1.put(5, Arrays.asList(3));

        System.out.println("Components: " + countConnectedComponents(graph1)); // 2

        // Test Case 2: One big component
        System.out.println("\n=== Test Case 2: One Component ===");
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(1));     // All connected: {0,1,2,3,4}
        graph2.put(1, Arrays.asList(0, 2, 3));
        graph2.put(2, Arrays.asList(1));
        graph2.put(3, Arrays.asList(1, 4));
        graph2.put(4, Arrays.asList(3));

        System.out.println("Components: " + countConnectedComponents(graph2)); // 1

        // Test Case 3: All isolated nodes
        System.out.println("\n=== Test Case 3: Isolated Nodes ===");
        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        graph3.put(0, new ArrayList<>());    // Each node isolated
        graph3.put(1, new ArrayList<>());
        graph3.put(2, new ArrayList<>());

        System.out.println("Components: " + countConnectedComponents(graph3)); // 3

    }
}
