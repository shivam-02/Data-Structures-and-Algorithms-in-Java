package BinaryTree;

import java.util.Stack;

public class ZigZagTraversal {
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

    public static void zigZagTraversal(Node root) {

        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Node temp = currentLevel.pop();
            System.out.print(temp.key + " ");
            if (leftToRight) {
                if (temp.left != null)
                    nextLevel.add(temp.left);
                if (temp.right != null)
                    nextLevel.add(temp.right);
            } else {
                if (temp.right != null)
                    nextLevel.add(temp.right);
                if (temp.left != null)
                    nextLevel.add(temp.left);
            }
            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> s = currentLevel;
                currentLevel = nextLevel;
                nextLevel = s;
            }
        }
    }

    public static void main(String[] args) {
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        zigZagTraversal(tree.root);
    }
}
