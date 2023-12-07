import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UserAPI {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    public void getAllUsers() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line.trim());
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public void getUserById(int id) throws IOException {
        URL url = new URL(BASE_URL + "/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line.trim());
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public void getUserByUserName(String name) throws IOException {
        URL url = new URL(BASE_URL + "?username=" + name);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line.trim());
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public void createUser() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        String user = "{\"name\": \"Kyrylo Kozhumyaka\", \"username\": \"kyrylo_kozhumyaka\", \"email\": \"Kyrylo_Kozhumyaka@gmail.com\", \"city\": \"Kyivcity\", \"company\": \"Ukrainian fairy tails\"}";
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(user.getBytes());
            outputStream.flush();
        }
        int responseCode = connection.getResponseCode();
        if (responseCode / 100 == 2) {
            System.out.println("jap");
        } else {
            System.out.println("error");
        }
    }

    public void updateUser() throws IOException {
        URL url = new URL(BASE_URL + "/1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        String user = "{\"name\": \"Kyrylo Kozhumyaka\", \"username\": \"kyrylo_kozhumyaka\", \"email\": \"Kyrylo_Kozhumyaka@gmail.com\", \"city\": \"Kyivcity\", \"company\": \"Ukrainian fairy tails\"}";
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(user.getBytes());
            outputStream.flush();
        }
        int responseCode = connection.getResponseCode();
        if (responseCode / 100 == 2) {
            System.out.println("jap");
        } else {
            System.out.println("error");
        }
    }
    public void deleteUser() throws IOException {
        URL url = new URL(BASE_URL + "/" + 1);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        int responseCode = connection.getResponseCode();
        if (responseCode / 100 == 2) {
            System.out.println("jap");
        } else {
            System.out.println("error");
        }
    }
}


