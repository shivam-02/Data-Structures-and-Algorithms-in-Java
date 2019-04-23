package Queue;

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int item) {
        s1.push(item);
        System.out.println(item + " enqueued to the queue");
    }

    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        System.out.println(s2.peek() + " dequeued from queue");
        return s2.pop();
    }

    public static void main(String gg[]) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(5);
        q.enqueue(4);
        q.enqueue(9);
        q.enqueue(1);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }

}
