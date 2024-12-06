import java.util.concurrent.*;

class FactorialCalculator implements Callable<Long> {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() {
        return calculateFactorial(number);
    }

    private Long calculateFactorial(int n) {
        if (n == 0 || n == 1) return 1L;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        System.out.println("Factorial of " + n + " calculated by " + Thread.currentThread().getName());
        return result;
    }
}