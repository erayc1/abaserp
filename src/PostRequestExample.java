import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestExample {
    public static void main(String[] args) {
        try {
            // URL oluşturma
            @SuppressWarnings("deprecation")
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            // HTTP bağlantısı açma
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // POST metodunu ayarlama
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // Gönderilecek olan JSON verisi
            String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

            // JSON verisini gönderme işlemi
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);           
            }

            // HTTP yanıt kodunu alma işlemi
            int responseCode = connection.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            // Yanıt kodu 201 (Created) ise yanıtı okuma işlemi
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
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
                System.out.println("POST request not worked");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Hataları yazdırma
        }
    }
}

