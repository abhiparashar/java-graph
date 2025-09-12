package dfsMastery;

import java.util.*;

/*
0 -> [1, 2]
1 -> [0, 3, 4]
2 -> [0, 4]
3 -> [1]
4 -> [1, 2]
 */

public class DFSTraversal {
    public static List<Integer>traverseGraph(Map<Integer, List<Integer>>graph, int start){
        Set<Integer>visited = new HashSet<>();
        List<Integer>result = new ArrayList<>();
        dfs(graph,start,visited,result);
        return result;
    }

    private static void dfs(Map<Integer, List<Integer>>graph, int node,Set<Integer>visited, List<Integer>result){
        visited.add(node);
        result.add(node);
        for(int nbr : graph.get(node)){
            if(!visited.contains(nbr)){
                dfs(graph,nbr,visited,result);
            }
        }
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>>graph = new HashMap<>();
        graph.put(0, Arrays.asList(1,2));
        graph.put(1,Arrays.asList(0,3,4));
        graph.put(2,Arrays.asList(0,4));
        graph.put(3,Arrays.asList(1));
        graph.put(4,Arrays.asList(1,2));

        List<Integer>result = traverseGraph(graph,0);
        System.out.println(result);
    }
}
