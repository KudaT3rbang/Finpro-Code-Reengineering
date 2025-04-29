package controller;

import dao.AccountDAO;
import model.Account;
import java.sql.*;

public class AccountController {

    public boolean signup(String username, String password, String recoveryCode) {
        try (Connection conn = util.Javaconnect.connectDb()) {
            AccountDAO accountDAO = new AccountDAO(conn);
            Account newAccount = new Account(username, password, recoveryCode);
            return accountDAO.createAccount(newAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean authenticate(String username, String password) {
        try (Connection conn = util.Javaconnect.connectDb()) {
            AccountDAO accountDAO = new AccountDAO(conn);
            Account account = accountDAO.getAccountByUsername(username);
            return account != null && account.getPassword().equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean resetPassword(String username, String recoveryCode, String newPassword) {
        try (Connection conn = util.Javaconnect.connectDb()) {
            AccountDAO accountDAO = new AccountDAO(conn);
            return accountDAO.updatePassword(username, newPassword, recoveryCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
