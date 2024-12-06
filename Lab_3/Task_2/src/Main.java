public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(50);
        String[] customers = {"Bob", "John", "Michael", "Olivia"};

        Thread[] cashRegisters = new Thread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashRegisters[i] = new CashRegister(i + 1, customers[i], warehouse);
            cashRegisters[i].start();
        }

        for (Thread register : cashRegisters) {
            try {
                register.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted while waiting for completion.");
            }
        }

        System.out.println("All customers have been served. Final stock: " + warehouse.getStock());
    }
}


