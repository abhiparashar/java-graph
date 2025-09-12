package dfsMastery;

public class NumberOfIslands {
    public static int numIslands(char[][]grid){
        if(grid==null || grid[0].length==0) return 0;
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int islandCount = 0;
        //scan the whole grid;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private static void dfs(char[][]grid, int row, int col){
        int rows = grid.length;
        int cols = grid[0].length;

        // BASE CASES: Out of bounds OR already water/sunk
        if(row<0 || row>=rows|| col<0 || col>=cols || grid[row][col]=='0'){
            return;
        }

        // SINK THE LAND: Convert land ('1') to water ('0')
        grid[row][col] = '0';

        // EXPLORE 4 DIRECTIONS: UP, DOWN, LEFT, RIGHT
        dfs(grid,row-1, col); //up
        dfs(grid, row+1, col); //down
        dfs(grid, row, col-1); //left
        dfs(grid, row, col+1); //right
    }
    public static void main(String[] args) {
        // Test Case 1: Single island
        System.out.println("=== Test Case 1 ===");
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println("Islands: " + numIslands(grid1)); // Expected: 1

        // Test Case 2: Multiple islands
        System.out.println("\n=== Test Case 2 ===");
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println("Islands: " + numIslands(grid2)); // Expected: 3

        // Test Case 3: No islands
        System.out.println("\n=== Test Case 3 ===");
        char[][] grid3 = {
                {'0','0','0'},
                {'0','0','0'},
                {'0','0','0'}
        };

        System.out.println("Islands: " + numIslands(grid3)); // Expected: 0

    }
}
