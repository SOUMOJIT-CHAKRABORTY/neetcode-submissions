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
        boolean res = dfs(board, word, row + 1, col, i+1) ||
                      dfs(board, word, row - 1, col, i+1) ||
                      dfs(board, word, row , col + 1, i+1) ||
                      dfs(board, word, row , col - 1, i+1);
        board[row][col] = word.charAt(i);
        return res;
    }
}
