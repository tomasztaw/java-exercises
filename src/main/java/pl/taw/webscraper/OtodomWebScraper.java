/**
 * Created by tomasz_taw
 * Date: 24.04.2024
 * Time: 21:02
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OtodomWebScraper {

    private final String ulr = "https://www.otodom.pl/pl/wyniki/sprzedaz/mieszkanie/dolnoslaskie/wroclaw/wroclaw/wroclaw?distanceRadius=5&limit=36&ownerTypeSingleSelect=ALL&priceMin=50000&priceMax=500000&by=DEFAULT&direction=DESC&viewType=listing";

    public List<Offer> getOffers() throws IOException {
        Document document = Jsoup.connect(ulr).get();

        Elements elements = document.getElementsByAttributeValue("data-cy", "listing-item-link");
        List<String> links = elements.stream()
//                .flatMap(e -> e.getElementsByAttribute("listing-item").stream())
                .map(e -> e.attr("href"))
                .toList();

        return null;
    }
}
