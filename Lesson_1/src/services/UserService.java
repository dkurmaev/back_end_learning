package services;
import model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> findUsersByName(String name);
    List<User> getAllUsers();
}

