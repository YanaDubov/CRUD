package crud.serialization;

import crud.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserSerializator {

    private final String paths = "src/main/resources/users.txt";

    public void addUser(User user) {
        List<User> users = this.getAll();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(paths))) {
            users.add(user);
            out.writeObject(users);
            out.flush();
        } catch (IOException e) {
            System.out.println("Error add user");
        }
    }

    public void updateUser(User user, int index) {
        List<User> users = getAll();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(paths))) {
            users.set(index - 1, user);
            out.writeObject(users);
            out.flush();
            System.out.println("User updated successfully");
        } catch (IOException e) {
            System.out.println("Error update user");
        }
    }

    public void deleteUser(int index) {
        List<User> users = getAll();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(paths))) {
            users.remove(index - 1);
            out.writeObject(users);
            out.flush();
            System.out.println("User deleted successfully");
        } catch (IOException e) {
            System.out.println("Error delete user");
        }
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(paths))) {
            users = (List<User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error get all users from file");
        }
        return users;
    }
}
