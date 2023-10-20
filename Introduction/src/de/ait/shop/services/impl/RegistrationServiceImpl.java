package de.ait.shop.services.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.services.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {
    private final UsersRepository usersRepository;

    public RegistrationServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User register(String email, String password) {
        if (email == null || email.isEmpty() || email.equals(" ")) {
            throw new IllegalArgumentException("Email must not be null");
        }
        if (password == null || password.isEmpty() || password.equals(" ")) {
            throw new IllegalArgumentException("Password must not be null");
        }

        User existedUser = usersRepository.findeAllByEmail(email);
        if (existedUser != null) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        User user = new User(email, password);
        usersRepository.save(user);
        return user;
    }
}
