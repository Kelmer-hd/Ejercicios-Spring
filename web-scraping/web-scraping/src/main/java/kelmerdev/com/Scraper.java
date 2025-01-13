package kelmerdev.com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Scraper {
    public static void scrapeProductPage(
            List<Product> products,
            Set<String> pagesDiscovered,
            List<String> pagesToScrape
    ) {
        if (!pagesToScrape.isEmpty()) {
            // the current web page is about to be scraped and
            // should no longer be part of the scraping queue
            String url = pagesToScrape.remove(0);

            pagesDiscovered.add(url);

            // initializing the HTML Document page variable
            Document doc;

            try {
                // fetching the target website
                doc = Jsoup
                        .connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
                        .get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // retrieving the list of product HTML elements
            // in the target page
            Elements productElements = doc.select("li.product");

            // iterating over the list of HTML products
            for (Element productElement : productElements) {
                Product Product = new Product();

                // extracting the data of interest from the product HTML element
                // and storing it in Product
                Product.setUrl(productElement.selectFirst("a").attr("href"));
                Product.setImage(productElement.selectFirst("img").attr("src"));
                Product.setName(productElement.selectFirst("h2").text());
                Product.setPrice(productElement.selectFirst("span").text());

                // adding Product to the list of the scraped products
                products.add(Product);
            }

            // retrieving the list of pagination HTML element
            Elements paginationElements = doc.select("a.page-numbers");

            // iterating over the pagination HTML elements
            for (Element pageElement : paginationElements) {
                // the new link discovered
                String pageUrl = pageElement.attr("href");

                // if the web page discovered is new and should be scraped
                if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
                    pagesToScrape.add(pageUrl);
                }

                // adding the link just discovered
                // to the set of pages discovered so far
                pagesDiscovered.add(pageUrl);
            }

            // logging the end of the scraping operation
            System.out.println(url + " -> page scraped");
        }
    }
}
