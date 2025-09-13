package dfsMastery;

public class SurroundedRegions {
    public static void solve(char[][]board){
        int rowCount = board.length;
        int colCount = board[0].length;

        // STEP 1: Mark all boundary-connected 'O's as safe
        for (int j = 0; j < colCount; j++) {
            if(board[0][j]=='O'){
                dfs(board, 0, j);
            }
            if (board[rowCount-1][j]=='O') {
                dfs(board,rowCount-1,j);
            }
        }

        //scan the left and right col
        for (int i = 0; i < rowCount; i++) {
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if (board[i][colCount-1]=='O') {
                dfs(board,i,colCount-1);
            }
        }

        //Convert remaining 'O' to 'X' and restore safe 'O's
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                } else if (board[i][j]=='#') {
                    board[i][j]= 'O';
                }
            }
        }
    }

    private static void dfs(char[][]board, int row, int col){
        int rows = board.length;
        int cols = board[0].length;

        if( row<0 || row>=rows|| col<0 || col>=cols || board[row][col]!='O'){
            return;
        }

        board[row][col] = '#';

        dfs(board,row-1,col); //up
        dfs(board, row+1, col); //down
        dfs(board, row, col-1); //left
        dfs(board, row, col +1); //right
    }
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("=== Test Case 1 ===");
        char[][] board1 = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        System.out.println("Before:");
        printBoard(board1);

        solve(board1);

        System.out.println("After:");
        printBoard(board1);

        // Test Case 2: All boundary connected
        System.out.println("\n=== Test Case 2 ===");
        char[][] board2 = {
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}
        };

        System.out.println("Before:");
        printBoard(board2);

        solve(board2);

        System.out.println("After:");
        printBoard(board2);
    }

    // Helper method to print board
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}