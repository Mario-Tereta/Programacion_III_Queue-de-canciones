package umg.edu.gt.data_structure.queue.manual;

public class QueueLinked<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // O(1)
    public void enqueue(T value) {

        Node<T> node = new Node<>(value);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    // O(1)
    public T dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }

        T value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;

        return value;
    }

    public T peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }

        return head.value;
    }
}