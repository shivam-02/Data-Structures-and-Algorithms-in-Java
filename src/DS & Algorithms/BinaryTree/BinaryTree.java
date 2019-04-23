package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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


    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.key+" ");
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

        int key = 12;
        insert(key);

        System.out.print("\nInorder traversal after insertion:");
        inorder(root);
    }
}

