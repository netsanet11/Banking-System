package lab8.finalProject.framework.dataLayer.models.basicData;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer
{
    private int customerId;
    private String name;
    private Address address;
    private String email;
    private byte[] rowVer;
    private List<Account> accounts;


    public Customer(int customerId, String name, String email, Address address)
    {
        this(customerId, name, email, address, new ArrayList<>());
    }

    public Customer(int customerId, String name, String email, Address address, List<Account> accounts)
    {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.rowVer = null;
        this.accounts = accounts;
    }


    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getRowVer() {
        return rowVer;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
