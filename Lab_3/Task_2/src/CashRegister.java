import java.util.Random;

public class CashRegister extends Thread {
    private final int registerId;
    private final String customerName;
    private final Warehouse warehouse;

    public CashRegister(int registerId, String customerName, Warehouse warehouse) {
        this.registerId = registerId;
        this.customerName = customerName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        System.out.println("Cash Register " + registerId + " started serving " + customerName);
        try {

            Thread.sleep(new Random().nextInt(3000) + 1000);

            int quantity = new Random().nextInt(10) + 1;
            warehouse.sell(quantity, registerId, customerName);

        } catch (InterruptedException e) {
            System.err.println("Cash Register " + registerId + " interrupted.");
        }
        System.out.println("Cash Register " + registerId + " finished serving " + customerName);
    }
}