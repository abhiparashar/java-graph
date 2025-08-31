package prac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversalPrac {
    public static List<List<Integer>>constructGraph(int n, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    };
    public static void BFS(List<List<Integer>>graph, int startNode){
        int n  = graph.size();
        Queue<Integer>queue = new LinkedList<>();
        queue.add(startNode);
        boolean[]visited = new boolean[n];
        visited[startNode] = true;
        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()){
            int current = queue.remove();
            System.out.print(current + " ");
            for (int neighbor :graph.get(current)){
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    };
    public static void main(String[] args) {
        int n = 5;
        int [][]edges = {{0,1}, {0,2}, {1,3}, {2,3}, {3,4}};
        List<List<Integer>>graph = constructGraph(n, edges);
        BFS(graph,0);
     }
}
