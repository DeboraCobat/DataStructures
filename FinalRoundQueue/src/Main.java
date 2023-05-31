import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RoundFIFOQueue<String> queue = new RoundFIFOQueue<>(5);
        queue.enqueue("Carla");
        queue.enqueue("Jonas");
        queue.enqueue("Anna");

        System.out.println("Queue size: " + queue.size());
        System.out.println("Elements in the queue: " + Arrays.toString(queue.toArray(new String[0])));

        String dequeuedElement = queue.dequeue();
        System.out.println("Dequeued element: " + dequeuedElement);

        System.out.println("Queue size after dequeue: " + queue.size());
        System.out.println("Elements in the queue after dequeue: " + Arrays.toString(queue.toArray(new String[0])));
    }
}
