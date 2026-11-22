class Solution {
    public boolean validate(char[][] board, int i, int j, char num) {
        for(int k = 0; k < board.length; k++) {
            if(board[i][k] == num) {
                return false;
            }
        }

        for(int k = 0; k < board.length; k++) {
            if(board[k][j] == num) {
                return false;
            }
        }

        int row = (i / 3) * 3;
        int col = (j / 3) * 3;

        for(int x = row; x < row + 3; x++) {
            for(int y = col; y < col + 3; y++) {
                if(board[x][y] == num) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean sudoku(char[][] board, int i, int j) {

        if(i == 9) {
            return true;
        }

        if(board[i][j] != '.') {
            if(j < 8) {
                return sudoku(board, i, j + 1);

            } else {
                return sudoku(board, i + 1, 0);
            }
        }
        
        if(board[i][j] == '.') {
            for(int k = 1; k <= 9; k++) {
                if(validate(board, i, j, (char)(k + '0'))) {
                    board[i][j] = (char) (k + '0');

                    if(j < 8) {
                        if(sudoku(board, i, j + 1)) {
                            return true;
                        }
                        board[i][j] = '.';

                    } else {
                        if(sudoku(board, i + 1, 0)) {
                            return true;
                        }

                        board[i][j] = '.';
                    }
                }
            }
        }

        return false;
    }
    public void solveSudoku(char[][] board) {
        sudoku(board, 0, 0);
    }
}