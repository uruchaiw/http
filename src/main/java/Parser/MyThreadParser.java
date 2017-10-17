package Parser;

public class MyThreadParser extends Thread {

    private MyParserPage page;

    private String url;

    public MyThreadParser(MyParserPage page, String url) {
        this.page = page;
        this.url = url;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        page.getPageLink(url);
    }
}
