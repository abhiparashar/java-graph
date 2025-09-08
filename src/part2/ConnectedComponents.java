package part2;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
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
    public static void printGraph(List<List<Integer>>graph){
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(graph.get(i));
        }
    }
    public static int countComponents(List<List<Integer>>graph){
        int ans = 0;
        for (int i = 0; i < graph.size(); i++) {
            traverseGraph(graph, i);
            ans++;
        }
        return ans;
    }
    private static void traverseGraph(List<List<Integer>>graph, int src){

    }
    public static void main(String[] args) {
        // Disconnected graph: 0-1-2  and  3-4  and  5
        int[][] edges = {
                {0, 1}, {1, 2}, {3, 4}
        };

        List<List<Integer>> graph = createGraph(6, edges);
        printGraph(graph);
//        System.out.println("Number of components: " + countComponents(graph)); // 3
        System.out.println();
    }
}
