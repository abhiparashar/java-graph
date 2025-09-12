package dfsMastery;

import java.util.*;

public class AllPathsSourceTarget {
    public static List<List<Integer>>allPathsSourceTarget(Map<Integer, List<Integer>> graph, int src, int target){
       List<List<Integer>>result = new ArrayList<>();
       List<Integer>currentPath = new ArrayList<>();
       currentPath.add(src);
       dfs(graph,src,target,currentPath,result);
       return result;
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int src, int target,List<Integer>currentPath , List<List<Integer>>result){
        if(src==target){
            result.add(new ArrayList<>(currentPath));
        }
        for (int nbr: graph.getOrDefault(src,new ArrayList<>())){
            currentPath.add(nbr);
            dfs(graph,nbr,target,currentPath,result);
            currentPath.remove(currentPath.size()-1);
        }
    }
    public static void main(String[] args) {
        // Test case: DAG with multiple paths
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3, 4));
        graph.put(2, Arrays.asList(4));
        graph.put(3, new ArrayList<>());  // target node
        graph.put(4, Arrays.asList(3));

        List<List<Integer>> allPaths = allPathsSourceTarget(graph, 0, 3);

        System.out.println("All paths from 0 to 3:");
        for (int i = 0; i < allPaths.size(); i++) {
            System.out.println("Path " + (i+1) + ": " + allPaths.get(i));
        }

        // Expected Output:
        // Path 1: [0, 1, 3]
        // Path 2: [0, 1, 4, 3]
        // Path 3: [0, 2, 4, 3]
    }
}
