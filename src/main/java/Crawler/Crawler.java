package Crawler;

import Parser.MyParserPage;
import Parser.MyThread;
import Parser.MyThreadParser;

public class Crawler {

   public static void main(String[] arg) {
       //String getUrl = "www.mykyong.com";
       String url = "http://www.mkyong.com/";
       String refinementSearch = "mykyong.com/page/";

       BasicWebCrawler basicWebCrawler = new BasicWebCrawler();
       BasicWebCrawler.setAddToUrl(refinementSearch);

       MyThread myThread = new MyThread(basicWebCrawler, url);
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
       myThread5.start();

       for (Thread t : new Thread[] { myThread, myThread1, myThread2, myThread3, myThread4, myThread5 }) {
           try {
               t.join();
               System.out.println("All Thread Completed work");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

       System.out.println(basicWebCrawler.getLinks().size());

       MyParserPage myParserPage = new MyParserPage();
       MyThreadParser myThreadParser;

       for (String s : basicWebCrawler.getLinks()) {
           myThreadParser = new MyThreadParser(myParserPage, s);
           //myThreadParser.start();
       }
   }
}
