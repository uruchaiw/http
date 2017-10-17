package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyParserPage {

    public void getPageLink(String url) {
        String regularExpressions = "(?is)file : \'//(.+?)\'";
        List<String> linkOnVide = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();

            Elements title  = document.select("meta[property=og:title]");
            Elements tage = document.select("meta[property=og:video:tag]");

            Element iframe = document.select("iframe").first();
            String iframeSrc = iframe.attr("src");

            if(iframeSrc != null) {
                Document iframeContentDoc = Jsoup.connect(iframeSrc).get();
                Elements linkOnVideo = iframeContentDoc.select("script");

                Pattern p = Pattern.compile(regularExpressions);
                Matcher m = p.matcher(linkOnVideo.html());

                while(m.find()) {
                    linkOnVide.add(m.group(1));
                }
            }

            System.out.println(title + "\n" + tage + " \n" + " \n" + linkOnVide);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
