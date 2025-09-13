package dfsMastery;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][]prerequisites){
        List<List<Integer>>graph = createGraph(numCourses, prerequisites);

        int[] colors = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if(colors[course]==0){
                if(hasCycle(graph,course,colors)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasCycle(List<List<Integer>>graph, int course, int[] colors){
        colors[course] = 1;

        for (int nbr: graph.get(course)){
            if(colors[nbr]==1){
                return true;
            }

            if(colors[nbr]==0 && hasCycle(graph,nbr, colors)){
                return true;
            }
        }

        colors[course] = 2;
        return false;
    }

    private static List<List<Integer>>createGraph(int numCourses, int[][]prerequisites){
        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites){
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
        }
        return graph;
    }
    public static void main(String[] args) {
        System.out.println("🎓 Course Schedule Problem - Cycle Detection\n");

        // Test Case 1: Simple valid schedule
        System.out.println("=== Test Case 1: Valid Schedule ===");
        int[][] prereq1 = {{1,0}};  // Course 1 requires Course 0
        System.out.println("Prerequisites: Course 1 needs Course 0");
        System.out.println("Can finish all courses: " + canFinish(2, prereq1)); // Expected: true
        System.out.println("Explanation: Take Course 0 first, then Course 1\n");

        // Test Case 2: Simple cycle (impossible)
        System.out.println("=== Test Case 2: Circular Dependency ===");
        int[][] prereq2 = {{1,0},{0,1}};  // Course 1 needs 0, Course 0 needs 1
        System.out.println("Prerequisites: Course 1 needs Course 0, Course 0 needs Course 1");
        System.out.println("Can finish all courses: " + canFinish(2, prereq2)); // Expected: false
        System.out.println("Explanation: Circular dependency - impossible!\n");

        // Test Case 3: Complex graph with cycle
        System.out.println("=== Test Case 3: Complex Cycle ===");
        int[][] prereq3 = {{1,0},{2,1},{3,2},{1,3}};  // 0→1→3→2→1 (cycle!)
        System.out.println("Prerequisites: 0→1, 1→2, 2→3, 3→1");
        System.out.println("Can finish all courses: " + canFinish(4, prereq3)); // Expected: false
        System.out.println("Explanation: Cycle detected: 1→3→2→1\n");

        // Test Case 4: Complex valid DAG
        System.out.println("=== Test Case 4: Complex Valid Schedule ===");
        int[][] prereq4 = {{1,0},{2,0},{3,1},{3,2}};  // Valid DAG
        System.out.println("Prerequisites: 0→1, 0→2, 1→3, 2→3");
        System.out.println("Can finish all courses: " + canFinish(4, prereq4)); // Expected: true
        System.out.println("Explanation: Valid order: 0 → (1,2) → 3\n");

        // Test Case 5: No prerequisites
        System.out.println("=== Test Case 5: Independent Courses ===");
        int[][] prereq5 = {};
        System.out.println("Prerequisites: None");
        System.out.println("Can finish all courses: " + canFinish(3, prereq5)); // Expected: true
        System.out.println("Explanation: All courses are independent");
    }
}
