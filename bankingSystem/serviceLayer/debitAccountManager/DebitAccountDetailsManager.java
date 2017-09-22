package lab8.finalProject.bankingSystem.serviceLayer.debitAccountManager;


import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails.DebitAccountDetails;
import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails.DebitAccountType;

public interface DebitAccountDetailsManager
{
    DebitAccountDetails getDebitAccountsDetails(DebitAccountType debitAccountType);
}
