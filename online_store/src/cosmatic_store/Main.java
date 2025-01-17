package cosmatic_store;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        loadSampleData();
        login();
    }

    private static void loadSampleData() {
        products.add(new Product("Shampoo", "Hair Care", 5.99, 50));
        products.add(new Product("Face Wash", "Skin Care", 7.49, 30));

        users.add(new Manager("admin", "admin123"));
        users.add(new Cashier("cashier1", "cashier123"));
        users.add(new GuestCustomer("guest", "guest123"));
        users.add(new RegisteredCustomer("customer1", "customer123"));
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = authenticate(username, password);
        if (user != null) {
            System.out.println("Login successful!");
            user.displayMenu();
        } else {
            System.out.println("Invalid credentials");
        }
    }

    private static User authenticate(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }
}
