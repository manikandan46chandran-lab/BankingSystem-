package service;

import dao.*;
import exception.*;
import java.util.List;

public class BankingService {

    private UserDAO userDAO = new UserDAO();
    private AccountDAO accountDAO = new AccountDAO();
    private TransactionDAO txnDAO = new TransactionDAO();

    public int register(String user, String pass) throws Exception {
        int id = userDAO.register(user, pass);
        accountDAO.createAccount(id);
        return id;
    }

    public int login(String user, String pass) throws Exception {
        int id = userDAO.login(user, pass);
        if (id == -1)
            throw new AuthenticationException("Invalid credentials");
        return id;
    }

    public void deposit(int userId, double amt) throws Exception {
        accountDAO.updateBalance(userId, amt);
        int accId = accountDAO.getAccountId(userId);
        txnDAO.addTransaction(accId, "DEPOSIT", amt);
        System.out.println("Successfully Deposited Amount Rs = " + amt );
    }

    public void withdraw(int userId, double amt) throws Exception {
        accountDAO.updateBalance(userId, -amt);
        int accId = accountDAO.getAccountId(userId);
        txnDAO.addTransaction(accId, "WITHDRAW", amt);
    }

    public double balance(int userId) throws Exception {
        return accountDAO.getBalance(userId);
    }

    public List<String> history(int userId) throws Exception {
        int accId = accountDAO.getAccountId(userId);
        return txnDAO.getTransactions(accId);
    }
}
