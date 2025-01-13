package kelmerdev.com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static kelmerdev.com.Scraper.scrapeProductPage;

public class Main {
    public static void main(String[] args) {
        // initializing the list of Java object to store
        // the scraped data
        List<Product> products = new ArrayList<>();

        // initializing the set of web page urls
        // discovered while crawling the target website
        Set<String> pagesDiscovered = new HashSet<>();

        // initializing the queue of urls to scrape
        List<String> pagesToScrape = new ArrayList<>();
        // initializing the scraping queue with the
        // first pagination page
        pagesToScrape.add("https://www.scrapingcourse.com/ecommerce/page/1/");

        // the number of iteration executed
        int i = 0;
        // to limit the number to scrape to 5
        int limit = 12;

        while (!pagesToScrape.isEmpty() && i < limit) {
            scrapeProductPage(products, pagesDiscovered, pagesToScrape);
            // incrementing the iteration number
            i++;
        }

        System.out.println(products.size());
        // writing the scraped data to a db or export it to a file...
    }
}