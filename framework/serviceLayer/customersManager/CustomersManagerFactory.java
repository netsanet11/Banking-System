package lab8.finalProject.framework.serviceLayer.customersManager;

//=====================
//Factory Pattern
//Singleton
//=====================


import lab8.finalProject.framework.dataLayer.services.FrameworkDatabaseFacade;

public class CustomersManagerFactory
{
    private CustomersManagerFactory()
    {

    }

    private volatile static CustomersManager customersManagerInstance;

    public static CustomersManager getInstance(FrameworkDatabaseFacade frameworkDatabaseFacade)
    {
        if(customersManagerInstance == null)
        {
            synchronized(CustomersManagerFactory.class)
            {
                if(customersManagerInstance == null)
                    customersManagerInstance = new CustomersManagerImpl(frameworkDatabaseFacade);
            }
        }

        return customersManagerInstance;
    }
}
