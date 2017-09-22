package lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.accounts.TransactionHistory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public abstract class CreditAccountBase extends Account
{
    private double interestRate;
    protected double interestValue;
    private double minimumPaymentRate;
    private double minimumPaymentValue;


    public CreditAccountBase(int accountId, double interestRate, double minimumPaymentRate)
    {
        this(accountId, LocalDateTime.now(), LocalDateTime.now(), 0.0, new ArrayList<>(), interestRate, minimumPaymentRate);
    }

    public CreditAccountBase(int accountId, LocalDateTime createdDate, LocalDateTime lastModified, double balance, List<TransactionHistory> transactionsHistory, double interestRate, double minimumPaymentRate) {
        super(accountId, createdDate, lastModified, balance, transactionsHistory);

        this.interestRate = interestRate;
        this.minimumPaymentRate = minimumPaymentRate;
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

    public double getMinimumPaymentRate() {
        return minimumPaymentRate;
    }

    public void setMinimumPaymentRate(double minimumPaymentRate) {
        this.minimumPaymentRate = minimumPaymentRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMinimumPaymentValue() {
        return minimumPaymentValue;
    }

    public void setMinimumPaymentValue(double minimumPaymentValue) {
        this.minimumPaymentValue = minimumPaymentValue;
    }
}
