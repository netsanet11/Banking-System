package lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.accounts.TransactionHistory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


//=====================
//Visitor Pattern
//=====================

public abstract class DebitAccountBase extends Account
{
    protected double interestRate;
    protected double interestValue;


    public DebitAccountBase(int accountId, double interestRate) {
        this(accountId, LocalDateTime.now(), LocalDateTime.now(), 0.0, new ArrayList<>(), interestRate);
    }

    public DebitAccountBase(int accountId, LocalDateTime createdDate, LocalDateTime lastModified, double balance, List<TransactionHistory> transactionsHistory, double interestRate) {
        super(accountId, createdDate, lastModified, balance, transactionsHistory);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }


    public void setInterestValue(double interestValue) {
        this.interestValue = interestValue;
    }

    public double getInterestValue() {
        return interestValue;
    }
}
