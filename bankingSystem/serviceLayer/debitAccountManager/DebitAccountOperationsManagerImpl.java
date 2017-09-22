package lab8.finalProject.bankingSystem.serviceLayer.debitAccountManager;


import lab8.finalProject.bankingSystem.serviceLayer.accountVisitor.DebitAccountVisitor;
import lab8.finalProject.bankingSystem.serviceLayer.accountVisitor.DebitInterestVisitor;
import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.services.FrameworkDatabaseFacade;
import lab8.finalProject.framework.serviceLayer.NotificationsManager.NotificationsManagerSubject;
import lab8.finalProject.framework.serviceLayer.accountsManager.AccountOperationsManager;

import java.util.List;

public class DebitAccountOperationsManagerImpl extends AccountOperationsManager
{

    public DebitAccountOperationsManagerImpl(FrameworkDatabaseFacade frameworkDatabaseFacade, NotificationsManagerSubject notificationsManagerSubject) {
        super(frameworkDatabaseFacade, notificationsManagerSubject);
    }

    @Override
    public void calculateInterest(List<Account> allAccounts)
    {
        for (Account account:allAccounts)
        {
            DebitAccountVisitor visitor = new DebitInterestVisitor();
            account.accept(visitor);
        }
    }
}
