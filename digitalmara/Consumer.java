package digitalmara;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer {

    private static final ConcurrentHashMap<Integer, LocalDateTime> data = new ConcurrentHashMap<>();
    private static final AtomicBoolean isExecutorWaiting = new AtomicBoolean(true);
    private static final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void accept(int number) {
        if (isExecutorWaiting.get()) {
            System.out.println("Executor is waiting...");
            executorService.schedule(ClearingTask.getInstance(), 5, TimeUnit.SECONDS);
            isExecutorWaiting.set(false);
        }
        data.put(number, LocalDateTime.now());
    }

    public double mean() {
        LocalDateTime expirationTime = defineExpirationTime();
        return data.keySet().stream()
                .mapToInt(key -> key)
                .filter(key -> Optional.ofNullable(data.get(key))
                        .map(value -> value.isAfter(expirationTime))
                        .orElse(false))
                .average()
                .orElse(0.0);
    }

    private static LocalDateTime defineExpirationTime() {
        return LocalDateTime.now().minusSeconds(5L);
    }

    private static class ClearingTask extends Thread {

        private static class TaskHolder {
            public static final ClearingTask HOLDER_INSTANCE;

            static {
                HOLDER_INSTANCE = new ClearingTask();
                HOLDER_INSTANCE.setDaemon(true);
            }
        }

        public static ClearingTask getInstance() {
            return TaskHolder.HOLDER_INSTANCE;
        }

        @Override
        public void run() {
            System.out.println("Executor has been started...");
            LocalDateTime expirationTime = defineExpirationTime();
            data.keySet().stream()
                    .filter(key -> Optional.ofNullable(data.get(key))
                            .map(value -> value.isBefore(expirationTime))
                            .orElse(true))
                    .forEach(data::remove);
            System.out.printf("Data size is %d\n", data.size());
            isExecutorWaiting.set(true);
        }
    }
}
