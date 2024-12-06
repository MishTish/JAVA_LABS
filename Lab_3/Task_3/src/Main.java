import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(17, 19, 23, 24, 29, 31, 33, 37, 41, 42, 43, 44, 47, 51, 53, 59);

        int Threads = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(Threads);

        ConcurrentHashMap<Integer, Boolean> results = new ConcurrentHashMap<>();


        for (int number : numbers) {
            executorService.submit(() -> {
                boolean isPrime = isPrime(number);
                results.put(number, isPrime);
                System.out.println(Thread.currentThread().getName() + " processed " + number + ": " + isPrime);
            }
            );
        }


        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Tasks interrupted.");
        }


        System.out.println("\nResults:");
        results.forEach((number, isPrime) -> System.out.println(number + ": " + (isPrime ? "Prime" : "Not Prime")));
    }


    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
}
