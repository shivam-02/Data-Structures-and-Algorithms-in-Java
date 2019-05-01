package BinarySearchTree;

public class Ceil {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node root;

    public int ceil(Node root, int input) {
        if (root == null)
            return -1;

        if (root.data == input)
            return root.data;

        if (root.data < input)
            return ceil(root.right, input);

        int ceil = ceil(root.left, input);

        return ceil >= input ? ceil : root.data;
    }

    public static void main(String[] args) {
        Ceil tree = new Ceil();
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);
        for (int i = 0; i < 16; i++) {

            System.out.println(i + " " +
                    tree.ceil(tree.root, i));
        }
    }
}
