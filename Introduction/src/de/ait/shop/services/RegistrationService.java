package de.ait.shop.services;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;

public class RegistrationService {
    private final UsersRepository usersRepository;

    public RegistrationService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User register(String email, String password) {
        if (email == null || email.isEmpty() || email.equals(" ")) {
            throw new IllegalArgumentException("Email must not be null");
        }
        if (password == null || password.isEmpty() || password.equals(" ")) {
            throw new IllegalArgumentException("Password must not be null");
        }
        User user = new User(email, password);
        usersRepository.save(user);
        return user;
    }
}
