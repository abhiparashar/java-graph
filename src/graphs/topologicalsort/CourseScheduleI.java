package graphs.topologicalsort;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {
    private static List<List<Integer>>createGraph(int nodes, int[][]edges){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[]edge:edges){
            int course = edge[0];
            int prerequisite = edge[1];
            graph.get(prerequisite).add(course);
        }
        return graph;
    }


    public static boolean canFinish(int numCourses, int[][]prerequisites){
        List<List<Integer>>graph = createGraph(numCourses, prerequisites);
        int[]colors = new int[numCourses];
        for (int i = 0; i <numCourses ; i++) {
            if(colors[i]==0){
                if(hasCycle(i, graph, colors)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasCycle(int i, List<List<Integer>>graph, int[]colors){
        colors[i] = 1;

        for (int nbr : graph.get(i)){
            if(colors[nbr]==1) return true;
            if(colors[nbr]==0 && hasCycle(nbr,graph,colors)){
                return true;
            }
        }

        colors[i] = 2;
        return false;
    }

    public static void main(String[] args) {
        // Test case 1: Can finish
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Test 1 - Can finish: " + canFinish(numCourses1, prerequisites1));
        // Expected: true (0 → 1)

        // Test case 2: Cannot finish (cycle)
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Test 2 - Can finish: " + canFinish(numCourses2, prerequisites2));
        // Expected: false (0 ↔ 1 cycle)

        // Test case 3: Complex valid case
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Test 3 - Can finish: " + canFinish(numCourses3, prerequisites3));
        // Expected: true (0 → 1,2 → 3)

        // Test case 4: Complex cycle
        int numCourses4 = 3;
        int[][] prerequisites4 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Test 4 - Can finish: " + canFinish(numCourses4, prerequisites4));
        // Expected: false (0 → 1 → 2 → 0 cycle)

        // Test case 5: No prerequisites
        int numCourses5 = 3;
        int[][] prerequisites5 = {};
        System.out.println("Test 5 - Can finish: " + canFinish(numCourses5, prerequisites5));
        // Expected: true (no dependencies)
    }
}
