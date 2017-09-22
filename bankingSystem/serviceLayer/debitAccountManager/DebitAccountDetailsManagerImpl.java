package lab8.finalProject.bankingSystem.serviceLayer.debitAccountManager;


import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails.DebitAccountDetails;
import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails.DebitAccountType;
import lab8.finalProject.bankingSystem.dataLayer.services.DebitAccountDatabaseFacade;

import java.util.HashMap;
import java.util.Map;

//=============================================
//Cache Proxy
//Package Level Protection - Encapsulation
//Factory
//=============================================

class DebitAccountDetailsManagerImpl implements DebitAccountDetailsManager
{
    private DebitAccountDatabaseFacade debitAccountDatabaseFacade;
    private Map<DebitAccountType, DebitAccountDetails> debitAccountDetailsCache;

    DebitAccountDetailsManagerImpl(DebitAccountDatabaseFacade debitAccountDatabaseFacade)
    {
        this.debitAccountDatabaseFacade = debitAccountDatabaseFacade;
        debitAccountDetailsCache = new HashMap<>();
    }

    public DebitAccountDetails getDebitAccountsDetails(DebitAccountType debitAccountType)
    {
        //=========================================================================
        //Get The CreditCardDetails From The Cache Else Get it From The Database
        //=========================================================================

        DebitAccountDetails debitAccountDetails = debitAccountDetailsCache.get(debitAccountType);

        if(debitAccountDetails == null)
        {
            debitAccountDetails = debitAccountDatabaseFacade.getDebitAccountsDetails(debitAccountType);
        }

        debitAccountDetailsCache.putIfAbsent(debitAccountType, debitAccountDetails);

        return debitAccountDetails;
    }
}
