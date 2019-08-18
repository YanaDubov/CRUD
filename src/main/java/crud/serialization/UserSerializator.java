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
            System.out.println("Error read data from file");
        }
    }

    public void updateUser(User user, int index) {
        List<User> users = getAll();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(paths))) {
            if (users.size() >= index && index != 0) {
                users.set(index - 1, user);
                out.writeObject(users);
                out.flush();
                System.out.println("User updated successfully");
            }else {
                System.out.println("Invalid index!");
            }
        } catch (IOException e) {
            System.out.println("Error read data from file");
        }
    }

    public void deleteUser(int index) {
        List<User> users = getAll();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(paths))) {
            if (users.size() >= index && index != 0) {
                users.remove(index - 1);
                out.writeObject(users);
                out.flush();
                System.out.println("User deleted successfully");
            } else {
                System.out.println("Invalid index!");
            }

        } catch (IOException e) {
            System.out.println("Error read data from file");
        }
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(paths))) {
            users = (List<User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error read data from file");
        }
        return users;
    }
//    public static void main(String[] args){
//        UserSerializator serializator = new UserSerializator();
//        Role role = new Role("aaa");
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(role);
//        Number number = new Number("aaa");
//        Set<Number> numbers = new HashSet<>();
//        numbers.add(number);
//        User user = new User("aaa","aaa","aaa",roleSet,numbers);
//        serializator.addUser(user);
//        List<User> users = serializator.getAll();
//        System.out.println(users.get(0).getName());
//    }
}
