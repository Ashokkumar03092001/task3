import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private int id;
    private String accountNumber;
    private double accountBalance;

    public Account(int id, String accountNumber, double accountBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
    }
}

class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private Account account;

    public User(int id, String userName, String password, String email, Account account) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.account = account;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
                + ", account=" + account + "]";
    }
}

class UserManagement {
    private static List<User> users = new ArrayList<>();
    private static int userIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Options:");
            System.out.println("1. Create User");
            System.out.println("2. Show Users");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    showUsers();
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void createUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter account id: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account balance: ");
        double accountBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account account = new Account(accountId, accountNumber, accountBalance);
        User user = new User(userIdCounter++, userName, password, email, account);
        users.add(user);
        System.out.println("User created successfully!");
    }

    private static void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No users to display.");
        } else {
            System.out.println("List of users:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}