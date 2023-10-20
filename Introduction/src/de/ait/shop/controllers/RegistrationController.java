package de.ait.shop.controllers;

import de.ait.shop.models.User;
import de.ait.shop.services.RegistrationService;
import de.ait.shop.services.impl.RegistrationServiceImpl;

import java.util.Scanner;

public class RegistrationController {
    private final Scanner scanner;

    private final RegistrationService registrationServiceImpl;

    public RegistrationController(Scanner scanner, RegistrationService registrationService) {
        this.scanner = scanner;
        this.registrationServiceImpl = registrationService;
    }


    public void register() {
        System.out.println("Enter your email");
        String emailInput = scanner.nextLine();

        System.out.println("Enter your password");
        String passwordInput = scanner.nextLine();

        User user = registrationServiceImpl.register(emailInput, passwordInput);
        System.out.println(user);
    }
}
