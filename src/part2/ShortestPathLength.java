package part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathLength {
    public static List<List<Integer>>createGraph(int nodes, int [][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge :edges ){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    public static int shortestPathLength(List<List<Integer>>graph, int start, int end){
        if(start==end) return 0;
        boolean[]visisted = new boolean[graph.size()];
        visisted[start] = true;
        Queue<Integer>queue = new LinkedList<>();
        queue.add(start);
        int level = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            level++;
            for (int i = 0; i < levelSize; i++) {
                int rem = queue.poll();
                for (int nbr : graph.get(rem)){
                    if(nbr==end){
                        return level;
                    }
                    if(!visisted[nbr]){
                        visisted[nbr] = true;
                        queue.offer(nbr);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Same graph as distance K problem
        int[][] edges = {
                {0, 1}, {0, 5}, {1, 2}, {2, 3}, {3, 4}, {3, 9},
                {5, 6}, {6, 7}, {7, 8}, {8, 9}
        };

        List<List<Integer>> graph = createGraph(10, edges);

        System.out.println("Graph: 0-1-2-3-4");
        System.out.println("       |       |");
        System.out.println("       5-6-7-8-9");

        int[][] testPairs = {{0, 4}, {0, 9}, {1, 7}, {5, 3}};

        for (int[] pair : testPairs) {
            int start = pair[0], end = pair[1];
            int length = shortestPathLength(graph, start, end);
            System.out.println("Shortest path " + start + " → " + end + ": " + length);
        }
        System.out.println();
    }
}
