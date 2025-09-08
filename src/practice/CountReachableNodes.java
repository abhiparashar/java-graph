package practice;

// Test case:
// Graph: 0-1-2, 0-3-4-5, 2-5 (same as before)
// countReachableNodes(graph, 0) → should return 6 (all nodes reachable)
//
// Disconnected graph: 0-1, 2-3 (separate components)
// countReachableNodes(graph, 0) → should return 2 (only 0 and 1)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountReachableNodes {
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
    public static int countReachableNodes(List<List<Integer>>graph, int src){
        int ans = 0;
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(src);
        boolean[]visited = new boolean[graph.size()];
        visited[src] = true;
        while (!queue.isEmpty()){
            int rem = queue.poll();
            ans++;
            for (int nbr:graph.get(rem)){
                if(!visited[nbr]){
                    visited[nbr] = true;
                    queue.offer(nbr);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        int nodes = 6;
//        int [][]edges = {{0,1},{1,2},{0,3},{3,4},{4,5},{2,5}};
        int nodes = 4;
        int [][]edges = {{0,1},{2,3}};
        List<List<Integer>>graph = createGraph(nodes, edges);
        int totalcount = countReachableNodes(graph, 0);
        System.out.println(totalcount);
    }
}
