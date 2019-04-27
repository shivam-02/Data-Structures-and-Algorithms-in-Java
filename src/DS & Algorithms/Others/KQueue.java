public class KQueue {
    int arr[];
    int front[];
    int rear[];
    int next[];
    static int free=0;


    public KQueue(int k,int n){
        arr=new int[n];
        front=new int [k];
        rear=new int[k];
        next=new int[n];
        for(int i=0;i<k;i++){
            front[i]=-1;
        }
        for(int i=0;i<n-1;i++){
            next[i]=i+1;
        }
        next[n-1]=-1;
    }

     boolean  isFull(){
        return free==-1;
    }

    boolean isEmpty(int qn){
     return front[qn]==-1;
    }

    public  void enqueue(int item,int qn){
        if(isFull())
            return;

        int i=free;
        free=next[i];
        if(isEmpty(qn))
            front[qn]=i;
        else
            next[rear[qn]]=i;

        next[i]=-1;
        rear[qn]=i;
        arr[i]=item;
    }

    public int dequeue(int qn){
        if(isEmpty(qn))
            return Integer.MIN_VALUE;

        int i=front[qn];
        front[qn]=next[i];

        next[i]=free;
        free=i;
        return arr[i];
    }

    public static void main(String gg[]){
        int k = 3, n = 10;
        KQueue kQueue=new KQueue(k,n);

        // Let us put some items in queue number 2 
        kQueue.enqueue(15, 2);
        kQueue.enqueue(45, 2);

        // Let us put some items in queue number 1 
        kQueue.enqueue(17, 1);
        kQueue.enqueue(49, 1);
        kQueue.enqueue(39, 1);

        // Let us put some items in queue number 0 
        kQueue.enqueue(11, 0);
        kQueue.enqueue(9, 0);
        kQueue.enqueue(7, 0);

        System.out.println( "Dequeued element from queue 2 is " + kQueue.dequeue(2));
        System.out.println( "Dequeued element from queue 1 is " + kQueue.dequeue(1));
        System.out.println( "Dequeued element from queue 0 is " + kQueue.dequeue(0));


    }
}
