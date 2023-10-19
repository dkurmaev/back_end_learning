package services;
import model.User;
import repositories.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final CrudRepository userRepository;

    public UserServiceImpl(CrudRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        if (isEmailUnique(user.getEmail())) {
            userRepository.addUser(user);
        } else {
            System.out.println("User with the same email already exists.");
        }
    }

    @Override
    public List<User> findUsersByName(String name) {
        return userRepository.findAll().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private boolean isEmailUnique(String email) {
        List<User> users = userRepository.findAll();
        return users.stream().noneMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}




