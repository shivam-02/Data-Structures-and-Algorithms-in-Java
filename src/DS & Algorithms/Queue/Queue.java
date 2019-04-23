package Queue;

public class Queue {

    int arr[];
    int capacity;
    int size;
    int front;
    int rear;

    Queue(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = this.capacity - 1;
    }

    boolean isFull() {
        return this.size == this.capacity;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Overflow condition");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        arr[this.rear] = item;
        this.size++;
        System.out.println(item + " enqueued to the queue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow condition");
            return Integer.MIN_VALUE;
        }
        int item = this.arr[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        System.out.println(item + " dequeued from queue");
        return item;
    }

    public static void main(String gg[]) {
        Queue q = new Queue(10);
        q.enqueue(5);
        q.enqueue(8);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(11);
        q.enqueue(1);
        q.enqueue(9);
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
}
