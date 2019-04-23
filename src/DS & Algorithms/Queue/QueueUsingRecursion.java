package Queue;

import java.util.Stack;

public class QueueUsingRecursion {

    Stack<Integer> s1 = new Stack<>();


    public void enqueue(int item) {
        s1.push(item);
        System.out.println(item + " enqueued to the queue");
    }

    public int dequeue() {

        int res = 0;

        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        if (s1.size() == 1) {
            return s1.pop();
        }

        if (!s1.isEmpty()) {
            int x = s1.pop();
            res = dequeue();

            s1.push(x);
        }
        return res;
    }

    public static void main(String gg[]) {
        QueueUsingRecursion q = new QueueUsingRecursion();
        q.enqueue(5);
        q.enqueue(4);
        q.enqueue(3);
        q.enqueue(2);
        System.out.println(q.dequeue() + " dequeued from the queue");
        System.out.println(q.dequeue() + " dequeued from the queue");
        System.out.println(q.dequeue() + " dequeued from the queue");
        System.out.println(q.dequeue() + " dequeued from the queue");
        System.out.println(q.dequeue() + " dequeued from the queue");


    }
}
