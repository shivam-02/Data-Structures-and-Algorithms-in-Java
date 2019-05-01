package BinaryTree;

import java.util.HashMap;

public class CloneTreeWithRandomPointers {

    static class Node {
        int data;
        Node left, right, random;

        Node(int data) {
            this.data = data;
            this.left = this.right = this.random = null;
        }
    }

    public Node copyLeftRight(Node root, HashMap<Node, Node> hm) {
        if (root == null)
            return null;
        Node clone = new Node(root.data);
        hm.put(root, clone);
        clone.left = copyLeftRight(root.left, hm);
        clone.right = copyLeftRight(root.right, hm);
        return clone;
    }

    public void copyRandom(Node root, Node clone, HashMap<Node, Node> hm) {
        if (clone == null)
            return;
        clone.random = hm.get(root.random);
        copyRandom(root.left, clone.left, hm);
        copyRandom(root.right, clone.right, hm);
    }

    public Node cloneTree(Node root) {
        if (root == null)
            return null;

        HashMap<Node, Node> hm = new HashMap<>();
        Node cloned = copyLeftRight(root, hm);
        copyRandom(root, cloned, hm);
        return cloned;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.random = root.left.right;
        root.left.random = root;
        root.right.random = root.left.left;
        root.left.left.random = root.left.right;
        root.left.right.random = root;
        inorder(root);
        CloneTreeWithRandomPointers c = new CloneTreeWithRandomPointers();
        Node cloned = c.cloneTree(root);
        System.out.println("\nAfter clonning ");
        inorder(cloned);


    }

}
