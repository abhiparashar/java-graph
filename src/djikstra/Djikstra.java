package djikstra;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Djikstra{
    public static class Pair implements Comparable<Pair>{
        int vtx;
        int wt;
        Pair(int vtx, int wt){
            this.vtx= vtx;
            this.wt = wt;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return this.wt - o.wt;
        }
    }

    public static List<List<List<Integer>>>buildGraph(int nodes, int[][]edges){
        List<List<List<Integer>>>graph  = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new ArrayList<>(Arrays.asList(v,w)));
            graph.get(v).add(new ArrayList<>(Arrays.asList(u,w)));
        }
        return graph;
    }

    public static int[] dijkstra(int nodes,List<List<List<Integer>>>graph, int src){
        int[]ans = new int[nodes];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while (!pq.isEmpty()){
           Pair rem = pq.poll();
           if(ans[rem.vtx] != Integer.MAX_VALUE) continue;
           ans[rem.vtx] = rem.wt;
           for (List<Integer>neighbor : graph.get(rem.vtx)){
                int nbr = neighbor.get(0);
                int wt = neighbor.get(1);
                if(ans[nbr] != Integer.MAX_VALUE) continue;
                pq.add(new Pair(nbr,rem.wt+wt));
           }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nodes = 3;
        int[][] edges = {
                {0, 1, 2},  // edge from 0 to 1 with weight 2
                {0, 2, 5},  // edge from 0 to 2 with weight 5
                {1, 2, 1}   // edge from 1 to 2 with weight 1
        };

        List<List<List<Integer>>>graph = buildGraph(nodes,edges);

        int[] result0 = dijkstra(3, graph, 0);
        int[] result1 = dijkstra(3, graph, 1);
        int[] result2 = dijkstra(3, graph, 2);

        System.out.println(Arrays.toString(result0));
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));

    }
}
