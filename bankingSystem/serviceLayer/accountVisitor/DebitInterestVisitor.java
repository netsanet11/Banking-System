package lab8.finalProject.bankingSystem.serviceLayer.accountVisitor;


import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes.CheckingAccount;
import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes.SavingAccount;

public class DebitInterestVisitor implements DebitAccountVisitor
{
    @Override
    public void visit(CheckingAccount account)
    {
        account.setInterestValue(account.getInterestRate() * account.getBalance());
    }

    @Override
    public void visit(SavingAccount account)
    {
        account.setInterestValue(account.getBalance() * account.getInterestRate());
    }
}
