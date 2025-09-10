package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Test cases:
// Graph: 0-1-2, 0-3-4-5, 2-5 (same as before)
// isReachableWithinK(graph, 0, 5, 3) → should return true (distance is 3)
// isReachableWithinK(graph, 0, 5, 2) → should return false (distance is 3, not ≤ 2)
// isReachableWithinK(graph, 0, 2, 3) → should return true (distance is 2)
public class IsReachableWithinK {
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

    public static boolean isReachable(List<List<Integer>>graph, int src, int target, int steps){
        if(src==target) return true;
        boolean ans = false;
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(src);
        boolean[]visited = new boolean[graph.size()];
        visited[src] = true;
        int distance = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            distance++;
            if (distance > steps) break;
            for (int i = 0; i < levelSize; i++) {
                int rem = queue.poll();
                for(int nbr:graph.get(rem)){
                    if(nbr==target && distance<=steps){
                        return true;
                    }
                    if(!visited[nbr]){
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
        List<List<Integer>>graph = createGraph(nodes, edges);
        boolean ans = isReachable(graph,0,2,3);
        System.out.println(ans);
    }
}
