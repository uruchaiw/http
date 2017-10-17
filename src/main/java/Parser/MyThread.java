package Parser;

import Crawler.BasicWebCrawler;

public class MyThread extends Thread {

    private BasicWebCrawler links;

    private static String url;


    public MyThread(BasicWebCrawler links, String url) {
        this.links = links;
        MyThread.url = url;
    }

    /*public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        MyThread.url = url;
    }*/

    public void run(){
        System.out.println(Thread.currentThread().getName());
        //synchronized (BasicWebCrawler.class) {
            links.getPageLinks(url);
        //}
    }
}
