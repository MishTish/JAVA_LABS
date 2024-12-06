import java.util.Random;

public class Customer implements Runnable {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Customer " + name + " is waiting to be served.");
        try {
            // Simulate waiting or shopping time
            Thread.sleep(new Random().nextInt(2000) + 500); // Random delay between 0.5 and 2 seconds
        } catch (InterruptedException e) {
            System.err.println("Customer " + name + " interrupted.");
        }
        System.out.println("Customer " + name + " is ready to check out.");
    }
}
