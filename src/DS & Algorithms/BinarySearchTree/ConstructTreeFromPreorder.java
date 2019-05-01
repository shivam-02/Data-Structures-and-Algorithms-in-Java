package BinarySearchTree;

import BinaryTree.ConstructTreeFromInorderAndPreorder;

import java.util.Stack;

public class ConstructTreeFromPreorder {
    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    class Index {
        int index = 0;
    }

    Node constructTree(int pre[], int size) {
        Index preIndex = new Index();
        return constructTreeUtil(pre, preIndex, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    Node constructTreeUtil(int[] pre, Index preIndex, int key, int min, int max, int size) {

        if (preIndex.index >= size)
            return null;

        Node root = null;

        if (key > min && key < max) {
            root = new Node(key);
            preIndex.index++;
            if (preIndex.index < size) {
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }
        return root;
    }

    Node constructTreeIterative(int[] pre, int size) {

        Node root = new Node(pre[0]);
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < size; i++) {
            Node temp = null;
            while (!stack.isEmpty() && pre[i] > stack.peek().data) {
                temp = stack.pop();
            }
            if (temp != null) {
                temp.right = new Node(pre[i]);
                stack.push(temp.right);
            } else {
                temp = stack.peek();
                temp.left = new Node(pre[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        ConstructTreeFromPreorder tree = new ConstructTreeFromPreorder();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTreeIterative(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}
