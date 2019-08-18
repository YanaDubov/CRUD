package crud.view;

import crud.controller.UserController;
import crud.model.Number;
import crud.model.Role;
import crud.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class UsersView {

    private static final String HEADER = "INDEX   NAME   SURNAME   EMAIL   ROLES   MOBILE_NUMBER";
    Scanner in;
    private UserController userController;
    public UsersView() {
        userController = new UserController();
        in = new Scanner(System.in);
    }

    public void showAll() {
        AtomicInteger index = new AtomicInteger(1);
        List<User> users = userController.showAll();
        System.out.println(HEADER);
        users.forEach(object -> {
            System.out.print(index.getAndIncrement() + "       ");
            System.out.print(object.getName() + "  ");
            System.out.print(object.getSurname() + "  ");
            System.out.print(object.getEmail() + "  ");
            object.getRoles().forEach(value ->
                    System.out.print(value.getRole() + " "));
            object.getNumbers().forEach(value ->
                    System.out.print(value.getNumber() + " "));
            System.out.println();
        });
    }

    public void addUser() {
       userController.addUser(fillUser());
    }

    public void updateUser() {
        showAll();
        System.out.println("Enter index of user:");
        int index = in.nextInt();
        in.nextLine();
        userController.updateUser(fillUser(),index);
    }

    public void deleteUser() {
        showAll();
        System.out.println("Enter index of user:");
        int index = in.nextInt();
        in.nextLine();
        userController.deleteUser(index);
    }

    private User fillUser(){
        String name;
        String surname;
        String email;
        String roles;
        String numbers;
        System.out.println("Enter name: ");
        name = in.nextLine();
        System.out.println("Enter surname: ");
        surname = in.nextLine();
        System.out.println("Enter email: ");
        email = in.nextLine();
        while (!Pattern.matches("[^@]+@[^\\.]+\\..+", email)) {
            System.out.println("Invalid email. Try again..");
            System.out.println("Enter email: ");
            email = in.nextLine();
        }
        System.out.println("Enter role(s) with a space: ");
        roles = in.nextLine();
        Set<Role> roleSet = new HashSet<>();
        Arrays.asList(roles.split(" ")).forEach(value->roleSet.add(new Role(value)));
        System.out.println("Enter mobile number(s) with a space: ");
        numbers = in.nextLine();
        Set<Number> numberSet = new HashSet<>();
        String[] strings = numbers.split(" ");
        Arrays.stream(strings).forEach(value -> {
            while (!Pattern.matches("375\\d{9}", value)) {
                System.out.println("Invalid mobile number "+ value+". Try again..");
                System.out.println("Enter new number instead: ");
                value = in.nextLine();
            }
            numberSet.add(new Number(value));
        });
//        Arrays.asList(numbers.split(" ")).forEach(value->numberSet.add(new Number(value)));
        return new User(name,surname,email,roleSet,numberSet);
    }
}
