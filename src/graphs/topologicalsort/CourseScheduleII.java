package graphs.topologicalsort;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CourseScheduleII {
    private static List<List<Integer>>createGraph(int nodes, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]edge : edges){
            int course = edge[0];
            int prerequisite = edge[1];
            graph.get(prerequisite).add(course);
        }
        return graph;
    }

    public static List<Integer>findOrder(int nodes, int[][]edges){
        List<List<Integer>>graph = createGraph(nodes,edges);
        List<Integer>result = new ArrayList<>();
        int[]colors = new int[nodes];
        for (int i = 0; i < nodes; i++) {
           if(colors[i]==0){
               if(hasCycle(i,graph,colors,result)){
                   return new ArrayList<>();
               }
           }
        }
        Collections.reverse(result);
        return result;
    }

    private static boolean hasCycle(int i, List<List<Integer>>graph, int[]colors, List<Integer>result){
        colors[i] = 1;
        for (int nbr : graph.get(i)){
            if(colors[nbr]==1) return true;
            if(colors[nbr]==0 && hasCycle(nbr,graph,colors,result)){
                return true;
            }
        }
        colors[i] = 2;
        result.add(i);
        return false;
    }

    public static void main(String[] args) {
        // Test case 1: Basic case
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Test 1: " + findOrder(numCourses1, prerequisites1));
        // Expected: [0, 1]

        // Test case 2: Complex valid case
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Test 2: " + findOrder(numCourses2, prerequisites2));
        // Expected: [0, 1, 2, 3] or [0, 2, 1, 3]

        // Test case 3: Cycle case
        int numCourses3 = 2;
        int[][] prerequisites3 = {{1, 0}, {0, 1}};
        System.out.println("Test 3: " + findOrder(numCourses3, prerequisites3));
        // Expected: []

        // Test case 4: No prerequisites
        int numCourses4 = 3;
        int[][] prerequisites4 = {};
        System.out.println("Test 4: " + findOrder(numCourses4, prerequisites4));
        // Expected: [0, 1, 2] or any permutation

        // Test case 5: Complex cycle
        int numCourses5 = 3;
        int[][] prerequisites5 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Test 5: " + findOrder(numCourses5, prerequisites5)  );
        // Expected: []
    }
}
