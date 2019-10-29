package assignment6.Q1;

import java.util.*;

public class Atm {

    //Create a Atm class with attributes availableAmountInMachine, transactionFee and userData.
    private int availableAmountInMachine;
    private int transactionFee;
    private Map<Integer, UserInternal> userData;
    private Integer loginAccountId;
    private Scanner scanner;

    public Atm(int availableAmountInMachine, int transactionFee) {
        //The constructor should initialize all the attributes.
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        this.userData  = new HashMap<>();
        this.loginAccountId = null;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            if (hasLogin()) {
                displayUserPanel();
            } else {
                exit = displayMainPanel();
            }
        }
    }

    private boolean hasLogin() {
        return loginAccountId != null;
    }

    private void displayUserPanel() {
        while (true) {
            System.out.println("Hi, please enter 1 for check your available balance, " +
                    "2 for withDraw, 3 for deposit, 4 for check your recent transactions, " +
                    "5 for change password, 6 for logout: ");
            int type = scanner.nextInt();
            if (type == 1) {
                checkAvailableBalance(loginAccountId);
            } else if (type == 2) {
                System.out.println("Please enter the withdrawal amount: ");
                int amountInput = scanner.nextInt();
                withdraw(loginAccountId, amountInput);
            } else if (type == 3) {
                System.out.println("Please enter the deposit amount: ");
                int amountInput = scanner.nextInt();
                deposit(loginAccountId, amountInput);
            } else if (type == 4) {
                List<String> recentTransactions = recentTransactions(loginAccountId);
                for (String s : recentTransactions) {
                    System.out.println(s);
                }
            } else if (type == 5) {
                changePassword(loginAccountId);
            } else if (type == 6) {
                logout();
                break;
            }
        }
    }

    private boolean displayMainPanel() {
        //Ask for NEW USER or CURRENT USER as the start.
        System.out.println("Press 1 to create New User, press 2 to current user login, " +
                "press 3 forgot password, press others to exit");
        int userStatus = scanner.nextInt();
        if (userStatus == 1) {
            createUser();
        } else if (userStatus == 2) {
            login();
        } else if (userStatus == 3) {
            forgotPassword();
        } else { // others exit
            return true;
        }
        return false;
    }

    private void createUser() {
        //Create a NEW USER with a unique bankAccountNumber and password.
        System.out.println("Please Enter your name:");
        String name = scanner.next();
        System.out.println("Please Enter your age:");
        int age = scanner.nextInt();
        System.out.println("Please Enter your address:");
        String address = scanner.next();
        System.out.println("Please Enter your phone number:");
        String phoneNumber = scanner.next();
        System.out.println("Please Enter your password:");
        String password = scanner.next();
        int bankAccountNumber = createBankAccountNumber();
        User user = new User(name, age, phoneNumber, address, bankAccountNumber);
        UserInternal userInternal = new UserInternal(user, password);
        userData.put(bankAccountNumber, userInternal);
        System.out.println("Your bank account number is: " + bankAccountNumber);
        System.out.println("Created successfully, please login!");
    }

    private int createBankAccountNumber() {
        return userData.size();
    }

    private void login() {
        //CURRENT USER should be able to login using bankAccountNumber and password.
        System.out.println("Please Enter your bankAccountNumber:");
        int bankAccountNumber = scanner.nextInt();
        if (!userData.containsKey(bankAccountNumber)) {
            System.out.println("Invalid bank account number:");
            return;
        }
        System.out.println("Please Enter your password:");
        String password = scanner.next();
        if (matchAccount(bankAccountNumber, password)) {
            loginAccountId = bankAccountNumber;
            System.out.println("Login successfully!");
        } else {
            System.out.println("Login Error!");
        }
    }

    private boolean matchAccount(int bankAccountNumber, String password) {
        if (password == null) return false;
        UserInternal userInternal = userData.get(bankAccountNumber);
        return userInternal.getPassword().equals(password);
    }

    private void changePassword(int bankAccountNumber) {
        if (loginAccountId != null) {
            System.out.println("Please Enter your new password:");
            String newPassword = scanner.next();
            UserInternal userInternal = userData.get(bankAccountNumber);
            userInternal.setPassword(newPassword);
            System.out.println("Change password successfully!");
        }
    }

    private void forgotPassword() {
        //CURRENT USER should be able to use FORGOT PASSWORD
        System.out.println("Please Enter your bank account number:");
        int bankAccountNumber = scanner.nextInt();
        if (!userData.containsKey(bankAccountNumber)) {
            System.out.println("Invalid bank account number:");
            return;
        }
        UserInternal userInternal = userData.get(bankAccountNumber);
        //check current user's name, age, phone, address
        System.out.println("Please Enter your name:");
        String name = scanner.next();
        System.out.println("Please Enter your age:");
        int age = scanner.nextInt();
        System.out.println("Please Enter your address:");
        String address = scanner.next();
        System.out.println("Please Enter your phone number:");
        String phoneNumber = scanner.next();
        User user = userInternal.getUser();
        if (checkUser(user, name, age, phoneNumber, address)) {
            System.out.println("Please Enter your new password:");
            String newPassword = scanner.next();
            userInternal.setPassword(newPassword);
            System.out.println("Reset password successfully!");
        } else {
            System.out.println("Information not match!");
        }
    }

    private boolean checkUser(User user, String name, int age, String phoneNumber, String address) {
        return user.getName().equals(name)
                && user.getAge() == age
                && user.getPhoneNumber().equals(phoneNumber)
                && user.getAddress().equals(address);
    }

    private void checkAvailableBalance(int bankAccountNumber) {
        if (loginAccountId != null) {
            UserInternal userInternal = userData.get(bankAccountNumber);
            int availableBalance = userInternal.getAvailableBalance();
            System.out.println("Your available balance is: " + toDollars(availableBalance));
        }
    }

    private void withdraw(int bankAccountNumber, int amount) {
        while (amount > availableAmountInMachine) {
            System.out.println("Sorry, exceed the available amount in the machine. Please Enter again: ");
            int newAmount1 = scanner.nextInt();
            amount = newAmount1;
        }
        while (amount + transactionFee > userData.get(bankAccountNumber).getAvailableBalance()) {
            System.out.println("Sorry, exceed the available amount in your account. Please Enter again: ");
            int newAmount2 = scanner.nextInt();
            amount = newAmount2;
        }
        //Add a transactionFee for every transaction done and update the availableAmountInMachine
        availableAmountInMachine = availableAmountInMachine - amount + transactionFee;
        int oldAvailableBalance = userData.get(bankAccountNumber).getAvailableBalance();
        userData.get(bankAccountNumber).setAvailableBalance(oldAvailableBalance - amount - transactionFee);
        UserInternal userInternal = userData.get(bankAccountNumber);
        userInternal.addTransaction("Withdrawal: " + toDollars(amount));
        System.out.println("withdrawal successfully!");
    }

    private void deposit(int bankAccountNumber, int amount) {
        availableAmountInMachine = availableAmountInMachine + amount + transactionFee;
        int oldAvailableBalance = userData.get(bankAccountNumber).getAvailableBalance();
        userData.get(bankAccountNumber).setAvailableBalance(oldAvailableBalance + amount - transactionFee);
        UserInternal userInternal = userData.get(bankAccountNumber);
        userInternal.addTransaction("Deposit: " + toDollars(amount));
        System.out.println("deposit successfully!");
    }

    private List<String> recentTransactions(int bankAccountNumber) {
        UserInternal userInternal = userData.get(bankAccountNumber);
        return userInternal.getRecentTransactions();
    }

    private void logout() {
        loginAccountId = null;
        System.out.println("Logout successfully!");
    }

    private static String toDollars(int amount) {
        return String.format("$ %d.00", amount);
    }
}
