package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseBSTPath {
    static class Node {
        int key;
        Node right, left;

        Node(int key) {
            this.key = key;
            this.right = null;
            this.left = null;
        }
    }

    Node root;

    public void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public void reversePath(Node root, int key, Queue<Integer> queue) {
        if (root == null)
            return;
        if (root.key == key) {
            queue.add(root.key);
            root.key = queue.peek();
            queue.poll();
            return;
        } else if (root.key > key) {
            queue.add(root.key);
            reversePath(root.left, key, queue);
            root.key = queue.peek();
            queue.poll();
            return;
        } else if (root.key < key) {
            queue.add(root.key);
            reversePath(root.right, key, queue);
            root.key = queue.peek();
            queue.poll();
            return;
        }
    }

    public Node insert(Node root, int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return root;
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static void main(String gg[]) {

        ReverseBSTPath r = new ReverseBSTPath();
        r.root = r.insert(r.root, 50);
        r.insert(r.root, 30);
        r.insert(r.root, 20);
        r.insert(r.root, 40);
        r.insert(r.root, 70);
        r.insert(r.root, 60);
        r.insert(r.root, 80);
        System.out.println("Before Reversal");
        r.inorder(r.root);
        System.out.println("\nAfter Reversal");
        r.reversePath(r.root, 80, new LinkedList<Integer>());
        r.inorder(r.root);
    }
}
