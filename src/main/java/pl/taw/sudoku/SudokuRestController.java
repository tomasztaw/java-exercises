/**
 * Created by tomasz_taw
 * Date: 28.03.2024
 * Time: 19:38
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.sudoku;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuRestController {

    private final SudokuSolver sudokuSolver;

    public SudokuRestController(SudokuSolver sudokuSolver) {
        this.sudokuSolver = sudokuSolver;
    }

    @GetMapping("/solveSudoku")
    public String solveSudoku() {
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
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(sudokuBoard);
            } catch (Exception e) {
                e.printStackTrace();
                return "[]";
            }
        } else {
            return "[]";
        }
    }
}
