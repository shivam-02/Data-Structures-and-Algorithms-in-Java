package AQuestions;

public class MaxHeightOfTree {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int height(Node node) {
        if (node == null)
            return 0;

        int lheight = height(node.left);
        int rheight = height(node.right);

        return Math.max(lheight, rheight) + 1;
    }
}
