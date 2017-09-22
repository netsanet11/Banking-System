package lab8.finalProject.framework.serviceLayer.NotificationsManager;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;


public interface NotificationsObserver
{
    void update(Account account, String type);
}
