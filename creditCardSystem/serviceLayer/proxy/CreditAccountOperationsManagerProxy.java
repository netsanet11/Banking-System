package lab8.finalProject.creditCardSystem.serviceLayer.proxy;


import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.CreditAccountBase;
import lab8.finalProject.creditCardSystem.serviceLayer.creditAccountManager.CreditAccountOperationsManagerImpl;
import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.basicData.Customer;
import lab8.finalProject.framework.dataLayer.models.basicData.IndividualCustomer;
import lab8.finalProject.framework.dataLayer.services.FrameworkDatabaseFacade;
import lab8.finalProject.framework.serviceLayer.NotificationsManager.NotificationsManagerSubject;
import lab8.finalProject.framework.serviceLayer.NotificationsManager.NotificationsManagerSubjectImpl;
import lab8.finalProject.framework.serviceLayer.accountsManager.AccountOperationsManager;

import java.util.List;

public class CreditAccountOperationsManagerProxy extends AccountOperationsManager {
    private AccountOperationsManager creditAccountOperationsManager;
    private NotificationsManagerSubject notificationManagerSubject;
    private FrameworkDatabaseFacade frameworkDatabaseFacade;

    public CreditAccountOperationsManagerProxy(FrameworkDatabaseFacade frameworkDatabaseFacade, NotificationsManagerSubject notificationsManagerSubject) {
        super(frameworkDatabaseFacade, notificationsManagerSubject);

        creditAccountOperationsManager	= new CreditAccountOperationsManagerImpl(frameworkDatabaseFacade, notificationsManagerSubject);
        notificationManagerSubject = new NotificationsManagerSubjectImpl();
        this.frameworkDatabaseFacade = frameworkDatabaseFacade;
    }

    @Override
    public void depositAccount(int accountID, double amount) {
        Account account = frameworkDatabaseFacade.getAccount(accountID);
        processAccount(account, amount, "Deposit");
        creditAccountOperationsManager.depositAccount(accountID, amount);
    }

    @Override
    public void withdrawAccount(int accountID, double amount) {
        Account account = frameworkDatabaseFacade.getAccount(accountID);
        processAccount(account, amount, "Withdraw");
        creditAccountOperationsManager.withdrawAccount(accountID, amount);
    }
    @Override
    public void calculateInterest(List<Account> allAccounts) {
        creditAccountOperationsManager.calculateInterest(allAccounts);
    }
    public void processAccount(Account account, Double amount, String type){
        Customer customer = account.getCustomer();
        if(customer instanceof IndividualCustomer && account instanceof CreditAccountBase){
            if(amount > 400 && account.getBalance() - amount < 0){
                notificationManagerSubject.notifyObservers(account, type);
            }
        }else{
            notificationManagerSubject.notifyObservers(account, type);
        }
    }
}

