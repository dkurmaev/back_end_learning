package repositories;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRepositoryFileImpl implements CrudRepository {
    private final String fileName;
    private Long currentID;

    public UserRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
        this.currentID = 1L;
    }

    @Override
    public void addUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            user.setId(currentID++);
            writer.write("ID: " + user.getId() + "; Name: " + user.getName() + "; Email: " + user.getEmail());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByID(Long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Optional<String> userLine = reader.lines()
                    .filter(line -> {
                        String[] parts = line.split(";");
                        return Long.parseLong(parts[0].substring(4)) == id;
                    })
                    .findFirst();
            if (userLine.isPresent()) {
                String[] parts = userLine.get().split(";");
                return new User(Long.parseLong(parts[0].substring(4)), parts[1].substring(6), parts[2].substring(7));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String nextLine = reader.readLine();
            while (nextLine != null) {
                Pattern pattern = Pattern.compile("ID: (\\d+)");
                Matcher matcher = pattern.matcher(nextLine);

                if (matcher.find()) {
                    Long userId = Long.parseLong(matcher.group(1));
                    nextLine = reader.readLine();
                    if (nextLine != null) {
                        //String nameLine = nextLine;

                        nextLine = reader.readLine();
                        if (nextLine != null && nextLine.startsWith("Email: ")) {
                            ///String emailLine = nextLine;

                            userList.add(new User(userId, "NAME", "EMAIL"));

                            nextLine = reader.readLine();
                        }
                    }
                }
                else {
                    nextLine = reader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void deleteById(Long id) {
        List<User> users = findAll();
        users.removeIf(user -> user.getId().equals(id));
        saveAll(users);
    }

    @Override
    public void update(User user) {
        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                break;
            }
        }
        saveAll(users);
    }

    private void saveAll(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (User user : users) {
                writer.write("ID: " + user.getId());
                writer.newLine();
                writer.write("Name: " + user.getName());
                writer.newLine();
                writer.write("Email: " + user.getEmail());
                writer.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}