package lab8.finalProject.bankingSystem.dataLayer.services;


import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails.DebitAccountDetails;
import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountDetails.DebitAccountType;
import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes.CheckingAccount;
import lab8.finalProject.bankingSystem.dataLayer.models.debitAccountsTypes.SavingAccount;
import lab8.finalProject.framework.dataLayer.models.accounts.Account;
import lab8.finalProject.framework.dataLayer.models.accounts.TransactionHistory;
import lab8.finalProject.framework.dataLayer.services.FrameworkDatabaseFacade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//========================
//Factory Method Pattern
//=========================

public class DebitAccountDatabaseFacadeImpl extends FrameworkDatabaseFacade implements DebitAccountDatabaseFacade
{
    @Override
    public DebitAccountDetails getDebitAccountsDetails(DebitAccountType debitAccountType)
    {
        switch (debitAccountType) {
            case CHECKING:
                return new DebitAccountDetails(1, DebitAccountType.CHECKING, 0.0);

            case SAVING:
                return new DebitAccountDetails(1, DebitAccountType.SAVING, 1.1);

            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    protected List<Account> BuildMockCustomersAccounts()
    {
        List<Account> accounts = new ArrayList<>();

        for (int index = 1 ; index <= 5 ; index++)
        {
            List<TransactionHistory> transactionHistoryList = new ArrayList<>();

            for (int j=1; j<=20; j++)
            {
                transactionHistoryList.add(new TransactionHistory(1000 + j, LocalDateTime.now(), "TestData_" + j, new Random().nextDouble()));
            }

            accounts.add(new SavingAccount(100 + index, LocalDateTime.now(), LocalDateTime.now(),
                    transactionHistoryList.stream().mapToDouble(s->s.getAmount()).sum(),
                    transactionHistoryList,
                    getDebitAccountsDetails(DebitAccountType.SAVING).getMonthlyInterest()));
        }

        for (int index = 1 ; index <= 5 ; index++)
        {
            List<TransactionHistory> transactionHistoryList = new ArrayList<>();

            for (int j=1; j<=20; j++)
            {
                transactionHistoryList.add(new TransactionHistory(2000 + j, LocalDateTime.now(), "TestData_" + j, new Random().nextDouble()));
            }

            accounts.add(new CheckingAccount(200 + index, LocalDateTime.now(), LocalDateTime.now(),
                    transactionHistoryList.stream().mapToDouble(s->s.getAmount()).sum(),
                    transactionHistoryList,
                    getDebitAccountsDetails(DebitAccountType.CHECKING).getMonthlyInterest()));
        }

        return accounts;
    }
}
