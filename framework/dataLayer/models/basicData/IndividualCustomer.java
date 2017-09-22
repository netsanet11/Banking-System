package lab8.finalProject.framework.dataLayer.models.basicData;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;

import java.time.LocalDate;
import java.util.List;

public class IndividualCustomer extends Customer
{
    private LocalDate birthDate;

    public IndividualCustomer(int customerId, String name, String email, Address address, LocalDate birthDate)
    {
        super(customerId, name, email, address);
        this.birthDate = birthDate;
    }


    public LocalDate getBirthDate()
    {
        return birthDate;
    }
}
