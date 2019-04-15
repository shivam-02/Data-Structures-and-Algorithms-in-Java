public class DLL {
    Node head;

    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = null;
        }
    }


    public void delete(Node node) {

        if (node == head) {
            head = head.next;
            head.prev = null;
        } else {
            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
        }

    }

    public void reverse() {
       Node curr=head;
       Node prev=null;
       while(curr!=null){
           prev=curr.prev;
           curr.prev=curr.next;
           curr.next=prev;
           curr=curr.prev;
       }
       if(prev!=null){
           head=prev.prev;
       }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DLL list = new DLL();

        /* Let us create a sorted linked list to test the functions
         Created linked list will be 10->8->4->2 */
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);

        System.out.println("Original linked list ");
        list.printList(list.head);

        list.reverse();
        System.out.println("");
        System.out.println("The reversed Linked List is ");
        list.printList(list.head);
    }


}
