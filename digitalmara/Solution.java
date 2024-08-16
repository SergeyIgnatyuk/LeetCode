package digitalmara;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Consumer consumer = new Consumer();
        consumer.accept(1);
        Thread.sleep(1000);
        consumer.accept(2);
        Thread.sleep(1000);
        consumer.accept(3);
        Thread.sleep(1000);
        consumer.accept(4);
        Thread.sleep(1000);
        consumer.accept(Integer.valueOf(5));
        consumer.mean();
        Thread.sleep(1000);
        Thread.sleep(5000);
        consumer.accept(Integer.valueOf(5));
        Thread.sleep(1000);
        Thread.sleep(1000);
        consumer.accept(4);
        Thread.sleep(1000);
        consumer.accept(8);
        consumer.mean();
        Thread.sleep(5000);
        consumer.accept(10);
        consumer.mean();
    }
}
