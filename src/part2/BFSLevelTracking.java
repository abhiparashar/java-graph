package part2;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSLevelTracking {
    public static List<List<Integer>>createGraph(int nodes, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    public static void bfsWithLevels(List<List<Integer>>graph, int src){
        Queue<Integer>queue = new LinkedList<>();
        boolean[]visited = new boolean[graph.size()];
        visited[src] = true;
        queue.offer(src);
        int level = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            System.out.println("Level " + level + " has " + levelSize + " nodes:");
            for (int i = 0; i < levelSize; i++) {
                int rem = queue.poll();
                for (int nbr:graph.get(rem)){
                    if(!visited[nbr]){
                        visited[nbr] = true;
                        queue.offer(nbr);
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5}
        };

        List<List<Integer>> graph = createGraph(6, edges);

        System.out.println("=== BFS WITH LEVEL TRACKING ===");
        System.out.println("Graph: 0-1-3");
        System.out.println("       |   |");
        System.out.println("       2-4-5");
        System.out.println("Tracking levels from node 0:");
        bfsWithLevels(graph, 0);
        System.out.println();
    }
}
