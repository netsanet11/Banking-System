package lab8.finalProject.creditCardSystem.serviceLayer.creditAccountManager;


import lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails.CreditCardDetails;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails.CreditCardType;
import lab8.finalProject.creditCardSystem.dataLayer.services.CreditCardDatabaseFacade;

import java.util.HashMap;
import java.util.Map;

//=============================================
//Cache Proxy
//Package Level Protection - Encapsulation
//Factory
//=============================================

class CreditCardDetailsManagerImpl implements CreditCardDetailsManager
{
    private CreditCardDatabaseFacade creditCardDatabaseFacade;
    private Map<CreditCardType, CreditCardDetails> creditCardDetailsCache;

    CreditCardDetailsManagerImpl(CreditCardDatabaseFacade creditCardDatabaseFacade)
    {
        this.creditCardDatabaseFacade = creditCardDatabaseFacade;
        creditCardDetailsCache = new HashMap<>();
    }

    public CreditCardDetails getCreditCardDetails(CreditCardType creditCardType)
    {
        //=========================================================================
        //Get The CreditCardDetails From The Cache Else Get it From The Database
        //=========================================================================

        CreditCardDetails creditCardDetails = creditCardDetailsCache.get(creditCardType);

        if(creditCardDetails == null)
        {
            creditCardDetails = creditCardDatabaseFacade.getCreditAccountsDetails(creditCardType);
        }

        creditCardDetailsCache.putIfAbsent(creditCardType, creditCardDetails);

        return creditCardDetails;
    }
}
