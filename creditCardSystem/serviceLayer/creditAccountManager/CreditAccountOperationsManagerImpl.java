package lab8.finalProject.creditCardSystem.serviceLayer.creditAccountManager;


import lab8.finalProject.creditCardSystem.serviceLayer.accountVisitor.CreditCardAccountVisitor;
import lab8.finalProject.creditCardSystem.serviceLayer.accountVisitor.MinimumPaymentVisitor;
import lab8.finalProject.creditCardSystem.serviceLayer.accountVisitor.CreditCardInterestVisitor;
import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.services.FrameworkDatabaseFacade;
import lab8.finalProject.framework.serviceLayer.NotificationsManager.NotificationsManagerSubject;
import lab8.finalProject.framework.serviceLayer.accountsManager.AccountOperationsManager;

import java.util.List;

public class CreditAccountOperationsManagerImpl extends AccountOperationsManager
{

    public CreditAccountOperationsManagerImpl(FrameworkDatabaseFacade frameworkDatabaseFacade, NotificationsManagerSubject notificationsManagerSubject) {
        super(frameworkDatabaseFacade, notificationsManagerSubject);
    }

    @Override
    public void calculateInterest(List<Account> allAccounts)
    {
        for (Account account:allAccounts)
        {
            CreditCardAccountVisitor visitor = new CreditCardInterestVisitor();
            account.accept(visitor);
        }
    }
    @Override
    public void calculateMinimumPayment(List<Account> allAccounts)
    {
        for (Account account:allAccounts)
        {
            CreditCardAccountVisitor visitor = new MinimumPaymentVisitor();
            account.accept(visitor);
        }
    }
}
