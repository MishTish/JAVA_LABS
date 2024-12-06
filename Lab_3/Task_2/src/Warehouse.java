public class Warehouse {
    private int stock;

    public Warehouse(int initialStock) {
        this.stock = initialStock;
    }


    public synchronized void sell(int quantity, int registerId, String customerName) {
        if (stock >= quantity) {
            System.out.println("Cash Register " + registerId + " processing sale of " + quantity + " items for " + customerName);
            stock -= quantity;
            System.out.println("Cash Register " + registerId + " completed sale. Remaining stock: " + stock);
        } else {
            System.out.println("Cash Register " + registerId + ": Not enough stock for " + customerName + ". Requested: " + quantity + ", Available: " + stock);
        }
    }


    public int getStock() {
        return stock;
    }
}