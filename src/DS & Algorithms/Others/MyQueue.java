public class MyQueue {
    int front, rear, size;
    int capacity;
    int arr[];

    MyQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = size = 0;
        rear = this.capacity - 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Overflow condition");
        } else {
            this.rear = (this.rear + 1) % this.capacity;
            arr[rear] = item;
            this.size++;
            System.out.println(item + " enqueued to queue");
        }
    }

    public int dequeue() {
        if (isEmpty()) return Integer.MIN_VALUE;

        int item = arr[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    public int front() {
        return arr[front];
    }

    public int rear() {
        return arr[rear];
    }

    public static void main(String gg[]) {

        MyQueue queue = new MyQueue(1000);

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