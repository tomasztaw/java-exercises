/**
 * Created by tomasz_taw
 * Date: 25.04.2024
 * Time: 15:39
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.webscraper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebScraperController {

    private final OtodomWebScraper scraper;

    @GetMapping("/offers")
    public String getOffers(Model model) {
        try {
            List<String> links = scraper.getOffers();
            model.addAttribute("links", links);
        } catch (IOException e) {
            return "error";
        }

        return "offerList";
    }



}
