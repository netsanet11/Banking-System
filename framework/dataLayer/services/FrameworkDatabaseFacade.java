package lab8.finalProject.framework.dataLayer.services;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.basicData.Address;
import lab8.finalProject.framework.dataLayer.models.basicData.CorporateCustomer;
import lab8.finalProject.framework.dataLayer.models.basicData.Customer;
import lab8.finalProject.framework.dataLayer.models.basicData.IndividualCustomer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//=====================================
//Simulate Reading From The Database
//=====================================

//=====================
//Factory Pattern
//Factory Method Pattern
//Singleton
//=====================

public abstract class FrameworkDatabaseFacade
{
    public static Map<Integer, Customer> customersHashMap;

    static
    {
        if(customersHashMap == null)
        {
            customersHashMap = new HashMap<>();
            initMockCustomerData();
        }
    }

    public FrameworkDatabaseFacade()
    {
        for (Customer customer:customersHashMap.values())
        {
            List<Account> accounts = BuildMockCustomersAccounts();
            customer.getAccounts().addAll(accounts);
        }
    }

    private static void initMockCustomerData()
    {
        for (int i=1; i<=30; i++)
        {
            customersHashMap.putIfAbsent(i, new IndividualCustomer(1, "Ahmed_" + i, "ahmed_" + i + "@msn.com",
                    new Address("Fairfield", "Iowa", 52557),
                    LocalDate.of(1990, 2, 6)));

            customersHashMap.putIfAbsent(i, new CorporateCustomer(1, "Ali_" + i, "ali_" + i + "@msn.com",
                    new Address("Fairfield", "Iowa", 52557), i));
        }
    }


    protected abstract List<Account> BuildMockCustomersAccounts();


    public void addOrUpdateCustomer(Customer customer)
    {
        customersHashMap.putIfAbsent(customer.getCustomerId(), customer);
    }

    public Customer getCustomer(int customerID)
    {
        return customersHashMap.get(customerID);
    }

    public List<Account> getAllAccounts()
    {
        List<Account> allAccounts = new ArrayList<>();

        for (Customer customer:customersHashMap.values())
        {
            allAccounts.addAll(customer.getAccounts());
        }

        return allAccounts;
    }

    public Account getAccount(int accountId)
    {
        return null;
    }
}
