import service.BankingService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BankingService service = new BankingService();
        Scanner sc = new Scanner(System.in);
        int userId = 0;

        try {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Choose One : ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                userId = service.register(u, p);
            } else if (ch == 2) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                userId = service.login(u, p);
            } else {
                System.out.println("Invalid choice");
                return;
            }

            while (true) {
                System.out.println("\n *** Banking Menu ***");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Balance");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");
                System.out.print("Choose: ");

                int option = sc.nextInt();

                try {
                    switch (option) {
                        case 1:
                            System.out.print("Enter amount: ");
                            double dep = sc.nextDouble();
                            service.deposit(userId, dep);
                            System.out.println("Deposit successful");
                            break;

                        case 2:
                            System.out.print("Enter amount: ");
                            double wit = sc.nextDouble();
                            service.withdraw(userId, wit);
                            System.out.println("Withdrawal successful");
                            break;

                        case 3:
                            System.out.println(" Your Current Balance : " + service.balance(userId));
                            break;

                        case 4:
                            System.out.println("Your Transactions List");
                            service.history(userId)
                                    .forEach(System.out::println);
                            break;

                        case 5:
                            System.out.println("Exit Successful");
                            sc.close();
                            System.exit(0);

                        default:
                            System.out.println("Invalid option");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}
