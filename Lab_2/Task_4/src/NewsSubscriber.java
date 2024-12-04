class NewsSubscriber implements Subscriber {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String news) {
        Logger.getInstance().log("News for " + name + ": " + news);
    }

    @Override
    public String toString() {
        return "[name: '" + name + "']";
    }

}
