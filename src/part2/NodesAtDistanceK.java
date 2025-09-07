package part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodesAtDistanceK {
    public static List<List<Integer>>createGraph(int nodes, int [][]edges){
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

    public static List<Integer> findNodesAtDistanceK(List<List<Integer>>graph, int src, int k){
        List<Integer>ans = new ArrayList<>();
        if (k == 0) {
            ans.add(src);
            return ans;
        }
        boolean[]visited = new boolean[graph.size()];
        visited[src] = true;
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(src);
        int currentDistance = 0;
        while (!queue.isEmpty() && currentDistance<k){
            int levelSize = queue.size();
            currentDistance++;
            for (int i = 0; i < levelSize; i++) {
                int rem = queue.poll();
                for (int nbr:graph.get(rem)){
                    if(!visited[nbr]){
                        visited[nbr] = true;
                        queue.offer(nbr);
                        if (currentDistance == k) {
                            ans.add(nbr);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Graph: 0-1-2-3-4
        //        |       |
        //        5-6-7-8-9
        int[][] edges = {
                {0, 1}, {0, 5}, {1, 2}, {2, 3}, {3, 4}, {3, 9},
                {5, 6}, {6, 7}, {7, 8}, {8, 9}
        };
        List<List<Integer>> graph = createGraph(10, edges);
        for (int k = 0; k <= 4; k++) {
            List<Integer> nodes = findNodesAtDistanceK(graph, 0, k);
            System.out.println("Distance " + k + " from 0: " + nodes);
        }
        System.out.println();
    }
}
