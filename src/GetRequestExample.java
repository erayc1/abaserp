import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequestExample {
    public static void main(String[] args) {
        try {
            // URL oluşturma
            @SuppressWarnings("deprecation")
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            // HTTP bağlantısı açma
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // GET metodunu ayarlama
            connection.setRequestMethod("GET");

            // HTTP yanıt kodunu alma işlemi
            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            // Yanıt kodu 200 (OK) ise yanıtı okuma işlemi
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder response;
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }

                // Sonucu yazdırma
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Hataları yazdırma
        }
    }
}
