package BinaryTree;

public class PrintAncestors {
    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }
    }

    Node root;

    public boolean printAncestors(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (printAncestors(root.left, key) || printAncestors(root.right, key)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        PrintAncestors tree = new PrintAncestors();

        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 7);

    }
}
