public class SplitCircularLinkedList {
   static Node head, head1, head2;

   static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public void splitHalves(Node head){
        if(head==null || head.next==null)return;

        Node slow=head;
        Node fast=head;
        while(fast.next!=head && fast.next.next!=head){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast.next.next==head)fast=fast.next;
        head1=head;
        if(head.next!=head){
            head2=slow.next;
        }

        fast.next=head2;
        slow.next=head1;
    }

    void printList(Node node) {
        Node temp = node;
        if (node != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != node);
        }
    }

    public static void main(String[] args) {
        SplitCircularLinkedList list = new SplitCircularLinkedList();

        //Created linked list will be 12->56->2->11
        list.head = new Node(12);
        list.head.next = new Node(56);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = list.head;

        System.out.println("Original Circular Linked list ");
        list.printList(head);

        // Split the list
        list.splitHalves(head);
        System.out.println("");
        System.out.println("First Circular List ");
        list.printList(head1);
        System.out.println("");
        System.out.println("Second Circular List ");
        list.printList(head2);

    }


}
