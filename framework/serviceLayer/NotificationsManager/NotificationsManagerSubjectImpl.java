package lab8.finalProject.framework.serviceLayer.NotificationsManager;


import lab8.finalProject.framework.dataLayer.models.accounts.Account;

import java.util.ArrayList;
import java.util.List;


public class NotificationsManagerSubjectImpl implements NotificationsManagerSubject
{
    private static List<NotificationsObserver> notificationsObservers = new ArrayList<>();

    public void registerObserver(NotificationsObserver observer)
    {
        notificationsObservers.add(observer);
    }
    public void removeObserver(NotificationsObserver observer)
    {
        notificationsObservers.remove(observer);
    }

    public void notifyObservers(Account account, String type)
    {
        for (NotificationsObserver observer : notificationsObservers)
        {
            observer.update(account, type);
        }
    }
}
