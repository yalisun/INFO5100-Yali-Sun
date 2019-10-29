package assignment6.Q1;

import java.util.ArrayList;
import java.util.List;

public class UserInternal {
    private static final int NUM_RECENT_TRANS = 10;

    //userData should store USER, PASSWORD, and other account details internally in a dataStructure of your choice
    private User user;
    private String password;
    private int availableBalance;
    private List<String> transactions;

    public UserInternal(User user, String password) {
        this.user = user;
        this.password = password;
        this.transactions = new ArrayList<>();
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public int getAvailableBalance() {
        return this.availableBalance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public User getUser() {
        return this.user;
    }

    public void addTransaction(String transaction) {
        this.transactions.add(transaction);
    }

    public List<String> getTransactions() {
        return this.transactions;
    }

    public List<String> getRecentTransactions() {
        int size = transactions.size();
        if (size < NUM_RECENT_TRANS) {
            return transactions;
        }
        return transactions.subList(size - NUM_RECENT_TRANS, size);
    }

}
