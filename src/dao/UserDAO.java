package dao;

import db.DBConnection;
import java.sql.*;

public class UserDAO {

    public int register(String username, String password) throws SQLException {
        String sql = "INSERT INTO users(username,password) VALUES(?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }
    }

    public int login(String username, String password) throws SQLException {
        String sql = "SELECT user_id FROM users WHERE username=? AND password=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt("user_id");
            return -1;
        }
    }
}
