package lab8.finalProject.framework.serviceLayer.NotificationsManager;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;


public interface NotificationsManagerSubject
{
    void registerObserver(NotificationsObserver observer);
    void removeObserver(NotificationsObserver observer);
    void notifyObservers(Account account, String type);
}
