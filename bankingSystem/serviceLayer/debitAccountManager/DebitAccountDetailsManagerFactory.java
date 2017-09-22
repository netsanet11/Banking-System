package lab8.finalProject.bankingSystem.serviceLayer.debitAccountManager;

//=====================
//Factory Pattern
//Singleton
//=====================


import lab8.finalProject.bankingSystem.dataLayer.services.DebitAccountDatabaseFacade;

public class DebitAccountDetailsManagerFactory
{
    private DebitAccountDetailsManagerFactory()
    {

    }

    private volatile static DebitAccountDetailsManager DebitAccountDetailsManagerInstance;

    public static DebitAccountDetailsManager getInstance(DebitAccountDatabaseFacade debitAccountDatabaseFacade)
    {
        if(DebitAccountDetailsManagerInstance == null)
        {
            synchronized(DebitAccountDetailsManagerFactory.class)
            {
                if(DebitAccountDetailsManagerInstance == null)
                    DebitAccountDetailsManagerInstance = new DebitAccountDetailsManagerImpl(debitAccountDatabaseFacade);
            }
        }

        return DebitAccountDetailsManagerInstance;
    }
}
