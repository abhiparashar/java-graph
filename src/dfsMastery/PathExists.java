package dfsMastery;

import java.util.*;

public class PathExists {
    public static boolean pathExists(Map<Integer, List<Integer>> graph, int src, int target){
        if(src==target) return true;
        Set<Integer>visited = new HashSet<>();
        return dfs(graph,visited,src,target);
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer>visited, int src, int target){
        visited.add(src);
        for (int nbr:graph.get(src)){
            if(nbr==target){
                return true;
            }
            if(!visited.contains(nbr)){
               if(dfs(graph,visited,nbr,target)){
                    return true;
               }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1,2));
        graph.put(1,Arrays.asList(0,3,4));
        graph.put(2,Arrays.asList(0,4));
        graph.put(3,Arrays.asList(1));
        graph.put(4,Arrays.asList(1,2));

        // Test different paths
        System.out.println("Path 0→3: " + pathExists(graph, 0, 3)); // true
        System.out.println("Path 3→2: " + pathExists(graph, 3, 2)); // true
        System.out.println("Path 0→5: " + pathExists(graph, 0, 5)); // false
        System.out.println("Path 2→3: " + pathExists(graph, 2, 3)); // true
    }
}
