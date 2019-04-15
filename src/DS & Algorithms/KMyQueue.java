public class KMyQueue {
    int front[];
    int rear[];
    int free;
    int arr[];
    int next[];

    KMyQueue(int k,int n){
        front=new int[k];
        rear=new int[k];
        free=0;
        arr=new int[n];
        next=new int[n];
        for(int i=0;i<k;i++)
            front[i]=-1;
        for(int i=0;i<n-1;i++)
            next[i]=i+1;
        next[n-1]=-1;
    }

    public boolean isEmpty(int qn){
        return front[qn]==-1;
    }

    public boolean isFull(int qn){
        return free==-1;
    }


    public void enqueue(int item,int qn){
        if(isFull(qn)){
            return;
        }
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
        if(isEmpty(qn))return Integer.MIN_VALUE;
        int i=front[qn];
        front[qn]=next[i];
        next[i]=free;
        free=i;
        return arr[i];
    }

    public static void main(String gg[]){
        int k = 3, n = 10;
        KMyQueue ks=new KMyQueue(3,10);

        // Let us put some items in queue number 2
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);

        // Let us put some items in queue number 1
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);

        // Let us put some items in queue number 0
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);

        System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1) );
        System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0));
    }
}
