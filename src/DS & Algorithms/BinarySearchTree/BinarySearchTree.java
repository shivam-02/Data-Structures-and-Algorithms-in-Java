package BinarySearchTree;

public class BinarySearchTree {
    Node root;
    Node pre, succ;

    static class Node {
        int key;
        Node right;
        Node left;

        Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public Node search(Node root, int key) {
        if (root == null)
            return null;
        if (root.key == key) {
            return root;
        } else if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Node insert(int key) {
        return insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return root;
        } else if (root.key > key) {
            root.left = insertRec(root.left, key);
        } else if (root.key < key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    public Node deleteRec(Node root, int key) {
        if (root == null)
            return null;

        if (root.key > key) {
            root.left = deleteRec(root.left, key);
        } else if (root.key < key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            else {
                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key);
            }
        }
        return root;
    }

    public int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void findPreSucc(Node root, Node pre, Node succ, int key) {
        if (root == null)
            return;

        if (root.key == key) {
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null)
                    temp = temp.right;
                this.pre = pre = temp;
            }
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                this.succ = succ = temp;
            }
        } else if (root.key > key) {
            this.succ = succ = root;
            findPreSucc(root.left, pre, succ, key);
        } else if (root.key < key) {
            this.pre = pre = root;
            findPreSucc(root.right, pre, succ, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.root = tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        tree.inorder();

        tree.findPreSucc(tree.root, tree.pre, tree.succ, 50);
        System.out.println("Predecessor " + tree.pre.key);
        System.out.println("Successor " + tree.succ.key);

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
    }
}



