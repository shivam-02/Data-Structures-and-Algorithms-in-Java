package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
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

    public static boolean isCompleteBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                if (flag == true)
                    return false;
                queue.add(temp.left);
            } else {
                flag = true;
            }

            if (temp.right != null) {
                if (flag == true)
                    return false;
                queue.add(temp.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /* Let us construct the following Binary Tree which
          is not a complete Binary Tree
                1
              /   \
             2     3
            / \     \
           4   5     6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        if (isCompleteBinaryTree(root) == true)
            System.out.println("Complete Binary Tree");
        else
            System.out.println("NOT Complete Binary Tree");
    }
}
