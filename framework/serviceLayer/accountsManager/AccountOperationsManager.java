package lab8.finalProject.framework.serviceLayer.accountsManager;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.accounts.TransactionHistory;
import lab8.finalProject.framework.dataLayer.services.FrameworkDatabaseFacade;
import lab8.finalProject.framework.serviceLayer.NotificationsManager.NotificationsManagerSubject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public abstract class AccountOperationsManager
{
    private FrameworkDatabaseFacade frameworkDatabaseFacade;
    private NotificationsManagerSubject notificationsManagerSubject;

    public AccountOperationsManager(FrameworkDatabaseFacade frameworkDatabaseFacade, NotificationsManagerSubject notificationsManagerSubject)
    {
        this.frameworkDatabaseFacade = frameworkDatabaseFacade;
        this.notificationsManagerSubject = notificationsManagerSubject;
    }

    public void depositAccount(int accountID, double amount)
    {
        Account account = frameworkDatabaseFacade.getAccount(accountID);
        TransactionHistory newTransaction = new TransactionHistory(new Random().nextInt(), LocalDateTime.now(), "Deposit: " + amount , amount);
        account.setTransactionsHistory(newTransaction);
        account.setBalance(amount);

        notificationsManagerSubject.notifyObservers(account, "Deposit");
    }

    public void withdrawAccount(int accountID, double amount)
    {
        Account account = frameworkDatabaseFacade.getAccount(accountID);
        TransactionHistory newTransaction = new TransactionHistory(new Random().nextInt(), LocalDateTime.now(), "Withdraw: " + amount, -amount);
        account.setTransactionsHistory(newTransaction);
        account.setBalance(-amount);

        notificationsManagerSubject.notifyObservers(account, "Withdraw");
    }


    public void addInterest()
    {
        List<Account> allAccounts = frameworkDatabaseFacade.getAllAccounts();
        calculateInterest(allAccounts);
    }

    public abstract void calculateInterest(List<Account> allAccounts);


    public void addMinimumPayment()
    {
        List<Account> allAccounts = frameworkDatabaseFacade.getAllAccounts();
        calculateMinimumPayment(allAccounts);
    }

    public  void calculateMinimumPayment(List<Account> allAccounts){
        throw new UnsupportedOperationException();
    }
}
