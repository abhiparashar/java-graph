package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsTraversal {
    public static List<List<Integer>>createGraph(int nodes, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int []edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    public static List<Integer>graphTraversal(List<List<Integer>>graph, int src){
        List<Integer>ans = new ArrayList<>();
        boolean[]visited = new boolean[graph.size()];
        visited[src] = true;
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(src);
        while (!queue.isEmpty()){
            int rem = queue.poll();
            ans.add(rem);
            for (int nbr : graph.get(rem)){
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
        int src = 0;
        List<List<Integer>>graph = createGraph(nodes, edges);
        System.out.println(graph);
        List<Integer>traveredGraph = graphTraversal(graph,src);
        for (int i = 0; i < traveredGraph.size(); i++) {
            System.out.println(traveredGraph.get(i));
        }
    }
}
