package dao;

import model.Account;
import java.sql.*;

public class AccountDAO {

    private Connection conn;

    public AccountDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean createAccount(Account account) throws SQLException {
        String sql = "INSERT INTO Account(username, password, recoveryCode) VALUES (?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, account.getUsername());
            pst.setString(2, account.getPassword());
            pst.setString(3, account.getRecoveryCode());
            return pst.executeUpdate() > 0;
        }
    }

    public Account getAccountByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM Account WHERE Username = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString("username"), rs.getString("password"), rs.getString("recoveryCode"));
            }
        }
        return null;
    }

    public boolean updatePassword(String username, String newPassword, String recoveryCode) throws SQLException {
        String sql = "UPDATE Account SET password = ? WHERE username = ? AND recoveryCode = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, newPassword);
            pst.setString(2, username);
            pst.setString(3, recoveryCode);
            return pst.executeUpdate() > 0;
        }
    }
}
