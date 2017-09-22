package lab8.finalProject.creditCardSystem.serviceLayer.accountVisitor;


import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.BronzeAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.GoldAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.SilverAccount;

public class CreditCardInterestVisitor implements CreditCardAccountVisitor
{
    @Override
    public void visit(BronzeAccount account) {
        account.setInterestValue(account.getBalance() * account.getInterestRate());
    }

    @Override
    public void visit(SilverAccount account) {
        account.setInterestValue(account.getBalance() * account.getInterestRate());

    }

    @Override
    public void visit(GoldAccount account) {
        account.setInterestValue(account.getBalance() * account.getInterestRate());
    }
}
