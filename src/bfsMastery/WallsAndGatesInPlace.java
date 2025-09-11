package bfsMastery;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGatesInPlace {
    public static void wallsAndGates(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Find all gates and add to queue - no separate result matrix needed!
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == 0) {  // Gate found
                    queue.offer(new int[]{i, j, 0});
                }
                // Walls (-1) and empty rooms (INF) stay as they are initially
            }
        }

        while (!queue.isEmpty()) {
            int[] rem = queue.poll();
            int row = rem[0];
            int col = rem[1];
            int distance = rem[2];

            // Upward
            if (row - 1 >= 0 && matrix[row - 1][col] == Integer.MAX_VALUE) {
                matrix[row - 1][col] = distance + 1;  // Direct modification!
                queue.offer(new int[]{row - 1, col, distance + 1});
            }

            // Downward
            if (row + 1 < rowCount && matrix[row + 1][col] == Integer.MAX_VALUE) {
                matrix[row + 1][col] = distance + 1;  // Direct modification!
                queue.offer(new int[]{row + 1, col, distance + 1});
            }

            // Left
            if (col - 1 >= 0 && matrix[row][col - 1] == Integer.MAX_VALUE) {
                matrix[row][col - 1] = distance + 1;  // Direct modification!
                queue.offer(new int[]{row, col - 1, distance + 1});
            }

            // Right
            if (col + 1 < colCount && matrix[row][col + 1] == Integer.MAX_VALUE) {
                matrix[row][col + 1] = distance + 1;  // Direct modification!
                queue.offer(new int[]{row, col + 1, distance + 1});
            }
        }
    }

    public static void main(String[] args) {
        // Test case
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        System.out.println("Before:");
        printRooms(rooms);

        wallsAndGates(rooms);  // In-place modification!

        System.out.println("After:");
        printRooms(rooms);
    }

    public static void printRooms(int[][] rooms) {
        for (int[] row : rooms) {
            for (int val : row) {
                if (val == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.printf("%3d ", val);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}