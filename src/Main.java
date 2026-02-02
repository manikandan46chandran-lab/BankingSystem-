import service.BankingService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankingService service = new BankingService();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("1.Register 2.Login");
            int ch = sc.nextInt();
            sc.nextLine();

            int userId = 0;

            if (ch == 1) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                userId = service.register(u, p);
            } else {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                userId = service.login(u, p);
            }

            while (true) {
                System.out.println("1.Deposit 2.Withdraw 3.Balance 4.History 5.Exit");
                int c = sc.nextInt();

                if (c == 1) {
                    System.out.print("Amount: ");
                    service.deposit(userId, sc.nextDouble());
                }
                else if (c == 2) {
                    System.out.print("Amount: ");
                    service.withdraw(userId, sc.nextDouble());
                }
                else if (c == 3) {
                    System.out.println("Balance: " + service.balance(userId));
                }
                if (c == 4) {
                    service.history(userId).forEach(System.out::println);
                }
                else break;
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
