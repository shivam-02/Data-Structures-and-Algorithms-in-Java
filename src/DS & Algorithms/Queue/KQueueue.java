package Queue;

public class KQueueue {
    int arr[];
    int front[];
    int rear[];
    int next[];
    int free = 0;

    KQueueue(int n, int k) {
        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }
        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;
        next[n - 1] = -1;
    }

    public boolean isFull() {
        return free == -1;
    }

    public boolean isEmpty(int k) {
        return front[k] == -1;
    }

    public void enqueue(int item, int k) {

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        int nextFree = next[free];
        if (isEmpty(k)) {
            rear[k] = front[k] = free;
        } else {
            next[rear[k]] = free;
            rear[k] = free;
        }
        next[free] = -1;
        arr[free] = item;
        free = nextFree;
        System.out.println(item + " enqueued to queue");

    }

    public int dequeue(int k) {
        if (isEmpty(k)) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int frontIndex = front[k];
        front[k] = next[frontIndex];
        next[frontIndex] = free;
        free = frontIndex;
        return arr[frontIndex];
    }

    public static void main(String[] args) {
        // Let us create 3 queue in an array of size 10
        int k = 3, n = 10;
        KQueueue ks = new KQueueue(k, n);


        // Let us put some items in queue number 2
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);

        // Let us put some items in queue number 1
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);

        // Let us put some items in queue number 0
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);

        System.out.println("Dequeued element from queue 2 is " +
                ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " +
                ks.dequeue(1));
        System.out.println("Dequeued element from queue 0 is " +
                ks.dequeue(0));

    }
}
