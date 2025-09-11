package bfsMastery;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static class Pair{
        int row;
        int col;
        int time;
        Pair(int  row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int totalTime(int[][]matrix){
        int ans = -1;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        Queue<Pair>queue = new LinkedList<>();
        int freshCount = 0;
        // Traverse the entire grid to find initial rotten and fresh oranges
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(matrix[i][j]==2){
                    queue.add(new Pair(i,j,0));
                } else if (matrix[i][j]==1) {
                    freshCount++;
                }
            }
        }
        if(freshCount==0) return 0;
        if(queue.isEmpty()) return -1;
        while (!queue.isEmpty()){
            Pair removed = queue.poll();
            int row = removed.row;
            int col = removed.col;
            int time = removed.time;
            ans = time;
            //upward direction
            if(row-1>=0 && matrix[row-1][col]==1){
                queue.offer(new Pair(row-1, col, time+1));
                matrix[row-1][col]=2;
            }

            //downward direction
            if(row+1<rowCount && matrix[row+1][col]==1){
                queue.offer(new Pair(row+1, col, time+1));
                matrix[row+1][col]=2;
            }

            //left direction
            if(col-1>=0 && matrix[row][col-1]==1){
                queue.offer(new Pair(row, col-1, time+1));
                matrix[row][col-1]=2;
            }

            //right direction;
            if(col+1<colCount && matrix[row][col+1]==1){
                queue.offer(new Pair(row, col+1, time+1));
                matrix[row][col+1]=2;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(matrix[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int time = totalTime(matrix);
        System.out.println(time);
    }
}