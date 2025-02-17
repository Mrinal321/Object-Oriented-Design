import java.util.Scanner;

interface Notification{
    void notifyUser(String message);
}

class SMSNotification implements Notification {
    public void notifyUser(String message){
        System.out.println("SMS Notification");
        System.out.println(message);
    }    
}

class EmailNotification implements Notification {
    public void notifyUser(String message){
        System.out.println("Email Notification");
        System.out.println(message);
    } 
}

class PushNotification implements Notification {
    public void notifyUser(String message){
        System.out.println("Push Notification");
        System.out.println(message);
    } 
}

class NotificationFactory {
    public Notification getNotification(String notificationType){
        if(notificationType == null) return null;
        if(notificationType.equalsIgnoreCase("SMS")){
            return new SMSNotification();
        }
        if(notificationType.equalsIgnoreCase("Email")){
            return new EmailNotification();
        }
        if(notificationType.equalsIgnoreCase("Push")){
            return new PushNotification();
        }

        return null;
    }
}

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();

        Scanner obj = new Scanner(System.in);
        String name = obj.nextLine(); 
        obj.close();
        Notification notification1 = notificationFactory.getNotification("Email");
        notification1.notifyUser(name);

        Notification notification2 = notificationFactory.getNotification("SMS");
        notification2.notifyUser(name);

        // Notification notification3 = notificationFactory.getNotification("Push");
        // notification3.notifyUser();
        
    }
}
