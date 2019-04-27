import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
    }

}


public class IBTree {
    Node root;
    static int preIndex=0;
    public static void inorder(Node temp){
        if(temp==null)
            return;
        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
    }

    public static  void insert(Node root,int data){
        Queue<Node> q= new LinkedList<>();
        Node temp=root;
        q.add(temp);
        while(!q.isEmpty()){
            temp=q.peek();
            q.remove();
            if(temp.left==null){
                temp.left=new Node(data);
                break;
            } else {
                q.add(temp.left);
            }
            if(temp.right==null){
                temp.right=new Node(data);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    public static void inorderWithoutRecursion(Node root){
        Stack<Node> s=new Stack<>();
        Node curr=root;
        while(curr!=null || s.size()>0){
            while(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            curr=s.pop();
            System.out.print(" "+curr.data);
            curr=curr.right;
        }
    }
    public static int diameter(Node root){
        if(root==null)
            return 0;
        int lheight=height(root.left);
        int rheight=height(root.right);

        int ldiameter=diameter(root.left);
        int rdiameter=diameter(root.right);

        return Math.max((lheight+rheight+1),(Math.max(ldiameter,rdiameter)));
    }


    public static int height(Node root){
        if(root==null)return 0;
        return (1+Math.max(height(root.left),height(root.right)));
    }

    public static Node buildTree(char[] in,char[] pre,int strt,int end){
        if(strt>end)
            return null;
        Node newNode=new Node(pre[preIndex++]);
        if(strt==end)
            return newNode;
        int index=search(in,strt,end,newNode.data);
        newNode.left=buildTree(in,pre,strt,index-1);
        newNode.right=buildTree(in,pre,index+1,end);
        return newNode;
    }

    private static int search(char[] in,
                               int strt,
                               int end,
                               int data) {

        int i;
        for(i=strt;i<=end;i++){
            if(in[i]==data)
                return i;
        }
        return i;
    }

     static  boolean  printAncecstors(Node root,int key){
        if(root==null)
            return false;
        if(root.data==key)
            return true;

        if(printAncecstors(root.left,key)|| printAncecstors(root.right,key)){
            System.out.print(root.data+" ");
            return true;
        }
        return false;
    }



    public static void main(String gg[]){
        Node root =new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        System.out.print( "Inorder traversal before insertion:");
        inorder(root);

        int key = 12;
        insert(root, key);

        System.out.print("\nInorder traversal after insertion:");
        inorder(root);
        System.out.print("\nInorder traversal without recursion:");
        inorderWithoutRecursion(root);
        System.out.println("\nDiameter of tree : "+diameter(root));

        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        inorder(buildTree(in, pre, 0, 5));
        System.out.println("----------");
        printAncecstors(root,15);




    }
}


