package d02_10_2023;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlHelper {
    public static int getHTTPResponseStatusCode(String u) throws IOException {

        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
}
