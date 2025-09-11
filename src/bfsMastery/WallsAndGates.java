package bfsMastery;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static int[][] wallsAndGates(int[][]matrix){
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][]result = new int[rowCount][colCount];
        Queue<int[]>queue = new LinkedList<>();

        //create result matrix
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[i][j] =Integer.MAX_VALUE;
            }
        }

        //create the start point
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(matrix[i][j]==-1){
                    result[i][j]=-1;
                } else if (matrix[i][j]==0) {
                    result[i][j]=0;
                    queue.offer(new int[]{i,j,0});
                }
            }
        }

        while (!queue.isEmpty()){
            int[]rem = queue.poll();
            int row = rem[0];
            int col = rem[1];
            int distance = rem[2];

            //upward
            if(row-1>=0 && result[row-1][col]==Integer.MAX_VALUE){
                result[row-1][col] = distance+1;
                queue.offer(new int[]{row-1,col,distance+1});
            }

            //downward
            if(row+1<rowCount && result[row+1][col]==Integer.MAX_VALUE){
                result[row+1][col] = distance+1;
                queue.offer(new int[]{row+1,col,distance+1});
            }

            //left
            if(col-1>=0 && result[row][col-1]==Integer.MAX_VALUE){
                result[row][col-1] = distance+1;
                queue.offer(new int[]{row,col-1,distance+1});
            }

            //upward
            if(col+1<colCount && result[row][col+1]==Integer.MAX_VALUE){
                result[row][col+1] = distance+1;
                queue.offer(new int[]{row,col+1,distance+1});
            }
        }
        return result;
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

        int[][] res = wallsAndGates(rooms);

        System.out.println("After:");
        printRooms(res);
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
