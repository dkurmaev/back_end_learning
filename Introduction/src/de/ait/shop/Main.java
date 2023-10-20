package de.ait.shop;

import de.ait.shop.controllers.RegistrationController;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.repositories.impl.UsersRepositoryFileImpl;
import de.ait.shop.repositories.impl.UsersRepositoryListImpl;
import de.ait.shop.services.RegistrationService;
import de.ait.shop.services.impl.RegistrationServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersRepository usersRepositoryList = new UsersRepositoryListImpl();
        UsersRepository usersRepositoryFile = new UsersRepositoryFileImpl("users.txt");
        RegistrationService registrationService = new RegistrationServiceImpl(usersRepositoryList);
        RegistrationController registrationController = new RegistrationController(scanner, registrationService);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("/register")) {
                registrationController.register();

            } else if (command.equals("/exit")) {
                break;

            }
        }
    }
}
