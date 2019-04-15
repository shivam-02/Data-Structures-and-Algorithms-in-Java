import java.util.ArrayList;
import java.util.Stack;

public class BST {
    Node root;

    Node first, prev, last, middle;

    Index preIndex = new Index();

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public Node search(Node root, int key) {

        if (root == null || root.key == key) {
            return root;
        } else if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else if (root.key > key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }
        return root;
    }


    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    public Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (root.key > key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    public int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    public Node constructTreeIterative(int pre[], int size) {
        Stack<Node> stack = new Stack<>();
        Node root = new Node(pre[0]);
        stack.push(root);
        for (int i = 1; i < size; i++) {
            Node temp = null;

            while (!stack.isEmpty() && pre[i] > stack.peek().key) {
                temp = stack.pop();
            }
            if (temp != null) {
                temp.right = new Node(pre[i]);
                stack.push(temp.right);
            } else {
                temp = stack.peek();
                temp.left = new Node(pre[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }

    class Index {
        int index = 0;
    }

    public Node constructTree(int pre[], int size) {
        return constructTreeUtil(pre, preIndex, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    public Node constructTreeUtil(int pre[], Index preIndex, int key, int min, int max, int size) {

        if (preIndex.index >= size) return null;
        Node root = null;
        if (key > min && key < max) {
            root = new Node(key);
            preIndex.index = preIndex.index + 1;
            if (preIndex.index < size) {
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }
        return root;
    }

    Node sortedArrayToBST(int[] arr, int start, int end) {

        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    class Sum {
        int sum = 0;
    }

    void transformTree() {
        Sum sum = new Sum();
        transformTreeUtil(root, sum);
    }

    void transformTreeUtil(Node root, Sum sum) {
        if (root == null) return;

        transformTreeUtil(root.right, sum);

        sum.sum = sum.sum + root.key;
        root.key = sum.sum - root.key;

        transformTreeUtil(root.left, sum);
    }

    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public ArrayList<Node> constructTrees(int start, int end) {
        ArrayList<Node> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i < end; i++) {
            ArrayList<Node> leftSubtree = constructTrees(start, i - 1);
            ArrayList<Node> rightSubtree = constructTrees(i + 1, end);

            for (int j = 0; j < leftSubtree.size(); j++) {
                Node left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    Node right = rightSubtree.get(k);
                    Node node = new Node(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);

                }
            }
        }
        return list;
    }

    boolean canRepresentBST(int[] pre, int size) {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            if (pre[i] < root) return false;

            while (!s.isEmpty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }
            s.push(pre[i]);
        }
        return true;
    }


    Node lca(Node root, Node n1, Node n2) {
        if (root == null)
            return null;

        if (root.key > n1.key && root.key > n2.key) {
            return lca(root.left, n1, n2);
        }
        if (root.key < n1.key && root.key < n2.key) {
            return lca(root.right, n1, n2);
        }
        return root;
    }

    class Count {
        int c = 0;
    }

    void KthLargestElement(Node root, int k, Count count) {
        if (root == null || count.c >= k) return;

        KthLargestElement(root.right, k, count);

        count.c++;

        if (count.c == k) {
            System.out.println("Kth largest element is " + root.key);
        }

        KthLargestElement(root.left, k, count);
    }

    boolean hasOnlyOneChild(int[] pre, int size) {
        int nextDiff;
        int lastDiff;
        for (int i = 0; i < size - 1; i++) {
            nextDiff = pre[i] - pre[i + 1];
            lastDiff = pre[i] - pre[size - 1];
            if (nextDiff * lastDiff < 0) {
                return false;
            }
        }
        return true;
    }

    int ceil(Node root, int input) {
        if (root == null) return -1;

        if (root.key == input)
            return root.key;

        if (root.key < input) {
            return ceil(root.right, input);
        }
        int ceil = ceil(root.left, input);

        return ceil >= input ? ceil : root.key;
    }

    void correctBSTUTil(Node root) {
        if (root != null) {
            correctBSTUTil(root.left);

            if (prev != null && root.key < prev.key) {
                if (first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }
            prev = root;
            correctBSTUTil(root.right);
        }
    }

    void correctBST() {
        prev = first = last = middle = null;

        correctBSTUTil(root);

        if (first != null && last != null) {
            int temp = first.key;
            first.key = last.key;
            last.key = temp;

        } else if (first != null && middle != null) {
            int temp = first.key;
            first.key = middle.key;
            middle.key = temp;
        }
    }


    void findPreSucc(Node root, Node pre, Node succ, int key) {
        if (root == null) return;

        if (root.key == key) {
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                pre = temp;
            }
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                succ = temp;
            }

        }
        if (root.key > key) {
            succ = root;
            findPreSucc(root.left, pre, succ, key);
        }
        if (root.key < key) {
            pre = root;
            findPreSucc(root.right, pre, succ, key);
        }
    }

    boolean isBST() {
        return isBSTUtil(root, null, null);
    }

    boolean isBSTUtil(Node root, Node left, Node right) {
        if (root == null)
            return true;

        if (left != null && root.key < left.key)
            return false;

        if (right != null && root.key > right.key)
            return false;

        return (isBSTUtil(root.left, left, root) && isBSTUtil(root.right, root, right));
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        BST tree = new BST();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        tree.transformTree();
        System.out.println("Greater sum tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();


        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        tree.root = tree.constructTreeIterative(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.inorder();
    }
}

