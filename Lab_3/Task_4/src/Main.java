import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 7, 10, 12, 15);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Future<Long>> futures = new ArrayList<>();

        for (int number : numbers) {
            FactorialCalculator task = new FactorialCalculator(number);
            Future<Long> future = executorService.submit(task);
            futures.add(future);
        }

        System.out.println("Calculating factorials...");
        for (int i = 0; i < numbers.size(); i++) {
            try {
                Long result = futures.get(i).get(); // Block until result is available
                System.out.println("Factorial of " + numbers.get(i) + " is " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error occurred while calculating factorial for " + numbers.get(i));
            }
        }
        executorService.shutdown();
    }
}
