package lab8.finalProject.framework.dataLayer.models.accounts;


import lab8.finalProject.framework.dataLayer.models.basicData.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Account
{
    private int accountId;
    private LocalDateTime createdDate;
    private LocalDateTime lastModified;
    private double balance;
    private byte[] rowVer;
    private Customer customer;

    private List<TransactionHistory> transactionsHistory;

    public Account(int accountId, LocalDateTime createdDate, LocalDateTime lastModified)
    {
        this(accountId, createdDate, lastModified, 0.0, new ArrayList<>());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account(int accountId, LocalDateTime createdDate, LocalDateTime lastModified, double balance, List<TransactionHistory> transactionsHistory) {
        this.accountId = accountId;
        this.createdDate = createdDate;
        this.lastModified = lastModified;
        this.balance = balance;
        this.transactionsHistory = transactionsHistory;
        this.rowVer = null;
    }

    public int getAccountId() {
        return accountId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public double getBalance() {
        return balance;
    }

    public List<TransactionHistory> getTransactionsHistory() {
        return transactionsHistory;
    }

    public byte[] getRowVer() {
        return rowVer;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public void setTransactionsHistory(List<TransactionHistory> transactionsHistory) {
        this.transactionsHistory.addAll(transactionsHistory);
    }

    public void setTransactionsHistory(TransactionHistory transactionsHistory) {
        this.transactionsHistory.add(transactionsHistory);
    }

    public abstract <T>void accept(T t);
}
