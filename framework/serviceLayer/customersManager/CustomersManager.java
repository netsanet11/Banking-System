package lab8.finalProject.framework.serviceLayer.customersManager;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.basicData.Customer;

public interface CustomersManager
{
    void addOrUpdateCustomer(Customer customer);
    Customer getCustomer(int customerID);

    void addAccount(int customerID, Account account);
}
