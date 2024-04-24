package pl.taw.webscraper;

public record Offer(
        String url,
        String name,
        String description,
        String address,
        String photoUrl
) {
}
