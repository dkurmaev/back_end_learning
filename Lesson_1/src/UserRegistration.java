import model.User;
import repositories.UserRepositoryFileImpl;
import services.UserService;
import services.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        UserRepositoryFileImpl repository = new UserRepositoryFileImpl("users.txt");

        UserService userService = new UserServiceImpl(repository);

        while (true) {
            System.out.print("Enter name (or 'exit' to quit): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            String email = null;
            while (true) {
                System.out.print("Enter email: ");
                email = scanner.nextLine();

                if (isValidEmail(email)) {
                    break;
                } else {
                    System.out.println("Email must contain the '@' symbol. Please enter a valid email.");
                }
            }

            User user = new User(name, email);

            userService.addUser(user);
        }

        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
    }

    private static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}
