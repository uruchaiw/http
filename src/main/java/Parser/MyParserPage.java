package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyParserPage {

    public void getPageLink(String url) {

        try {
            Document document = Jsoup.connect(url).get();
            Elements title  = document.select("meta[property=og:title]");
            Elements tage = document.select("meta[property=og:video:tag]");
            //Elements linkOnVideo = document.select("div.jw-aspect jw-reset");

            Element iframe = document.select("iframe").first();
            String iframeSrc = iframe.attr("src");

            Matcher m = null;
            Elements linkOnVideo = null;


            if(iframeSrc != null) {
                Document iframeContentDoc = Jsoup.connect(iframeSrc).get();
                linkOnVideo = iframeContentDoc.select("script");

                Pattern p = Pattern.compile("(?is)jwplayer.key =\"(.+?)\"");
                m = p.matcher(linkOnVideo.html());

                while( m.find() )
                {
                    System.out.println(m.group()); // the whole key ('key = value')
                    System.out.println(m.group(1)); // value only
                }
            }

            System.out.println(title + "\n" + tage + " \n" + " \n" + linkOnVideo);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //https://www.ebalovo.com/video/porno-114504/
    }
}
