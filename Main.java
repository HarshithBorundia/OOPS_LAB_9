import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int n = 3; // Number of producers
        final int m = 2; // Number of consumers
        Buffer buffer = new Buffer(5);
        
        List<Thread> producers = new ArrayList<>();
        List<Thread> consumers = new ArrayList<>();
        
        // Create and start n producers with varying rates
        for (int i = 0; i < n; i++) {
            int rate = i + 1; // Example rate, adjust as needed
            Producer producer = new Producer(buffer, rate);
            producers.add(producer);
            producer.start();
        }
        
        // Create and start m consumers with varying rates
        for (int i = 0; i < m; i++) {
            int rate = i + 1; // Example rate, adjust as needed
            Consumer consumer = new Consumer(buffer, rate);
            consumers.add(consumer);
            consumer.start();
        }
    }
}