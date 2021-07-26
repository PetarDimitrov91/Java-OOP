import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long number = 10;

        Thread thread = new Thread();

        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<Long> futureTask = threadPool.submit(() -> factorial(number));

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        long result = futureTask.get();
        System.out.println(result);
        threadPool.shutdown();
    }

    private static Long factorial(long number) {
        long factorial = 0;

        for (int i = 1; i <= number; i++) {
            factorial += factorial * i;
        }
        return factorial;
    }
}
