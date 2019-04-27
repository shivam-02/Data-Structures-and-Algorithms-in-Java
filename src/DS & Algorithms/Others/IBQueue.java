import java.util.Queue;

public class IBQueue {
    public int front, rear, size;
    public int capacity;
    public int arr[];

    IBQueue(int capacity) {
        this.front = 0;
        this.rear = capacity - 1;
        this.size = 0;
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }

    boolean isFull(IBQueue queue) {
        return queue.size == queue.capacity;
    }

    boolean isEmpty(IBQueue queue) {
        return this.size == 0;
    }

    void enqueue(int item) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.arr[this.rear] = item;
        this.size += 1;
        System.out.println(item + " enqueued to queue");
    }

    int dequeue() {
        if (isEmpty(this))
            return -1;
        int item = this.arr[front];
        this.size = this.size - 1;
        this.front = (this.front + 1) % this.capacity;
        return item;
    }

    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.arr[this.front];
    }

    // Method to get rear of queue
    int rear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.arr[this.rear];
    }

    public static void main(String[] args) {
        IBQueue queue = new IBQueue(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() +
                " dequeued from queue\n");

        System.out.println("Front item is " +
                queue.front());

        System.out.println("Rear item is " +
                queue.rear());
    }
}


