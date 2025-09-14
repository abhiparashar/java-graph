package djikstra;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static class Pair implements Comparable<Pair>{
        int vtx, wt;
        Pair(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return this.wt - o.wt;
        }
    }

    public static List<List<List<Integer>>> createGraph(int n,int[][]times1){
        List<List<List<Integer>>>graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge : times1){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new ArrayList<>(Arrays.asList(v,w)));
        }
        return graph;
    }

    public static int networkDelayTime(List<List<List<Integer>>>graph, int n, int k){
        int maxTime = 0;
        int[]ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while (!pq.isEmpty()){
            Pair rem = pq.poll();
            if(ans[rem.vtx] != Integer.MAX_VALUE) continue;
            ans[rem.vtx] = rem.wt;
            for (List<Integer>nbr : graph.get(rem.vtx)){
                int vtx = nbr.get(0);
                int wt = nbr.get(1);
                if(ans[vtx] != Integer.MAX_VALUE) continue;
                pq.add(new Pair(vtx, wt+rem.wt));
            }
        }
        for (int i = 1; i <= n; i++) {
            if(ans[i]==Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime,ans[i]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] times1 = {{2,1,1},{2,3,1},{3,4,1}};
        int n1 = 4, k1 = 2;
        List<List<List<Integer>>>graph1 = createGraph(n1,times1);
        System.out.println("Test 1: " + networkDelayTime(graph1, n1, k1)); // Expected: 2

        // Test case 2
        int[][] times2 = {{1,2,1}};
        int n2 = 2, k2 = 1;
        List<List<List<Integer>>>graph2 = createGraph(n2,times2);
        System.out.println("Test 2: " + networkDelayTime(graph2, n2, k2)); // Expected: 1

        // Test case 3 - Unreachable case
        int[][] times3 = {{1,2,1}};
        int n3 = 2, k3 = 2;
        List<List<List<Integer>>>graph3 = createGraph(n3,times3);
        System.out.println("Test 3: " + networkDelayTime(graph3, n3, k3)); // Expected: -1
    }
}
