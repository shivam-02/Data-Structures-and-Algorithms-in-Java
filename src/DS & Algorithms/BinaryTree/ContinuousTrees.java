package BinaryTree;

public class ContinuousTrees {

    static class Node {
        int data;
        Node left, right;
    }

    ;

/* Helper function that allocates a new node with the
given data and null left and right pointers. */

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    static boolean isContinuosTree(Node root) {

        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        if (root.left == null)
            return Math.abs(root.data - root.right.data) == 1 && isContinuosTree(root.right);


        if (root.right == null && Math.abs(root.data - root.left.data) == 1 && isContinuosTree(root.left))
            return true;

        return Math.abs(root.data - root.right.data) == 1 && Math.abs(root.data - root.left.data) == 1 && isContinuosTree(root.right) && isContinuosTree(root.left);
    }

    public static void main(String args[]) {
        Node root = newNode(3);
        root.left = newNode(2);
        root.right = newNode(4);
        root.left.left = newNode(1);
        root.left.right = newNode(3);
        root.right.right = newNode(5);
        if (isContinuosTree(root))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
