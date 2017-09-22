package lab8.finalProject.creditCardSystem.serviceLayer.accountVisitor;


import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.BronzeAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.GoldAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.SilverAccount;

public class MinimumPaymentVisitor implements CreditCardAccountVisitor {

    @Override
    public void visit(BronzeAccount account) {
        account.setMinimumPaymentValue(account.getBalance() * account.getMinimumPaymentRate() );
    }

    @Override
    public void visit(SilverAccount account) {
        account.setMinimumPaymentValue(account.getBalance() * account.getMinimumPaymentRate() );
    }

    @Override
    public void visit(GoldAccount account) {
        account.setMinimumPaymentValue(account.getBalance() * account.getMinimumPaymentRate() );
    }

}
