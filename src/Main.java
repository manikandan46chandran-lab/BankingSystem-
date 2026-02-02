import service.BankingService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BankingService service = new BankingService();
        Scanner sc = new Scanner(System.in);
        int userId = -1;

        while (true) {
            try {
                System.out.println("\n*** Bank ***");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose One : ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Enter numbers only.");
                    sc.nextLine();
                    continue;
                }

                int ch = sc.nextInt();
                sc.nextLine();

                if (ch == 1) {

                    while (true) {
                        try {
                            System.out.print("Username: ");
                            String u = sc.nextLine();

                            System.out.print("Password: ");
                            String p = sc.nextLine();

                            userId = service.register(u, p);
                            System.out.println("Registration successful!");
                            break;

                        } catch (Exception e) {
                            System.out.println("Validation Error: " + e.getMessage());
                        }
                    }
                    break;
                }

                else if (ch == 2) {
                    System.out.print("Username: ");
                    String u = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();

                    userId = service.login(u, p);
                    System.out.println("Login successful!");
                    break;
                }
                else if (ch == 3) {
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Auth Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("\n==== Banking Menu ====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Balance");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");
                System.out.print("Choose one : ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Enter numbers only.");
                    sc.nextLine();
                    continue;
                }

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Enter numbers only.");
                    sc.nextLine();
                    continue;
                }

                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Amount: ");

                        if (!sc.hasNextDouble()) {
                            System.out.println("Invalid amount. Enter a number.");
                            sc.nextLine();
                            break;
                        }

                        double depositAmount = sc.nextDouble();
                        service.deposit(userId, depositAmount);
                        System.out.println("Deposit successful");
                        break;

                    case 2:
                        System.out.print("Amount: ");

                        if (!sc.hasNextDouble()) {
                            System.out.println("Invalid amount. Enter a number.");
                            sc.nextLine();
                            break;
                        }

                        double withdrawAmount = sc.nextDouble();
                        service.withdraw(userId, withdrawAmount);
                        System.out.println("Withdrawal successful");
                        break;


                    case 3:
                        System.out.println(" Your current Balance : " + service.balance(userId));
                        break;

                    case 4:
                        System.out.println("All Transactions List");
                        var history = service.history(userId);

                        if (history.isEmpty()) {
                            System.out.println("No transactions found.");
                        } else {
                            history.forEach(System.out::println);
                        }
                        break;

                    case 5:
                        System.out.println("Thank you");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid option");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
