import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoundFIFOQueueTest {
    @Test
    void testEnqueueDequeue() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assertions.assertEquals(1, queue.dequeue());
        Assertions.assertEquals(2, queue.dequeue());
        Assertions.assertEquals(3, queue.dequeue());
    }

    @Test
    void testEnqueueFullQueue() {
        RoundFIFOQueue<String> queue = new RoundFIFOQueue<>(2);
        queue.enqueue("A");
        queue.enqueue("B");

        Assertions.assertThrows(RuntimeException.class, () -> queue.enqueue("C"));
    }

    @Test
    void testDequeueEmptyQueue() {
        RoundFIFOQueue<Double> queue = new RoundFIFOQueue<>(3);

        Assertions.assertThrows(RuntimeException.class, queue::dequeue);
    }

    @Test
    void testSize() {
        RoundFIFOQueue<String> queue = new RoundFIFOQueue<>(5);
        Assertions.assertEquals(0, queue.size());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        Assertions.assertEquals(3, queue.size());

        queue.dequeue();
        queue.dequeue();

        Assertions.assertEquals(1, queue.size());
    }

    @Test
    void testToArray() {
        RoundFIFOQueue<Character> queue = new RoundFIFOQueue<>(4);
        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');

        Character[] array = queue.toArray(new Character[0]);
        Assertions.assertArrayEquals(new Character[]{'A', 'B', 'C'}, array);
    }

    @Test
    void testCountValues() {
        RoundFIFOQueue<String> queue = new RoundFIFOQueue<>(4);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("A");
        queue.enqueue("C");

        Assertions.assertEquals(2, queue.countValues("A"));
        Assertions.assertEquals(1, queue.countValues("B"));
        Assertions.assertEquals(1, queue.countValues("C"));
        Assertions.assertEquals(0, queue.countValues("D"));
    }

    @Test
    void testIterator() {
        RoundFIFOQueue<Integer> queue = new RoundFIFOQueue<>(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        int sum = 0;
        for (int num : queue) {
            sum += num;
        }

        Assertions.assertEquals(6, sum);
    }
}
