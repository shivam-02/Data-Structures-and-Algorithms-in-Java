package BinaryTree;

public class FoldableTrees {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    boolean isFoldable(Node root) {
        if (root == null)
            return true;

        mirror(root.left);

        return isStructureSame(root.left, root.right);
    }

    void mirror(Node node) {
        if (node == null)
            return;

        mirror(node.left);
        mirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

    }

    boolean isStructureSame(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a != null && b != null)
            return isStructureSame(a.left, b.left) && isStructureSame(a.right, b.right);
        return false;
    }

    public static void main(String args[]) {
        FoldableTrees tree = new FoldableTrees();

        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.isFoldable(tree.root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");
    }

}
