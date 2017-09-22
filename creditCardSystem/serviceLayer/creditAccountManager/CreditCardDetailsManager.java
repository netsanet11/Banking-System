package lab8.finalProject.creditCardSystem.serviceLayer.creditAccountManager;


import lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails.CreditCardDetails;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails.CreditCardType;

public interface CreditCardDetailsManager
{
    CreditCardDetails getCreditCardDetails(CreditCardType creditCardType);
}
