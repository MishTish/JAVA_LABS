class NotificationFactory {
    public static Notification createNotification(String type, String recipient) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification(recipient);
            case "sms" -> new SMSNotification(recipient);
            case "push" -> new PushNotification(recipient);
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}