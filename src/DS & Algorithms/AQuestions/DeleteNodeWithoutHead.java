package AQuestions;

public class DeleteNodeWithoutHead {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void deleteNode(Node del) {
        Node prev = null;
        while (del.next != null) {
            del.data = del.next.data;
            prev = del;
            del = del.next;
        }
        prev.next = null;
    }
}
