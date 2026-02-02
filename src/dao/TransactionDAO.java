package dao;

import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    // Save transaction
    public void addTransaction(int accountId, String type, double amount)
            throws SQLException {

        String sql =
                "INSERT INTO transactions(account_id, type, amount) VALUES (?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, accountId);
            ps.setString(2, type);
            ps.setDouble(3, amount);

            ps.executeUpdate();
        }
    }


    public List<String> getTransactions(int accountId) throws SQLException {

        String sql = """
        SELECT type, amount, txn_time
        FROM transactions
        WHERE account_id=?
        ORDER BY txn_time DESC
    """;

        List<String> history = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                history.add(
                        rs.getTimestamp("txn_time") + " | " +
                                rs.getString("type") + " | " +
                                rs.getDouble("amount")
                );
            }
        }
        return history; 
    }

}

