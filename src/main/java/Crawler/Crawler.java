package Crawler;

import Parser.MyParserPage;
import Parser.MyThread;

public class Crawler {

   public static void main(String[] arg) {
       //String getUrl = "www.mykyong.com";
       String url = "http://www.mkyong.com/";
       String refinementSearch = "mkyong.com/page/";
       String urlparser = "https://www.ebalovo.com/video/porno-114504/";

       BasicWebCrawler basicWebCrawler = new BasicWebCrawler();
       BasicWebCrawler.setAddToUrl(refinementSearch);

       MyParserPage myParserPage = new MyParserPage();
       myParserPage.getPageLink(urlparser);

       /*MyThread myThread = new MyThread(basicWebCrawler, url);
       myThread.start();

       MyThread myThread1 = new MyThread(basicWebCrawler ,url);
       myThread1.start();

       MyThread myThread2 = new MyThread(basicWebCrawler, url);
       myThread2.start();

       MyThread myThread3 = new MyThread(basicWebCrawler, url);
       myThread3.start();

       MyThread myThread4 = new MyThread(basicWebCrawler, url);
       myThread4.start();

       MyThread myThread5 = new MyThread(basicWebCrawler, url);
       myThread5.start();*/
   }
}
