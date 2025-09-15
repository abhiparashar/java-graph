package graphs.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public static List<List<Integer>>createGraph(int nodes, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        return graph;
    }

    public static List<Integer>topoSortedBFS(int nodes, List<List<Integer>>graph){
        List<Integer>topo = new ArrayList<>();
        int[]indegree = new int[nodes];
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            for (int nbr:graph.get(i)){
                indegree[nbr]++;
            }
        }
        for (int i = 0; i < nodes; i++) {
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int rem = queue.poll();
            topo.add(rem);
            for (int nbr:graph.get(rem)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    queue.add(nbr);
                }
            }
        }
        return topo;
    }

    public static List<Integer>topoSortedDFS(int nodes, List<List<Integer>>graph){
        List<Integer>ans = new ArrayList<>();
        int[]indegree = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            for (int nbr : graph.get(i)){
                indegree[nbr]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test case 1: Valid DAG
        int nodes = 4;
        int[][] edges = {{1,0}, {2,0}, {3,1}, {3,2}};
        List<List<Integer>> graph = createGraph(nodes, edges);

        System.out.println("BFS Topo Sort: " + topoSortedBFS(nodes, graph));
        System.out.println("DFS Topo Sort: " + topoSortedDFS(nodes, graph));

        // Test case 2: Cycle detection
        int[][] cyclicEdges = {{0,1}, {1,2}, {2,0}};
        List<List<Integer>> cyclicGraph = createGraph(3, cyclicEdges);

        System.out.println("BFS with cycle: " + topoSortedBFS(3, cyclicGraph));
        System.out.println("DFS with cycle: " + topoSortedDFS(3, cyclicGraph));
    }
}
