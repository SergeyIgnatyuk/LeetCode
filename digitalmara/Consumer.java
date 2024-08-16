package digitalmara;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class Consumer implements AutoCloseable {
    private final CountDownLatch latch = new CountDownLatch(1);
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private static final ConcurrentHashMap<LocalDateTime, Integer> data = new ConcurrentHashMap<>();

    public void accept(int number) {
        if (latch.getCount() != 0) {
            System.out.println("Executor is waiting...");
            executorService.scheduleAtFixedRate(ClearingTask.getInstance(), 5,5, TimeUnit.MINUTES);
            latch.countDown();
        }
        data.put(LocalDateTime.now(), number);
        System.out.printf("%d has been added\n", number);
    }

    public double mean() {
        double average = data.values().stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
        System.out.printf("Average is %s\n", average);
        return average;
    }

    private static LocalDateTime defineExpirationTime() {
        return LocalDateTime.now().minusMinutes(5L);
    }

    @Override
    public void close() {
        executorService.shutdown();
    }

    private static class ClearingTask implements Runnable {

        private static class TaskHolder {
            public static final ClearingTask HOLDER_INSTANCE = new ClearingTask();
        }

        public static ClearingTask getInstance() {
            return TaskHolder.HOLDER_INSTANCE;
        }

        @Override
        public void run() {
            System.out.println("Executor has been started...");
            LocalDateTime expirationTime = defineExpirationTime();
            data.entrySet().stream()
                    .filter(entry -> entry.getKey().isBefore(expirationTime))
                    .forEach(entry -> {
                        data.remove(entry.getKey());
                        System.out.printf("%d has been removed\n", entry.getValue());
                    });
            System.out.printf("Data size is %d\n", data.size());
        }
    }
}
