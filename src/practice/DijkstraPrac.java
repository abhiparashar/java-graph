package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraPrac {
    public static List<List<List<Integer>>>createGarph(int nodes, int[][]edges){
        List<List<List<Integer>>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph.get(u).add(new ArrayList<>(Arrays.asList(v,wt)));
        }
        return graph;
    };

    public static class Pair implements Comparable<Pair>{
        int vtx;
        int wt;
        Pair(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static int[] dijkstra(int nodes, List<List<List<Integer>>>graph, int src){
        int[] result = new int[nodes];
        Arrays.fill(result,Integer.MAX_VALUE);
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while (!pq.isEmpty()){
            Pair rm = pq.remove();
            if(result[rm.vtx] != Integer.MAX_VALUE) continue;
            result[rm.vtx] = rm.wt;
            for (List<Integer>neibhor:graph.get(rm.vtx)){
                int nbr = neibhor.get(0);
                int wt = neibhor.get(1);
                if(result[nbr] != Integer.MAX_VALUE) continue;
                pq.add(new Pair(nbr,rm.wt+wt));
            }
        }
        return result;
    };

    public static void main(String[] args) {
        int nodes = 7;
        int[][] edges = {
                {0, 1, 20},  // 0 -> 1 (weight 20)
                {0, 3, 10},  // 0 -> 3 (weight 10)
                {1, 2, 28},  // 1 -> 2 (weight 28)
                {2, 5, 25},  // 2 -> 5 (weight 25)
                {2, 3, 40},  // 2 -> 3 (weight 40)
                {3, 4, 50},  // 3 -> 4 (weight 50)
                {4, 5, 30},  // 4 -> 5 (weight 30)
                {4, 6, 60},  // 4 -> 6 (weight 60)
                {5, 6, 30}   // 5 -> 6 (weight 30)
        };

        List<List<List<Integer>>>graph = createGarph(nodes, edges);
        System.out.println(graph);
        int src = 0;
        int[]result = dijkstra(nodes,graph,src);

        // Print results
        System.out.println("Shortest distances from vertex " + src + ":");
        for (int i = 0; i < nodes; i++) {
            if(result[i] == Integer.MAX_VALUE) {
                System.out.println("To vertex " + i + ": INF (unreachable)");
            } else {
                System.out.println("To vertex " + i + ": " + result[i]);
            }
        }
    }
}
