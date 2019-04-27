public class IBStackLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    Node push(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = n;
        }
        else {
            n.next = head;
            head = n;
        }
        System.out.println(x + " pushed to stack");
        return head;
    }

    int pop() {
        if (head == null) {
            System.out.println("Underflow condition");
            return Integer.MIN_VALUE;
        } else {
            int x = head.data;
            head = head.next;
            return x;
        }
    }

    public static void main(String args[]) {
        IBStackLL s = new IBStackLL();
        s.head=s.push(10);
        s.head=s.push(20);
        s.head=s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }

}
