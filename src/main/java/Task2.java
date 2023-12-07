import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;

public class Task2 {
    public int getPost() throws IOException {
        URL url = new URL(UserAPI.BASE_URL + "/1/posts");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line.trim());
            }
            List<Post> fromJson = new Gson().fromJson(stringBuilder.toString(), new TypeToken<List<Post>>() {
            }.getType());
            Optional<Integer> max = fromJson.stream().map(post -> post.getId()).max(Integer::compareTo);
            Integer maxId = max.get();
            return maxId;

        }
    }
    public void getComments(int postId)throws IOException{
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/"+postId+"/comments");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line.trim());
            }
            System.out.println(stringBuilder.toString());
            Files.write(Paths.get("user-1-post-10-comments.json"),stringBuilder.toString().getBytes());
        }
    }
}
class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
