package lab8.finalProject.framework.dataLayer.models.basicData;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;

import java.util.List;

public class CorporateCustomer extends Customer
{
    private int employeesCount;

    public CorporateCustomer(int customerId, String name, String email, Address address, int employeesCount)
    {
        super(customerId, name, email, address);
        this.employeesCount = employeesCount;
    }

    public CorporateCustomer(int customerId, String name, String email, Address address, List<Account> customerAccounts, int employeesCount)
    {
        super(customerId, name, email, address, customerAccounts);
        this.employeesCount = employeesCount;
    }


    public int getEmployeesCount() {
        return employeesCount;
    }
}
