import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        UserAPI userAPI = new UserAPI();
//    userAPI.getAllUsers();
//    userAPI.getUserById(1);
//    userAPI.getUserByUserName("Bret");
//    userAPI.createUser();
//    userAPI.updateUser();
//        userAPI.deleteUser();
//        Task2 task = new Task2();
//        int postId = task.getPost();
//        System.out.println(postId);
//        task.getComments(postId);
//        System.out.println(postId);
        Task3 task = new Task3();
        task.getToDos();
    }
}
