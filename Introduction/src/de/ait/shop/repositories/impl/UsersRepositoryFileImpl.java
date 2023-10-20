package de.ait.shop.repositories.impl;

import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;

import java.io.*;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {
    private final String fileName;
    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            user.setId(generatedId);
            writer.write(user.getId() + "|" + user.getEmail() + " | " + user.getPassword());
            writer.newLine();
        } catch (Exception e) {
            throw new IllegalStateException("Error saving user: " + e.getMessage());
        }
        generatedId++;
    }
    @Override
    public void deleteById(Long id) {

    }
    @Override
    public void update(User model) {

    }
    @Override
    public User findeAllByEmail(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split("\\|"))
                    .filter(line -> line[1].equals(email))
                    .findFirst()
                    .map(parsed -> new User(Long.parseLong(parsed[0]), parsed[1], parsed[2]))
                    .orElse(null);

        } catch (IOException e) {
            throw new IllegalStateException("Error reading from file: " + e.getMessage());
        }
    }
}
