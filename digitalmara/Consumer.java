package digitalmara;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer {

    private static final ConcurrentHashMap<LocalDateTime, Integer> data = new ConcurrentHashMap<>();
    private static final AtomicBoolean isExecutorWaiting = new AtomicBoolean(true);
    private static final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void accept(int number) {
        if (isExecutorWaiting.get()) {
            System.out.println("Executor is waiting...");
            executorService.schedule(ClearingTask.getInstance(), 5, TimeUnit.MINUTES);
            isExecutorWaiting.set(false);
        }
        data.put(LocalDateTime.now(), number);
        System.out.printf("%d has been added\n", number);
    }

    public double mean() {
        LocalDateTime expirationTime = defineExpirationTime();
        double average = data.entrySet().stream()
                .filter(entry -> entry.getKey().isAfter(expirationTime))
                .mapToInt(Map.Entry::getValue)
                .average()
                .orElse(0.0);
        System.out.printf("Average is %s\n", average);
        return average;
    }

    private static LocalDateTime defineExpirationTime() {
        return LocalDateTime.now().minusMinutes(5L);
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
            isExecutorWaiting.set(true);
        }
    }
}
