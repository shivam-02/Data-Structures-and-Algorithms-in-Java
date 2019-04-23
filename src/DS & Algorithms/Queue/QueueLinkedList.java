package Queue;

public class QueueLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front;
    Node rear;

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(item + " enqueued to the queue");
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int item = this.front.data;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        System.out.println(item + " dequeud from the queue");
        return item;
    }

    public static void main(String gg[]) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(5);
        q.enqueue(2);
        q.enqueue(7);
        q.enqueue(9);
        q.enqueue(0);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
}
