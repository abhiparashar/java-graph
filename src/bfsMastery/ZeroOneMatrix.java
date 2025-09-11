package bfsMastery;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public static int[][] updateMatrix(int[][]matrix){
        int rowsCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] result = new int[rowsCount][colCount];
        Queue<int[]>queue = new LinkedList<>();
        // Create result matrix
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colCount; j++) {
               result[i][j] = -1;
            }
        }

        //check matrix
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(matrix[i][j]==0){
                    queue.offer(new int[]{i,j,0});
                    result[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            //upward direction
            if(row-1>=0 && result[row-1][col]==-1){
                queue.offer(new int[]{row-1, col, distance+1});
                result[row-1][col] = distance+1;
            }

            //downward direction
            if(row+1<rowsCount && result[row+1][col]==-1){
                queue.offer(new int[]{row+1, col, distance+1});
                result[row+1][col] = distance+1;
            }

            //left direction
            if(col-1>=0 && result[row][col-1]==-1){
                queue.offer(new int[]{row, col-1, distance+1});
                result[row][col-1] = distance+1;
            }

            //Right direction
            if(col+1<colCount && result[row][col+1]==-1){
                queue.offer(new int[]{row, col+1, distance+1});
                result[row][col+1] = distance+1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        // Test case 1
        int[][] matrix1 = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] result1 = updateMatrix(matrix1);
        System.out.println("Test 1:");
        printMatrix(result1);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
