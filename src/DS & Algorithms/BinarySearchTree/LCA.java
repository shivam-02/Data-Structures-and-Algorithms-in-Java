package BinarySearchTree;

public class LCA {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (n1 > root.data && n2 > root.data)
            return lca(root.right, n1, n2);

        if (n1 < root.data && n2 < root.data)
            return lca(root.left, n1, n2);

        return root;
    }

    public static void main(String args[]) {
        // Let us construct the BST shown in the above figure
        LCA tree = new LCA();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("lca of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("lca of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("lca of " + n1 + " and " + n2 + " is " + t.data);

    }
}
