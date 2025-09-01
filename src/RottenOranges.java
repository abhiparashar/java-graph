import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    // Class to store position and time of each orange
    public static class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][]grid){
        int m = grid.length; // Number of rows
        int n = grid[0].length; // Number of columns

        Queue<Pair>queue = new LinkedList<>();
        int count1 = 0; // Count of fresh oranges (value = 1)
        int count2 = 0; // Count of rotten oranges (value = 2)
        int ans = -1;   // Store the maximum time taken

        // Traverse the entire grid to find initial rotten and fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==2){
                    // Add all initially rotten oranges to queue with time = 0
                    queue.add(new Pair(i,j,0));
                    count2++;
                } else if (grid[i][j]==1) {
                    // Count fresh oranges
                   count1++;
                }
            }
        }

        // Edge case: No fresh oranges exist, already all rotten or empty
        if(count1==0){
            return 0;
        }
        // Edge case: Fresh oranges exist but no rotten oranges to start rotting
        else if (count2==0) {
            return -1;
        }

        // BFS: Process all rotten oranges level by level
        while (!queue.isEmpty()){
            Pair removed = queue.poll();
            int row = removed.row;
            int col = removed.col;
            int time = removed.time; // Update answer with current time

            ans = time;

            // Check up direction (r-1,col)
            if(row-1 >=0 && grid[row-1][col]==1){
                queue.add(new Pair(row-1, col, time+1));
                grid[row-1][col] = 2;
            }

            //check left direction ( row, col-1)
            if(col-1>=0 && grid[row][col-1]==1){
                queue.add(new Pair(row, col-1, time+1));
                grid[row][col-1]=2;
            }

            //check down direction ( row+1, col)
            if(row+1<m && grid[row+1][col]==1){
                queue.add(new Pair(row+1, col, time+1));
                grid[row+1][col]=2;
            }

            // check for right direction ( row, col+1)
            if(col+1<n && grid[row][col+1]==1){
                queue.add(new Pair(row, col+1, time+1));
                grid[row][col+1]=2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    };
    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        // Test case 1
        int[][] grid1 = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println("Test 1: " + rottenOranges.orangesRotting(grid1)); // Answer: 4

        // Test case 2
        int[][] grid2 = {{2,1,1}, {0,1,1}, {1,0,1}};
        System.out.println("Test 2: " + rottenOranges.orangesRotting(grid2)); // Answer: -1

        // Test case 3
        int[][] grid3 = {{0,2}};
        System.out.println("Test 3: " + rottenOranges.orangesRotting(grid3)); // Answer: 0

        // Test case 4
        int[][] grid4 = {{1}};
        System.out.println("Test 4: " + rottenOranges.orangesRotting(grid4)); // Answer: -1
    }
}
