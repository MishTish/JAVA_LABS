class EmailNotification implements Notification {
    private String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send() {
        Logger.getInstance().log("Sending Email to " + emailAddress);
    }
}