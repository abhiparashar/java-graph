package part2;


import java.util.*;

// Test case:
// Graph: 0-1-2, 0-3-4-5, 2-5 (same as before)
// bfsWithDistance(graph, 0) → should return:
// {0=0, 1=1, 3=1, 2=2, 4=2, 5=3} or similar

public class BfsWithDistance {
    public static List<List<Integer>> createGraph(int nodes, int[][]edges){
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
    public static Map<Integer,Integer>calculateDistance(List<List<Integer>>graph, int src){
        Map<Integer, Integer>map = new HashMap<>();
        Queue<Integer>queue = new LinkedList<>();
        boolean[]visited = new boolean[graph.size()];
        int distance = 0;
        map.put(src, distance);
        queue.offer(src);
        visited[src] = true;
        while (!queue.isEmpty()){
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                int rem = queue.poll();
                for (int nbr:graph.get(rem)){
                    if(!visited[nbr]){
                        map.put(nbr,distance+1);
                        visited[nbr] = true;
                        queue.offer(nbr);
                    }
                }
            }
            distance++;
        }
        return map;
    };
    public static void main(String[] args) {
        int nodes = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5}
        };
        List<List<Integer>>graph = createGraph(nodes, edges);
        int src = 0;
        Map<Integer,Integer>distanceMap = calculateDistance(graph,src);
        System.out.println(distanceMap);
    }
}
