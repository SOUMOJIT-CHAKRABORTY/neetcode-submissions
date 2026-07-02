class Solution {
      int ROWS = 0;
      int COLS = 0;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int r = 0; r<ROWS; r++ ){
            for(int c = 0; c<COLS; c++){
                if(dfs(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private final int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    private boolean dfs(char[][] board, String word, int row, int col, int i){
        if(word.length() == i){
            return true;
        }
        if(row<0 || col<0 ||
            row >= ROWS || col >= COLS ||
            board[row][col] != word.charAt(i)){
            return false;
        }

        board[row][col] = '#';
        for(int[] dir : dirs){
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            if(dfs(board, word, nrow, ncol, i+1)){
                return true;
            }
        }
        // boolean res = dfs(board, word, row + 1, col, i+1) ||
        //               dfs(board, word, row - 1, col, i+1) ||
        //               dfs(board, word, row , col + 1, i+1) ||
        //               dfs(board, word, row , col - 1, i+1);
        board[row][col] = word.charAt(i);
        return false;
    }
}
