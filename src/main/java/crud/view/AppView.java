package crud.view;

import java.util.Scanner;

public class AppView {
    private static final String MENU =
                    "1 - Show all users\n" +
                    "2 - Add new user\n" +
                    "3 - Update user\n" +
                    "4 - Delete user\n" +
                    "0 - Exit";
    private Scanner in;
    private UsersView usersView;

    public AppView() {
        in = new Scanner(System.in);
        usersView = new UsersView();
    }

    public void run() {
        while (true) {
            System.out.println(MENU);
            int enter = in.nextInt();
            switch (enter) {
                case 1:
                    usersView.showAll();
                    break;
                case 2:
                    usersView.addUser();
                    break;
                case 3:
                    usersView.updateUser();
                    break;
                case 4:
                    usersView.deleteUser();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Enter number from 0 to 4...");
            }
        }
    }
}
