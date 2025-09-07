package part2;

import java.util.*;

public class BasicBFS {
    public static List<List<Integer>>createGraph(int nodes, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    public static List<Integer> bfs(int nodes, List<List<Integer>>graph, int src){
        List<Integer>ans = new ArrayList<>();
        Queue<Integer>queue = new LinkedList<>();
        queue.add(src);
        boolean[] visited = new boolean[nodes];
        visited[src] = true;
        while (!queue.isEmpty()){
            int rem = queue.poll();
            ans.add(rem);
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
        // Graph: 0-1-3
        //        |   |
        //        2-4-5
        int nodes = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5}
        };

        List<List<Integer>> graph = createGraph(nodes, edges);
        System.out.println("BFS from 0: " + bfs(nodes,graph, 0));
        System.out.println();
    }
}