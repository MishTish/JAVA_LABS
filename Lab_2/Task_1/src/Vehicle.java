public abstract class Vehicle {
    protected String maker;
    protected String model;
    protected int year;
    public Vehicle(String maker, String model, int year) {
        this.maker = maker;
        this.model = model;
        this.year = year;
    }
    public abstract void start();
    public abstract void stop();

    @Override
    public String toString() {
        return this.getClass().getName() + ": [Maker: " + maker + " Model: " + model + " Year: " + year + "]";
    }
}
