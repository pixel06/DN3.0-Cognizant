package Exercise6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class CrawlerTask implements Runnable {
    private final String url;
    private final ConcurrentHashMap<String, String> crawledData;

    public CrawlerTask(String url, ConcurrentHashMap<String, String> crawledData) {
        this.url = url;
        this.crawledData = crawledData;
    }

    @Override
    public void run() {
        try {
            String content = retrieveWebPage(url);
            if (content != null) {
                crawledData.put(url, content);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving URL: " + url + " - " + e.getMessage());
        }
    }

    private String retrieveWebPage(String urlString) throws Exception {
        StringBuilder content = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
        }

        return content.toString();
    }
}
