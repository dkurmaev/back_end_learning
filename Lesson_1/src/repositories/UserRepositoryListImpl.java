package repositories;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryListImpl implements CrudRepository {
    private Long currentID = 1L;
    private final List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        user.setId(currentID++);
        users.add(user);
    }

    @Override
    public User findByID(Long id) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        return userOptional.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public void update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                break;
            }
        }
    }
}
