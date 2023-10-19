package de.ait.shop;

import de.ait.shop.controllers.RegistrationController;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.repositories.impl.UsersRepositoryListImpl;
import de.ait.shop.services.RegistrationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersRepository usersRepository = new UsersRepositoryListImpl();
        RegistrationService registrationService = new RegistrationService(usersRepository);
        RegistrationController registrationController = new RegistrationController(scanner, registrationService);

        String command = scanner.nextLine();
        if (command.equals("/register")) {
            registrationController.register();

        }

    }
}
