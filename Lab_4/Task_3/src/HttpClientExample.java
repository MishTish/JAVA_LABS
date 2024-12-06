import java.net.URI;
import java.net.http.*;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;
import java.util.Map;

public class HttpClientExample {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        String getUrl = "https://jsonplaceholder.typicode.com/posts/1"; // Example API
        System.out.println("Sending GET request...");
        sendGetRequest(client, getUrl);

        String postUrl = "https://jsonplaceholder.typicode.com/posts"; // Example API
        Map<String, String> formData = Map.of(
                "title", "foo",
                "body", "bar",
                "userId", "1"
        );
        System.out.println("\nSending POST request...");
        sendPostRequest(client, postUrl, formData);
    }

    private static void sendGetRequest(HttpClient client, String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Headers: " + response.headers());
            System.out.println("Body: " + response.body());
        } catch (Exception ex) {
            System.out.println("GET request failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void sendPostRequest(HttpClient client, String url, Map<String, String> formData) {
        try {

            String jsonBody = "{";
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                jsonBody += "\"" + entry.getKey() + "\": \"" + entry.getValue() + "\", ";
            }
            jsonBody = jsonBody.substring(0, jsonBody.length() - 2) + "}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Headers: " + response.headers());
            System.out.println("Body: " + response.body());
        } catch (Exception ex) {
            System.out.println("POST request failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}