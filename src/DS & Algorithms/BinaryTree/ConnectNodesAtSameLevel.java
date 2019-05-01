// Connect nodes at same level using level order
// traversal.

package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

    // Node class
    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    static void connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                temp.nextRight = queue.peek();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            } else if (!queue.isEmpty()) {
                queue.add(null);
            }
        }
    }

    /* Driver program to test above functions*/
    public static void main(String args[]) {

		/* Constructed binary tree is
				10
				/ \
			8	 2
			/		 \
		3		 90
		*/
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);

        // Populates nextRight pointer in all nodes
        connect(root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in \n" +
                "the tree (-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + root.data + " is " +
                ((root.nextRight != null) ? root.nextRight.data : -1));
        System.out.println("nextRight of " + root.left.data + " is " +
                ((root.left.nextRight != null) ? root.left.nextRight.data : -1));
        System.out.println("nextRight of " + root.right.data + " is " +
                ((root.right.nextRight != null) ? root.right.nextRight.data : -1));
        System.out.println("nextRight of " + root.left.left.data + " is " +
                ((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1));
        System.out.println("nextRight of " + root.right.right.data + " is " +
                ((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1));
    }
}

