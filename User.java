public class User {
    private final String account;
    private final String password;
    private int balance;

    public User(String account, String password, int balance) {
        this.account = account;
        this.password = password;
        this.balance = balance;
    }
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
