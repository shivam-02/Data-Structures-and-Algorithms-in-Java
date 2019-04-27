package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ListNode {
    int data;
    ListNode next;

    ListNode(int d) {
        data = d;
        next = null;
    }
}

public class BinaryTree {
    static Node root;

    static class Node {
        int key;
        Node right;
        Node left;

        Node(int key) {
            this.key = key;
            this.right = null;
            this.left = null;
        }
    }

    public static void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp;
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                q.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    public static void deleteNode(Node root, int key) {

        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node keyNode = null;
        Node temp = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.key == key) {
                keyNode = temp;
            }
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        keyNode.key = temp.key;
        deleteDeepestNode(root, temp);
    }


    public static void deleteDeepestNode(Node root, Node del_node) {

        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.left != null) {
                if (temp.left == del_node) {
                    temp.left = null;
                } else {
                    queue.add(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right == del_node) {
                    temp.right = null;
                } else {
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void inorderIterative(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || stack.size() > 0) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    public Node convertLLToBinaryTree(Node root, ListNode head) {
        if (head == null) {
            root = null;
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(head.data));
        head = head.next;
        while (head != null) {
            root = queue.poll();
            Node leftChild = new Node(head.data);
            queue.add(leftChild);
            head = head.next;
            Node rightChild = null;
            if (head != null) {
                rightChild = new Node(head.data);
                queue.add(rightChild);
                head = head.next;
            }
            root.left = leftChild;
            root.right = rightChild;
        }
        return root;
    }

    public Node insertLevelOrder(int arr[], Node root, int i) {
        if (i < arr.length) {
            root = new Node(arr[i]);

            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }


    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void main(String args[]) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before insertion:");
        inorder(root);
        System.out.println();
        inorderIterative(root);


        int key = 12;
        insert(key);

        System.out.print("\nInorder traversal after insertion:");
        inorder(root);

        /*System.out.print("Inorder traversal before deletion:");
        inorder(root);
        deleteNode(root, 10);
        System.out.print("\nInorder traversal after deletion:");
        inorder(root);*/


    }
}

