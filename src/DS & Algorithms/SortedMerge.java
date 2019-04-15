public class SortedMerge {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    public Node sortedMerge(Node a,Node b){

        Node dummy=new Node(Integer.MIN_VALUE);
        dummy.next=null;
        while(a!=null && b!=null){

            if(a.data>b.data){
                dummy.next=b;
                b=b.next;
            }else {
                dummy.next=a;
                a=a.next;
            }
        }
        if(a!=null){
            while(a!=null){
                dummy.next=a;
                a=a.next;
            }
        }
        if(b!=null){
            while(b!=null){
                dummy.next=b;
                b=b.next;
            }
        }
        return dummy.next;
    }

    public Node getMiddle(Node head){
        Node fast=head;
        Node slow=head;
        while(slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }
        return slow;
    }


    public Node mergeSort(Node head){

        if(head==null || head.next==null)return head;

        Node middle=getMiddle(head);
        Node middleNext=middle.next;

        middle.next=null;

        Node a=mergeSort(head);
        Node b=mergeSort(middleNext);

        Node res=sortedMerge(a,b);
        return res;

    }

}
