class SMSNotification implements Notification {
    private String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        Logger.getInstance().log("Sending SMS to " + phoneNumber);
    }
}