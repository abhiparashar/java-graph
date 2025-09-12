package dfsMastery;

public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][]grid){
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int maxArea = 0;

        //scan
        for (int i = 0; i <rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(grid[i][j]==1){
                    int currentArea = dfs(grid,i,j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][]grid, int row, int col){
        int rows = grid.length;
        int cols = grid[0].length;

        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]==0){
            return 0;
        }

        //MARK AS VISITED: Change 1 to 0 (in-place marking)
        grid[row][col] = 0;

        //COUNT CURRENT CELL: 1 + areas from 4 directions
        int area = 1;

        area += dfs(grid, row-1, col); //up
        area += dfs(grid, row+1, col); //down
        area += dfs(grid, row, col-1); //left
        area += dfs(grid, row, col+1); //right

        return area;
    }
    public static void main(String[] args) {
        // Test Case 1: Multiple islands with different areas
        System.out.println("=== Test Case 1: Multiple Islands ===");
        int[][] grid1 = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,1,0},
                {0,0,1,1,1}
        };

        System.out.println("Max area: " + maxAreaOfIsland(grid1)); // Expected: 5

        // Test Case 2: Single large connected island
        System.out.println("\n=== Test Case 2: One Large Island ===");
        int[][] grid2 = {
                {1,1,1},
                {0,1,0},
                {1,1,1}
        };

        System.out.println("Max area: " + maxAreaOfIsland(grid2)); // Expected: 7

        // Test Case 3: No islands (all water)
        System.out.println("\n=== Test Case 3: No Islands ===");
        int[][] grid3 = {
                {0,0,0},
                {0,0,0}
        };

        System.out.println("Max area: " + maxAreaOfIsland(grid3)); // Expected: 0

        // Test Case 4: Single cell island
        System.out.println("\n=== Test Case 4: Single Cell Island ===");
        int[][] grid4 = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        System.out.println("Max area: " + maxAreaOfIsland(grid4)); // Expected: 1

        // Test Case 5: Multiple single-cell islands
        System.out.println("\n=== Test Case 5: Multiple Single Islands ===");
        int[][] grid5 = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };

        System.out.println("Max area: " + maxAreaOfIsland(grid5)); // Expected: 1

        // Test Case 6: All land (one giant island)
        System.out.println("\n=== Test Case 6: All Land ===");
        int[][] grid6 = {
                {1,1},
                {1,1}
        };

        System.out.println("Max area: " + maxAreaOfIsland(grid6)); // Expected: 4
    }
}
