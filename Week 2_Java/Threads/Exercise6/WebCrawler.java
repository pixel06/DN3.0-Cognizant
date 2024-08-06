package Exercise6;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebCrawler {

   static final int NUMBER_OF_THREADS = 10;
   final ExecutorService executorService;
   final ConcurrentHashMap<String, String> crawledData;

    public WebCrawler() {
        this.executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        this.crawledData = new ConcurrentHashMap<>();
    }

    public void startCrawling(String[] urls) {
        for (String url : urls) {
            CrawlerTask task = new CrawlerTask(url, crawledData);
            executorService.submit(task);
        }
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public ConcurrentHashMap<String, String> getCrawledData() {
        return crawledData;
    }

    public static void main(String[] args) {
        String[] urls = {"http://javatpoint.com", "http://w3schools.org", "http://artelogic.net"};
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.startCrawling(urls);
        webCrawler.shutdown();
        ConcurrentHashMap<String, String> data = webCrawler.getCrawledData();
        data.forEach((url, content) -> System.out.println(url + " -> " + content));
    }

    
}

