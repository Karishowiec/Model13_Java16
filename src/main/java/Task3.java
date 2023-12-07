import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Task3 {
    public void getToDos() throws IOException {
        URL url = new URL(UserAPI.BASE_URL + "/1/todos");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line.trim());
            }
            List<Comments> fromJson = new Gson().fromJson(stringBuilder.toString(), new TypeToken<List<Comments>>() {
            }.getType());
            List<Comments> comments = fromJson.stream().filter(comment -> !comment.isCompleted()).toList();
            System.out.println(comments);
        }
    }

}
class Comments {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Comments(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}