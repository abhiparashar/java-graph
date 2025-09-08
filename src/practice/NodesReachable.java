package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodesReachable {
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
    public static boolean isReachable(List<List<Integer>>graph, int src, int target){
        boolean ans = false;
        if(src<0 || src >= graph.size() || target <0 || target>=graph.size()) return false;
        if(src==target) return true;
        Queue<Integer>queue = new LinkedList<>();
        queue.add(src);
        boolean[]visited = new boolean[graph.size()];
        visited[src] = true;
        while (!queue.isEmpty()){
            int rem = queue.poll();
            for (int nbr: graph.get(rem)){
                if(nbr==target){
                    return true;
                }
                if(!visited[nbr]){
                    visited[nbr] = true;
                    queue.offer(nbr);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nodes = 6;
        int [][]edges = {{0,1},{1,2},{0,3},{3,4},{4,5},{2,5}};
        List<List<Integer>>graph = createGraph(nodes, edges);
        System.out.println(isReachable(graph, 0, 5)); // true
        System.out.println(isReachable(graph, 0, 6)); // false (node 6 doesn't exist)
        System.out.println(isReachable(graph, 1, 4)); // true
    }
}
