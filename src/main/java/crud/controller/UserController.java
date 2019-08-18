package crud.controller;

import crud.model.User;
import crud.serialization.UserSerializator;

import java.util.List;

public class UserController {

    private UserSerializator userSerializator;

    public UserController() {
        userSerializator = new UserSerializator();
    }

    public List<User> getAll() {
        return userSerializator.getAll();
    }

    public void addUser(User user) {
        userSerializator.addUser(user);
    }

    public void updateUser(User user, int index) {
        userSerializator.updateUser(user, index);
    }

    public void deleteUser(int index) {
        userSerializator.deleteUser(index);
    }
}
