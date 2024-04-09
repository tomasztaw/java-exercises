/**
 * Created by tomasz_taw
 * Date: 27.03.2024
 * Time: 21:25
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/rental-app")
    public String rentalApp() {
        return "rental-app";
    }

    @GetMapping("/lottery")
    public String lottery() {
        return "lottery";
    }

    @GetMapping("/sudoku")
    public String sudoku() {
        return "sudoku";
    }

    @GetMapping("/bowling")
    public String bowling() {
        return "bowling";
    }
}
