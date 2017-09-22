package lab8.finalProject.creditCardSystem.dataLayer.services;


import lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails.CreditCardDetails;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails.CreditCardType;

public interface CreditCardDatabaseFacade
{
    CreditCardDetails getCreditAccountsDetails(CreditCardType creditCardType);
}
