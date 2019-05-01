package BinarySearchTree;

public class SortedLinkedListToBST {
    static LNode head;

    /* Link list Node */
    class LNode {
        int data;
        LNode next, prev;

        LNode(int d) {
            data = d;
            next = prev = null;
        }
    }

    /* A Binary Tree Node */
    class TNode {
        int data;
        TNode left, right;

        TNode(int d) {
            data = d;
            left = right = null;
        }
    }

    int countNodes(LNode head) {
        int count = 0;
        LNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    TNode sortedListToBST() {
        int n = countNodes(head);
        return sortedListToBSTRec(n);
    }

    TNode sortedListToBSTRec(int n) {
        if (n <= 0)
            return null;

        TNode left = sortedListToBSTRec(n / 2);

        TNode root = new TNode(head.data);

        root.left = left;
        head = head.next;

        root.right = sortedListToBSTRec(n - n / 2 - 1);

        return root;

    }

    /* Function to insert a node at the beginging of
       the Doubly Linked List */
    void push(int new_data) {
        /* allocate node */
        LNode new_node = new LNode(new_data);

        /* since we are adding at the begining,
           prev is always NULL */
        new_node.prev = null;

        /* link the old list off the new node */
        new_node.next = head;

        /* change prev of head node to new node */
        if (head != null)
            head.prev = new_node;

        /* move the head to point to the new node */
        head = new_node;
    }

    /* Function to print nodes in a given linked list */
    void printList(LNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(TNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        SortedLinkedListToBST llist = new SortedLinkedListToBST();

        /* Let us create a sorted linked list to test the functions
           Created linked list will be 7->6->5->4->3->2->1 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List ");
        llist.printList(head);

        /* Convert List to BST */
        TNode root = llist.sortedListToBST();
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);
    }
}
