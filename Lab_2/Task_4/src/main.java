import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewsAgency newsAgency = new NewsAgency();
        Logger.getInstance().log("Application initiated.");
        while (true) {

            System.out.println("\nApplication Menu");
            System.out.println("1. Send Notification");
            System.out.println("2. Add News Subscriber");
            System.out.println("3. Remove News Subscriber");
            System.out.println("4. List all subscribers");
            System.out.println("5. Generate News");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();


            switch (choice) {
                case "1": {
                    System.out.print("Enter notification type (email/sms/push): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter recipient (email/phone/device token): ");
                    String recipient = scanner.nextLine();
                    try {
                        Notification notification = NotificationFactory.createNotification(type, recipient);
                        notification.send();
                    } catch (IllegalArgumentException e) {
                        Logger.getInstance().log("Error: " + e.getMessage());
                    }
                    break;
                }
                case "2": {
                    System.out.print("Enter subscriber name: ");
                    String name = scanner.nextLine();
                    NewsSubscriber subscriber = new NewsSubscriber(name);
                    newsAgency.addSubscriber(subscriber);
                    break;
                }
                case "3": {
                    System.out.print("Enter subscriber name to remove: ");
                    String name = scanner.nextLine();
                    newsAgency.removeSubscriber(name);
                    break;
                }
                case "4": {
                    System.out.println("List of all subscribers:");
                    if (newsAgency.getSubscribers().isEmpty()) {
                        System.out.println("No subscribers found.");
                    } else {
                        newsAgency.getSubscribers().forEach((k, v) -> System.out.println(v));
                    }
                    break;
                }
                case "5": {
                    System.out.print("Enter news to generate: ");
                    String news = scanner.nextLine();
                    newsAgency.notifySubscribers(news);
                    break;
                }
                case "6": {
                    Logger.getInstance().log("Application terminated");
                    scanner.close();
                    return;
                }
                default: {
                    Logger.getInstance().log("Invalid input.");
                }
            }
        }
    }
}
