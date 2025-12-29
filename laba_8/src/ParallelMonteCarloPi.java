import java.util.ArrayList;
import java.util.List;

public class ParallelMonteCarloPi {

    public static void main(String[] args) {
        int numThreads;
        try {
            numThreads = (args.length > 0) ? Integer.parseInt(args[0]) : Runtime.getRuntime().availableProcessors();
        } catch (NumberFormatException e) {
            System.err.println("Помилка: Аргумент має бути цілим числом.");
            return;
        }

        long totalIterations = 1_000_000_000L; 
        long iterationsPerThread = totalIterations / numThreads;

        List<MonteCarloWorker> workers = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numThreads; i++) {
            MonteCarloWorker worker = new MonteCarloWorker(iterationsPerThread);
            workers.add(worker);
            worker.start();
        }

        long totalHits = 0;
        try {
            for (MonteCarloWorker worker : workers) {
                worker.join();
                totalHits += worker.getHits();
            }
        } catch (InterruptedException e) {
            System.err.println("Обчислення перервано: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();

        double pi = 4.0 * totalHits / totalIterations;

        System.out.printf("PI is %.5f\n", pi);
        System.out.println("THREADS " + numThreads);
        System.out.printf("ITERATIONS %,d\n", totalIterations);
        System.out.println("TIME " + (endTime - startTime) + "ms");
    }
}