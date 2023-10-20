package de.ait.shop.repositories.impl;
import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {

    private final List<User> users = new ArrayList<>();
    private Long generatedId = 1L;


    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {
        users.add(user);
        user.setId(generatedId++);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public User findeAllByEmail(String email) {
//        for(User user : users) {
//            if (user.getEmail().equals(email)) {
//                return user;
//            }
//        }
//        return null;
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
