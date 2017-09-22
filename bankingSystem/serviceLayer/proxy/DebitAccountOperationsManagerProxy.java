package lab8.finalProject.bankingSystem.serviceLayer.proxy;

import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes.DebitAccountBase;
import lab8.finalProject.bankingSystem.serviceLayer.debitAccountManager.DebitAccountOperationsManagerImpl;
import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.basicData.Customer;
import lab8.finalProject.framework.dataLayer.models.basicData.IndividualCustomer;
import lab8.finalProject.framework.dataLayer.services.FrameworkDatabaseFacade;
import lab8.finalProject.framework.serviceLayer.NotificationsManager.NotificationsManagerSubject;
import lab8.finalProject.framework.serviceLayer.NotificationsManager.NotificationsManagerSubjectImpl;
import lab8.finalProject.framework.serviceLayer.accountsManager.AccountOperationsManager;

import java.util.List;

public class DebitAccountOperationsManagerProxy extends AccountOperationsManager {
    private AccountOperationsManager debitAccountOperationsManager;
    private NotificationsManagerSubject notificationManagerSubject;
    private FrameworkDatabaseFacade frameworkDatabaseFacade;

    public DebitAccountOperationsManagerProxy(FrameworkDatabaseFacade frameworkDatabaseFacade, NotificationsManagerSubject notificationsManagerSubject) {
        super(frameworkDatabaseFacade, notificationsManagerSubject);

        debitAccountOperationsManager	= new DebitAccountOperationsManagerImpl(frameworkDatabaseFacade, notificationsManagerSubject);
        notificationManagerSubject = new NotificationsManagerSubjectImpl();
        this.frameworkDatabaseFacade = frameworkDatabaseFacade;
    }


    @Override
    public void depositAccount(int accountID, double amount) {
        Account account = frameworkDatabaseFacade.getAccount(accountID);
        processAccount(account, amount, "Deposit");

        debitAccountOperationsManager.depositAccount(accountID, amount);
    }


    @Override
    public void withdrawAccount(int accountID, double amount) {
        Account account = frameworkDatabaseFacade.getAccount(accountID);
        processAccount(account, amount, "Withdraw");
        debitAccountOperationsManager.depositAccount(accountID, amount);

    }
    @Override
    public void addInterest() {
        debitAccountOperationsManager.addInterest();
    }

    @Override
    public void addMinimumPayment() {
        debitAccountOperationsManager.addMinimumPayment();
    }

    @Override
    public void calculateInterest(List<Account> allAccounts) {
        debitAccountOperationsManager.calculateInterest(allAccounts);
    }


    public void processAccount(Account account, Double amount, String type){
        Customer customer = account.getCustomer();
        if(customer instanceof IndividualCustomer && account instanceof DebitAccountBase){
            if(amount > 500 && account.getBalance() - amount < 0){
                notificationManagerSubject.notifyObservers(account, type);
            }
        }else{
            notificationManagerSubject.notifyObservers(account, type);
        }
    }

}
