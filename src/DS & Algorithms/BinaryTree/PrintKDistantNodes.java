package BinaryTree;


public class PrintKDistantNodes {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public void printKDistant(Node root, int k) {
        if (root == null)
            return;

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        } else {
            printKDistant(root.left, k - 1);
            printKDistant(root.right, k - 1);
        }
    }

    public static void main(String args[]) {
        PrintKDistantNodes tree = new PrintKDistantNodes();

        /* Constructed binary tree is
                1
              /   \
             2     3
            /  \   /
           4    5 8
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);

        tree.printKDistant(tree.root, 2);
    }
}

