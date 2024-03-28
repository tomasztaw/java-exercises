/**
 * Created by tomasz_taw
 * Date: 28.03.2024
 * Time: 10:32
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.sudoku;

import org.springframework.stereotype.Service;

@Service
public class SudokuSolver {

    public boolean solveSudoku(int[][] board) {
        return solve(board, 0, 0);
    }

    private boolean solve(int[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solve(board, row + 1, 0);
        }

        if (board[row][col] != 0) {
            return solve(board, row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num
                    || board[i][col] == num
                    || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

}
