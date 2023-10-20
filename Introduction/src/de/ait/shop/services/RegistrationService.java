package de.ait.shop.services;

import de.ait.shop.models.User;

public interface RegistrationService {
    User register(String email, String password);
}
