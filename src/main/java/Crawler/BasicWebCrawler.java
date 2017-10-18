package Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class BasicWebCrawler {

    private static HashSet<String> links;
    private static String addToUrl;

    BasicWebCrawler() {
        links = new HashSet<>();
    }

    public HashSet<String> getLinks() {
        return links;
    }

    static void setAddToUrl(String addToUrl) {
        BasicWebCrawler.addToUrl = addToUrl;
    }

    public void getPageLinks(String URL) {
        if (!links.contains(URL)) {
            DateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
            Date date = new Date();

            try {
                Document document = Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0")
                        .timeout(15*1000)
                        .ignoreContentType(true)
                        .get();
                Elements otherLinks = document.select("a[href~=(http|https)://(www.|)"+ addToUrl +"]");
                for (Element page : otherLinks) {
                    if (links.add(URL)) {
                        //sSystem.out.print(dateFormat.format(date) + " ");
                        //System.out.println(URL);
                    }
                    getPageLinks(page.attr("abs:href"));
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
