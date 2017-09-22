package lab8.finalProject.creditCardSystem.serviceLayer.creditAccountManager;

//=====================
//Factory Pattern
//Singleton
//=====================


import lab8.finalProject.creditCardSystem.dataLayer.services.CreditCardDatabaseFacade;

public class CreditCardDetailsManagerFactory
{
    private CreditCardDetailsManagerFactory()
    {

    }

    private volatile static CreditCardDetailsManager creditCardDetailsManagerInstance;

    public static CreditCardDetailsManager getInstance(CreditCardDatabaseFacade creditCardDatabaseFacade)
    {
        if(creditCardDetailsManagerInstance == null)
        {
            synchronized(CreditCardDetailsManagerFactory.class)
            {
                if(creditCardDetailsManagerInstance == null)
                    creditCardDetailsManagerInstance = new CreditCardDetailsManagerImpl(creditCardDatabaseFacade);
            }
        }

        return creditCardDetailsManagerInstance;
    }
}
