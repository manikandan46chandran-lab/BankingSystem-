package dao;

import db.DBConnection;
import exception.InsufficientBalanceException;
import java.sql.*;

public class AccountDAO {

    public void createAccount(int userId) throws SQLException {
        String sql = "INSERT INTO accounts(user_id,balance) VALUES(?,0)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.executeUpdate();
        }
    }
    public int getAccountId(int userId) throws SQLException {
        String sql = "SELECT account_id FROM accounts WHERE user_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("account_id");
            } else {
                throw new Exception("Account does not exist");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean accountExists(int userId) throws SQLException {
        String sql = "SELECT 1 FROM accounts WHERE user_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public double getBalance(int userId) throws SQLException {
        String sql = "SELECT balance FROM accounts WHERE user_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("balance");
            } else {
                throw new Exception("Account not found for this user");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBalance(int userId, double amount)
            throws SQLException, InsufficientBalanceException {

        double current = getBalance(userId);
        if (current + amount < 0)
            throw new InsufficientBalanceException("Insufficient balance!");

        String sql = "UPDATE accounts SET balance=? WHERE user_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, current + amount);
            ps.setInt(2, userId);
            ps.executeUpdate();
        }
    }
}
