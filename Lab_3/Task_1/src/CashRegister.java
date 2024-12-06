import java.util.Random;

public class CashRegister extends Thread {
    private final int registerId;
    private final String customerName;

    public CashRegister(int registerId, String customerName) {
        this.registerId = registerId;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        System.out.println("Cash Register " + registerId + " started serving " + customerName);
        try {
            Thread.sleep(new Random().nextInt(3000) + 1000); // Random delay between 1 and 3 seconds
        } catch (InterruptedException e) {
            System.err.println("Cash Register " + registerId + " interrupted.");
        }
        System.out.println("Cash Register " + registerId + " finished serving " + customerName);
    }
}