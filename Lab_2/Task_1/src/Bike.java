public class Bike extends Vehicle {
    public boolean canDoTricks;
    public Bike(String maker, String model, int year, boolean canDoTricks) {
        super(maker, model, year);
        this.canDoTricks = canDoTricks;

    }

    public void start() {
        System.out.printf("Bike %s has started", this.model);
    }
    public void stop() {
        System.out.printf("\nBike %s has stopped\n", this.model);
    }
    public void trick() {
        if (canDoTricks) {
            System.out.printf("Bike %s is doing tricks\n", this.model);
        }
        else {
            System.out.printf("Bike %s can't do tricks\n", this.model);
        }
    }
}
