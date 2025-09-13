package dfsMastery;

public class WordSearch {
    public static boolean exist(char[][]board, String word){
        int rowCount = board.length;
        int colCount = board[0].length;

        if (word == null || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if(board[i][j]==word.charAt(0)){
                   if(dfs(board,word,i,j,0)){
                       return true;
                   }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][]board, String word, int row, int col, int index){
        int rows = board.length;
        int cols = board[0].length;

        if(index == word.length()){
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }

        if(board[row][col] != word.charAt(index) || board[row][col] == '#'){
            return false;
        }

        char original = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, word, row - 1, col, index + 1) ||  // ⬆️ UP
                dfs(board, word, row + 1, col, index + 1) ||  // ⬇️ DOWN
                dfs(board, word, row, col - 1, index + 1) ||  // ⬅️ LEFT
                dfs(board, word, row, col + 1, index + 1);

        board[row][col] = original;

        return found;
    }
    public static void main(String[] args) {
        System.out.println("🔍 Word Search Problem - DFS with Backtracking\n");

        // Test Board
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println("Board:");
        printBoard(board);
        System.out.println();

        // Test Cases
        System.out.println("=== Word Search Tests ===");

        String[] testWords = {"ABCCED", "SEE", "ABCB", "ABCCEDE", "SFCS", "ASA"};

        for (String word : testWords) {
            boolean result = exist(board, word);
            System.out.println("Word: \"" + word + "\" → " +
                    (result ? "FOUND ✅" : "NOT FOUND ❌"));

            // Show expected path for some words
            if (word.equals("SEE") && result) {
                System.out.println("    Expected path: S[1,3] → E[2,3] → E[2,2]");
            }
            if (word.equals("ABCCED") && result) {
                System.out.println("    Expected path: A[0,0] → B[0,1] → C[0,2] → C[1,2] → E[2,2] → D[2,1]");
            }
        }

        System.out.println("\n=== Edge Cases ===");

        // Test Case: Single character board
        char[][] singleBoard = {{'A'}};
        System.out.println("Single cell board ['A']:");
        System.out.println("Word: \"A\" → " + (exist(singleBoard, "A") ? "FOUND ✅" : "NOT FOUND ❌"));
        System.out.println("Word: \"B\" → " + (exist(singleBoard, "B") ? "FOUND ✅" : "NOT FOUND ❌"));

        // Test Case: Empty word
        System.out.println("Empty word: \"\" → " + (exist(board, "") ? "FOUND ✅" : "NOT FOUND ❌"));

        // Test Case: Word longer than board
        System.out.println("Long word: \"ABCDEFGHIJKLMNOP\" → " +
                (exist(board, "ABCDEFGHIJKLMNOP") ? "FOUND ✅" : "NOT FOUND ❌"));

        // Test Case: Complex valid path
        System.out.println("\n=== Complex Path Test ===");
        char[][] complexBoard = {
                {'A','B','C'},
                {'D','E','F'},
                {'G','H','I'}
        };
        System.out.println("Complex board:");
        printBoard(complexBoard);
        System.out.println("Word: \"ABCFIEHDG\" → " +
                (exist(complexBoard, "ABCFIEHDG") ? "FOUND ✅" : "NOT FOUND ❌"));
        System.out.println("    Path: A → B → C → F → I → E → H → D → G (spiral pattern)");
    }

    // Helper method to print board nicely
    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("'" + board[i][j] + "'");
                if (j < board[i].length - 1) System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
