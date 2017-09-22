package lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes;


import lab8.finalProject.bankingSystem.serviceLayer.accountVisitor.DebitAccountVisitor;
import lab8.finalProject.framework.dataLayer.models.accounts.TransactionHistory;

import java.time.LocalDateTime;
import java.util.List;

public class CheckingAccount extends DebitAccountBase
{
    public CheckingAccount(int accountId, double interestRate) {
        super(accountId, interestRate);
    }

    public CheckingAccount(int accountId, LocalDateTime createdDate, LocalDateTime lastModified, double balance, List<TransactionHistory> transactionsHistory, double interestRate) {
        super(accountId, createdDate, lastModified, balance, transactionsHistory, interestRate);
    }


    @Override
    public <T> void accept(T t) {
        DebitAccountVisitor visitor = (DebitAccountVisitor)t;
        visitor.visit(this);
    }
}
