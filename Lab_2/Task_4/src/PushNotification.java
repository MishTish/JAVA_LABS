class PushNotification implements Notification {
    private String deviceToken;

    public PushNotification(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public void send() {
        Logger.getInstance().log("Sending Push Notification to device token: " + deviceToken);
    }
}