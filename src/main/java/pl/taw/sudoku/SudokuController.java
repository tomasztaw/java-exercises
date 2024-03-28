/**
 * Created by tomasz_taw
 * Date: 28.03.2024
 * Time: 11:24
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.sudoku;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SudokuController {

    private final SudokuSolver sudokuSolver;

    public SudokuController(SudokuSolver sudokuSolver) {
        this.sudokuSolver = sudokuSolver;
    }

    @GetMapping("/sudoku-game")
    public String getSudokuBoard(Model model) {
        int[][] sudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 0, 0, 0, 7, 9}
        };

        model.addAttribute("sudokuBoard", sudokuBoard);

        return "sudoku-game";
    }

    @GetMapping("/sudoku-game2")
    public String getSudokuBoard2(Model model) {
        int[][] sudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 0, 0, 0, 7, 9}
        };

        model.addAttribute("sudokuBoard", sudokuBoard);

        return "sudoku-game2";
    }

    @GetMapping("/sudoku-game3")
    public String solveSudoku(Model model) {
        int[][] sudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (sudokuSolver.solveSudoku(sudokuBoard)) {
            model.addAttribute("sudokuBoard", sudokuBoard);
            return "sudoku-game";
        } else {
            return "error"; // Możesz zdefiniować własny widok dla przypadku braku rozwiązania Sudoku
        }
    }
}
