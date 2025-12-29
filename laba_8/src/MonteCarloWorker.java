import java.util.concurrent.ThreadLocalRandom;


public class MonteCarloWorker extends Thread {
    private final long iterations;
    private long hits = 0;

    public MonteCarloWorker(long iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        
        for (long i = 0; i < iterations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            
            if (x * x + y * y <= 1.0) {
                hits++;
            }
        }
    }

    public long getHits() {
        return hits;
    }
}