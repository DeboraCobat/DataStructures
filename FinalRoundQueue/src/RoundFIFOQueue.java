import java.util.Iterator;

public class RoundFIFOQueue<T extends Comparable<T>> implements Iterable<T> {
    private class Node {
        T value;
        Node next;
        int debugId;
    }

    private Node enqueue;
    private Node dequeue;
    private int size;
    private final int maxSize;

    public RoundFIFOQueue(int maxSize) {
        this.maxSize = maxSize;
        this.enqueue = null;
        this.dequeue = null;
        this.size = 0;

        for (int i = 0; i < maxSize; i++) {
            Node newNode = new Node();
            newNode.debugId = i;
            if (enqueue == null) {
                enqueue = newNode;
                dequeue = newNode;
                enqueue.next = dequeue;
            } else {
                enqueue.next = newNode;
                enqueue = newNode;
                enqueue.next = dequeue;
            }
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node current = enqueue.next;
        int count = 0;
        while (count < maxSize) {
            System.out.println("Node #" + current.debugId + ": " + current.value);
            current = current.next;
            count++;
        }

        if (current != enqueue) {
            throw new RuntimeException("Internal error: queue may not be circular");
        }
    }

    public void enqueue(T value) {
        if (isFull()) {
            throw new RuntimeException("No space in the queue");
        }

        enqueue = enqueue.next;
        enqueue.value = value;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        T value = dequeue.value;
        dequeue = dequeue.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public T[] toArray(T[] template) {
        if (isEmpty()) {
            return template;
        }

        int count = 0;
        Node current = enqueue;
        while (count < size) {
            template[count] = current.value;
            current = current.next;
            count++;
        }
        return template;
    }

    public int countValues(T value) {
        int count = 0;
        Node current = enqueue;
        for (int i = 0; i < size; i++) {
            if (current.value.compareTo(value) == 0) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundQueueIterator();
    }

    private class RoundQueueIterator implements Iterator<T> {
        private Node current = dequeue;
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            count++;
            return value;
        }
    }
}
