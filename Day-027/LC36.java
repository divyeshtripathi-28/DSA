class Solution {
    public boolean sudoku(char[][] board, int start, int end) {
        if (board[start][end] == '.') {
            return true;
        }
        for(int i = 0; i < board.length; i++) {
            if (board[start][i] == '.') {
                continue;
            }
            if(board[start][end] == board[start][i] && end != i) {
                return false;
            }
        }

        for(int i = 0; i < board.length; i++) {
            if (board[i][end] == '.') {
                continue;
            }
            if(board[start][end] == board[i][end] && start != i) {
                return false;
            }
        }

        int i = (start / 3) * 3;
        int j = (end / 3) * 3;

        while(i < (start / 3) * 3 + 3) {
            j = (end / 3) * 3;
            while(j < (end / 3) * 3 + 3) {
                if (board[i][j] == '.') {
                    j++;
                    continue;
                }
                if(board[start][end] == board[i][j] && (start != i || end != j)) {
                    return false;
                }
                j++;
            }
            i++;
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(!sudoku(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}