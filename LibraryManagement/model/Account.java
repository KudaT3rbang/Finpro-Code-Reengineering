package model;

public class Account {
    private String username;
    private String password;
    private String recoveryCode;

    // Constructor
    public Account(String username, String password, String recoveryCode) {
        this.username = username;
        this.password = password;
        this.recoveryCode = recoveryCode;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecoveryCode() {
        return recoveryCode;
    }

    public void setRecoveryCode(String recoveryCode) {
        this.recoveryCode = recoveryCode;
    }
}
