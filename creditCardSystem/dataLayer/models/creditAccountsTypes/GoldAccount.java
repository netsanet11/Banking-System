package lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes;


import lab8.finalProject.creditCardSystem.serviceLayer.accountVisitor.CreditCardAccountVisitor;
import lab8.finalProject.framework.dataLayer.models.accounts.TransactionHistory;

import java.time.LocalDateTime;
import java.util.List;

public class GoldAccount extends CreditAccountBase
{
    public GoldAccount(int accountId, double monthlyInterest, double minimumPayment)
    {
        super(accountId, monthlyInterest, minimumPayment);
    }

    public GoldAccount(int accountId, LocalDateTime createdDate, LocalDateTime lastModified, double balance, List<TransactionHistory> transactionsHistory, double monthlyInterest, double minimumPayment)
    {
        super(accountId, createdDate, lastModified, balance, transactionsHistory, monthlyInterest, minimumPayment);
    }


    @Override
    public <T> void accept(T t) {
        CreditCardAccountVisitor visitor = (CreditCardAccountVisitor)t;
        visitor.visit(this);
    }
}
