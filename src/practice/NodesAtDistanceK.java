package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodesAtDistanceK {
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

    public static List<Integer>calculateDistK(List<List<Integer>>graph, int start, int k){
        List<Integer>ans = new ArrayList<>();
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(start);
        boolean[]visited = new boolean[graph.size()];
        visited[start] = true;
        if(k==0){
            ans.add(start);
        }
        int distance = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            distance++;
            for (int i = 0; i < levelSize; i++) {
                int rem = queue.poll();
                for (int nbr:graph.get(rem)){
                    if(!visited[nbr]){
                        visited[nbr] = true;
                        queue.offer(nbr);
                        if(distance==k){
                            ans.add(nbr);
                        }
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nodes = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5}
        };
        List<List<Integer>>graph = createGraph(nodes, edges);
        List<Integer>nodesAtdistk = calculateDistK(graph,0, 2);
        System.out.println(nodesAtdistk);
    }
}
