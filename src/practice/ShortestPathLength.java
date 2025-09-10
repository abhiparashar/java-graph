package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// shortestPathLength(graph, 0, 5) → should return 3
// shortestPathLength(graph, 0, 2) → should return 2
// shortestPathLength(graph, 0, 6) → should return -1 (unreachable)
// shortestPathLength(graph, 0, 0) → should return 0 (same node)

public class ShortestPathLength {
    public static List<List<Integer>>createGraph(int nodes, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    public static int shortestPathLength(List<List<Integer>>graph, int start, int target){
        if(start==target) return 0;
        int ans = -1;
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(start);
        boolean[]visited = new boolean[graph.size()];
        visited[start] = true;
        int distance = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            distance++;
            for (int i = 0; i < levelSize; i++) {
                int rem = queue.poll();
                for (int nbr:graph.get(rem) ){
                    if(!visited[nbr]){
                        if(nbr==target){
                            return distance;
                        }
                        visited[nbr] = true;
                        queue.offer(nbr);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nodes = 6;
        int[][] edges = {
                {0, 1}, {1, 2}, {0, 3}, {3, 4}, {4, 5}, {2, 5}
        };
        List<List<Integer>>graph = createGraph(nodes,edges);
        int shortestPath = shortestPathLength(graph,0,0);
        System.out.println(shortestPath);
    }
}
