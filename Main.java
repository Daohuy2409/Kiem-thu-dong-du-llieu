import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final static User[] users = new User[] {
        new User("user1@gmail.com", "James@123" , 500000),
        new User("user2@gmail.com", "Linda@1234", 600000),
        new User("user3@gmail.com", "Huyls@123", 500000000),
        new User("user4@gmail.com", "Haha&1234", 1000),
        new User("user5@gmail.com", "Hoang^123456", 431500)};

    final static Bank[] banks = new Bank[] {
        new Bank("Vietcombank", new ArrayList<String>() {{
            add("0123456789"); add("9876543210"); add("1234567890");}}),
        new Bank("Techcombank", new ArrayList<String>() {{
            add("012356789"); add("9876343210"); add("1230567890");}}),
        new Bank("Agribank", new ArrayList<String>() {{
            add("0153456789"); add("9876843210"); add("1234767890");}})
        };
    public static boolean checkValidUser(User[] users, User inputUser) {
        if (!inputUser.getAccount().matches(".{6,20}")) {
            return false;
        }
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        if (!inputUser.getPassword().matches(passwordRegex)) {
            return false;
        }
        for (User user : users) {
            if (user.getAccount().equals(inputUser.getAccount())) {
                if (user.getPassword().equals(inputUser.getPassword())) {
                    inputUser.setBalance(user.getBalance());
                    return true;
                }
                break;
            }
        }
        return false;
    }
    public static boolean checkValidBankAccount(String bankName, String bankAccount) {
        for (Bank bank : banks) {
            if (bank.getBankName().equals(bankName)) {
                for (String account : bank.getBankAccount()) {
                    if (account.equals(bankAccount)) {
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }
    public static boolean transferMoney(User user, int amount) {
        if (amount > 100000000 || amount < 10000) {
            return false;
        }
        if (amount > user.getBalance()) {
            return false;
        }
        user.setBalance(user.getBalance() - amount);
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account: ");
        String account = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        User inputUser = new User(account, password);

        if (checkValidUser(users, inputUser)) {
            System.out.println("Login successfully!");
            //choose bank
            System.out.println("Select beneficiary bank");
            System.out.println("1. Vietcombank");
            System.out.println("2. Techcombank");
            System.out.println("3. Agribank");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            String bankName = "";
            switch (choice) {
                case 1: bankName = "Vietcombank"; break;
                case 2: bankName = "Techcombank"; break;
                case 3: bankName = "Agribank"; break;
                default: System.out.println("Invalid choice!");
            }
            System.out.println("Enter beneficiary account: ");
            String bankAccount = scanner.next();
            //check valid bank account
            if (checkValidBankAccount(bankName, bankAccount)) {
                System.out.println("Enter amount:");
                int amount = scanner.nextInt();
                if (transferMoney(inputUser, amount)) {
                    System.out.println("Transfer successfully!");
                    System.out.println("Your balance: " + inputUser.getBalance());
                } else {
                    System.out.println("Transfer failed!");
                }
            } else {
                System.out.println("Transfer failed!");
            }
        } else {
            System.out.println("Login failed!");
        }
    }
}


