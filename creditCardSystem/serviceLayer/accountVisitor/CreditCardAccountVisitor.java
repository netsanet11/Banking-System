package lab8.finalProject.creditCardSystem.serviceLayer.accountVisitor;


import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.BronzeAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.GoldAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.SilverAccount;

public interface CreditCardAccountVisitor {
    void visit(BronzeAccount account);
    void visit(SilverAccount account);
    void visit(GoldAccount account);
}
