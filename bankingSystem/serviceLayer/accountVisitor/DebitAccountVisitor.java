package lab8.finalProject.bankingSystem.serviceLayer.accountVisitor;


import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes.CheckingAccount;
import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes.SavingAccount;


public interface DebitAccountVisitor
{
    void visit(CheckingAccount account);
    void visit(SavingAccount account);
}
