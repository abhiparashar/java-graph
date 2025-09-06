package practice;

import java.util.ArrayList;
import java.util.List;

public class DijkstraPrac {
    public static List<List<List<Integer>>>createGarph(int nodes, int[][]edges){
        List<List<List<Integer>>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[]edge:edges){

        }
        return graph;
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
    }
}
