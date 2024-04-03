import java.util.ArrayList;

public class Bank {
    private final String bankName;
    private final ArrayList<String> bankAccount;

    public Bank(String bankName, ArrayList<String> bankAccount) {
        this.bankName = bankName;
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public ArrayList<String> getBankAccount() {
        return bankAccount;
    }

}
