package multithreading;

public class PingPong {
    private static String prevPunch = "pong";
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread ping = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    synchronized (lock) {
                        while (prevPunch.equals("ping")) {
                            lock.wait();
                        }
                        System.out.println("ping");
                        prevPunch = "ping";
                        lock.notify();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        Thread pong = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    synchronized (lock) {
                        while (prevPunch.equals("pong")) {
                            lock.wait();
                        }
                        System.out.println("pong");
                        prevPunch = "pong";
                        lock.notify();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        ping.setDaemon(true);
        pong.setDaemon(true);
        ping.start();
        pong.start();

        Thread.sleep(5000);
    }
}
