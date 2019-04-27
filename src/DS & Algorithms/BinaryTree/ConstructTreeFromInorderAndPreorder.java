package BinaryTree;

class Node {
    char data;
    Node left, right;

    Node(char item) {
        data = item;
        left = right = null;
    }
}

public class ConstructTreeFromInorderAndPreorder {

    static int preIndex = 0;

    Node buildTree(char in[], char pre[], int start, int end) {
        if (start > end)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (start == end)
            return root;

        int index = search(in, start, end, root.data);

        root.left = buildTree(in, pre, start, index - 1);
        root.right = buildTree(in, pre, index + 1, end);

        return root;
    }

    int search(char arr[], int strt, int end, char value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // driver program to test above functions
    public static void main(String args[]) {
        ConstructTreeFromInorderAndPreorder tree = new ConstructTreeFromInorderAndPreorder();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
