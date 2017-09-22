package lab8.finalProject.framework.serviceLayer.NotificationsManager;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;

public class EmailSenderObserverImpl implements NotificationsObserver
{
    public EmailSenderObserverImpl(NotificationsManagerSubject notificationsManagerSubject)
    {
        notificationsManagerSubject.registerObserver(this);
    }

    @Override
    public void update(Account account, String type) {
        sendEmail(account, type);
    }

    public void sendEmail(Account account, String type){
        System.out.println("Your account with " + account.getAccountId() + " has new balance equal " + account.getBalance() + " by " + type);
    }


}
