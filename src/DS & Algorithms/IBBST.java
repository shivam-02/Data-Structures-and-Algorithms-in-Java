import java.util.Stack;

public class IBBST {
    Node root;
    static int preIndex=0;

    static class Node {
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
        }
    }

    public boolean search(Node root,int key){
        if(root==null)return false;
        if(root.data==key)return true;
        if(root.data>key)
            return search(root.left,key);
        else
            return search(root.right,key);
    }

    public Node insert(Node root,int key){
        if(root==null){
            root=new Node(key);
        }
        if(root.data>key){
            if(root.left==null)
                root.left=new Node(key);
            else
                 insert(root.left,key);
        } else {
            if(root.right==null)
                root.right=new Node(key);
            else
                 insert(root.right,key);
        }
        return root;
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }

    void deleteRec(int key){
        root=delete(root,key);
    }

    public Node delete(Node root,int key){
        if(root==null)return null;
        if(root.data>key){
            root.left=delete(root.left,key);
        } else if(root.data<key){
            root.right=delete(root.right,key);
        } else {
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else {
                root.data=minValue(root.right);
                root.right=delete(root.right,root.data);
            }
        }
        return root;
    }

    int minValue(Node root){
        int minV=root.data;
        while(root.left!=null){
            minV=root.left.data;
            root=root.left;
        }
        return minV;
    }
    public Node constructTree(int []pre,int size){
        return constructTreeUtil(pre,pre[preIndex],Integer.MIN_VALUE,Integer.MAX_VALUE,size);
    }

    public Node constructTreeUtil(int[]pre,int key,int min,int max,int size){

        if(preIndex>=size){
            return null;
        }

        Node root=null;

        if(key>min && key<max){
            root=new Node(key);
            preIndex=preIndex+1;
            //
            if(preIndex<size) {
                root.left = constructTreeUtil(pre,pre[preIndex], min, key, size);
                root.right = constructTreeUtil(pre, pre[preIndex], key, max, size);
            }
        }
        return root;
    }

    public Node constructTreeFromStack(int pre[],int size){
        Node root=new Node(pre[0]);
        Stack<Node> s=new Stack<>();
        s.push(root);
        for(int i=1;i<size;i++){
            Node temp=null;
            while(!s.isEmpty() && pre[i]>s.peek().data){
                temp=s.pop();
            }
            if(temp!=null) {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            } else {
                temp=s.peek();
                temp.left=new Node(pre[i]);
                s.push(temp.left);
            }

        }
        return root;
    }

    public static void main(String gg[]){
        Node n1=new Node(50);
        IBBST bst=new IBBST();
        bst.root=n1;
        bst.insert(bst.root,10);
        bst.insert(bst.root,20);
        bst.insert(bst.root,80);
        bst.insert(bst.root,100);
        bst.insert(bst.root,70);
        bst.insert(bst.root,40);

        System.out.println(bst.search(bst.root,40));
        bst.deleteRec(50);
        bst.inorderRec(bst.root);
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = bst.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        bst.inorderRec(root);
        Node rootOfStack = bst.constructTreeFromStack(pre, size);
        System.out.println("Inorder traversal of the constructed tree from stack is ");
        bst.inorderRec(rootOfStack);
    }
}
