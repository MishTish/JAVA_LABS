public class Main {
    public static void main(String[] args) {

        String[] customers = {"Bob", "John", "Michael", "Olivia"};
        Thread[] cashRegisters = new Thread[customers.length];

        for (int i = 0; i < customers.length; i++) {

            Thread customerThread = new Thread(new Customer(customers[i]));
            customerThread.start();

            cashRegisters[i] = new CashRegister(i + 1, customers[i]);
            cashRegisters[i].start();
        }

        for (Thread register : cashRegisters) {
            try {
                register.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted while waiting for completion.");
            }
        }

        System.out.println("All customers have been served.");
    }
}

