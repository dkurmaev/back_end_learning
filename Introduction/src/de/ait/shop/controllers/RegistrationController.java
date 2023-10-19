package de.ait.shop.controllers;

import de.ait.shop.models.User;
import de.ait.shop.services.RegistrationService;

import java.util.Scanner;

public class RegistrationController {
    private final Scanner scanner;

    private final RegistrationService registrationService;

    public RegistrationController(Scanner scanner, RegistrationService registrationService) {
        this.scanner = scanner;
        this.registrationService = registrationService;
    }


    public void register() {
        System.out.println("Enter your email");
        String emailInput = scanner.nextLine();

        System.out.println("Enter your password");
        String passwordInput = scanner.nextLine();

        User user = registrationService.register(emailInput, passwordInput);
        System.out.println(user);
    }
}
