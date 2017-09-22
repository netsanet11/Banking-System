package lab8.finalProject.framework.serviceLayer.customersManager;

import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.basicData.Customer;
import lab8.finalProject.framework.dataLayer.services.FrameworkDatabaseFacade;

class CustomersManagerImpl implements CustomersManager
{
    private FrameworkDatabaseFacade frameworkDatabaseFacade;

    CustomersManagerImpl(FrameworkDatabaseFacade frameworkDatabaseFacade)
    {
        this.frameworkDatabaseFacade = frameworkDatabaseFacade;
    }


    @Override
    public void addOrUpdateCustomer(Customer customer)
    {
        frameworkDatabaseFacade.addOrUpdateCustomer(customer);
    }

    @Override
    public Customer getCustomer(int customerID)
    {
        return frameworkDatabaseFacade.getCustomer(customerID);
    }

    @Override
    public void addAccount(int customerID, Account account)
    {
        Customer customer = frameworkDatabaseFacade.getCustomer(customerID);
        if(customer == null)
            throw new IllegalStateException("Customer Not Found!");

        customer.getAccounts().add(account);
    }
}
