package lab8.finalProject.bankingSystem.dataLayer.services;


import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails.DebitAccountDetails;
import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails.DebitAccountType;


public interface DebitAccountDatabaseFacade
{
    DebitAccountDetails getDebitAccountsDetails(DebitAccountType debitAccountType);
}
