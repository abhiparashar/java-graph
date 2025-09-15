package graphs.topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int nodes, int[][]courses){
       List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        //indegee arr
        for (int i = 0; i < nodes; i++) {
            graph.get(i).add();
        }

    };
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        // Test cases
        System.out.println(cs.canFinish(2, new int[][]{{1,0}})); // true
        System.out.println(cs.canFinish(2, new int[][]{{1,0},{0,1}})); // false
    }
}
