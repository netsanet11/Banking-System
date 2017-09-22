package lab8.finalProject.creditCardSystem.dataLayer.services;


import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.BronzeAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.GoldAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditAccountsTypes.SilverAccount;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails.CreditCardDetails;
import lab8.finalProject.creditCardSystem.dataLayer.models.creditCardDetails.CreditCardType;
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

public class CreditCardDatabaseFacadeImpl extends FrameworkDatabaseFacade implements CreditCardDatabaseFacade
{
    @Override
    public CreditCardDetails getCreditAccountsDetails(CreditCardType creditCardType)
    {
        switch (creditCardType) {
            case GOLD:
                return new CreditCardDetails(1, CreditCardType.GOLD, 0.06, 0.10);

            case SILVER:
                return new CreditCardDetails(1, CreditCardType.SILVER, 0.08, 0.12);

            case BRONZE:
                return new CreditCardDetails(1, CreditCardType.BRONZE, 0.10, 0.14);

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
                transactionHistoryList.add(new TransactionHistory(3000 + j, LocalDateTime.now(), "TestData_" + j, new Random().nextDouble()));
            }

            accounts.add(new GoldAccount(300 + index, LocalDateTime.now(), LocalDateTime.now(),
                    transactionHistoryList.stream().mapToDouble(s->s.getAmount()).sum(),
                    transactionHistoryList,
                    getCreditAccountsDetails(CreditCardType.GOLD).getMonthlyInterest(),
                    getCreditAccountsDetails(CreditCardType.GOLD).getMinimumPayment()));
        }

        for (int index = 1 ; index <= 5 ; index++)
        {
            List<TransactionHistory> transactionHistoryList = new ArrayList<>();

            for (int j=1; j<=20; j++)
            {
                transactionHistoryList.add(new TransactionHistory(4000 + j, LocalDateTime.now(), "TestData_" + j, new Random().nextDouble()));
            }

            accounts.add(new SilverAccount(400 + index, LocalDateTime.now(), LocalDateTime.now(),
                    transactionHistoryList.stream().mapToDouble(s->s.getAmount()).sum(),
                    transactionHistoryList,
                    getCreditAccountsDetails(CreditCardType.SILVER).getMonthlyInterest(),
                    getCreditAccountsDetails(CreditCardType.SILVER).getMinimumPayment()));
        }

        for (int index = 1 ; index <= 5 ; index++)
        {
            List<TransactionHistory> transactionHistoryList = new ArrayList<>();

            for (int j=1; j<=20; j++)
            {
                transactionHistoryList.add(new TransactionHistory(5000 + j, LocalDateTime.now(), "TestData_" + j, new Random().nextDouble()));
            }

            accounts.add(new BronzeAccount(500 + index, LocalDateTime.now(), LocalDateTime.now(),
                    transactionHistoryList.stream().mapToDouble(s->s.getAmount()).sum(),
                    transactionHistoryList,
                    getCreditAccountsDetails(CreditCardType.BRONZE).getMonthlyInterest(),
                    getCreditAccountsDetails(CreditCardType.BRONZE).getMinimumPayment()));
        }

        return accounts;
    }
}
