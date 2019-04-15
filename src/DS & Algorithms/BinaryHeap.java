public class BinaryHeap {

    int[] arr;
    int size;
    int capacity;
    BinaryHeap(int capacity){
        this.size=0;
        this.arr=new int[capacity];
        this.capacity=capacity;
    }

    int getParent(int i){
        return (i-1)/2;
    }
    int getLeftChild(int i){
        return (2*i+1)/2;
    }
    int getRightChild(int i){
        return (2*i+1)/2;
    }


    public void insertKey(int val){
        if(this.size==this.capacity){
            System.out.print("Overflow condition");
        }
        else {
            this.size++;
            int i=this.size-1;
            arr[i]=val;
            while(i!=0 && arr[getParent(i)]>arr[i]){
                int temp=arr[i];
                arr[i]=arr[getParent(i)];
                arr[getParent(i)]=temp;
                i=getParent(i);
            }

        }
    }

    public void decreaseKey(int i,int new_val){
        arr[i]=new_val;
        while(i!=0 && arr[getParent(i)]>arr[i]){
            int temp=arr[i];
            arr[i]=arr[getParent(i)];
            arr[getParent(i)]=temp;
            i=getParent(i);
        }
    }

    public int getMin(){
        return arr[0];
    }

    public int extractMin(){
        if(this.size==0){
            System.out.println("Underflow condition");
            return Integer.MIN_VALUE;
        }else if(this.size==1) {
            this.size--;
            return arr[0];
        } else {
            int root=arr[0];
            arr[0]=arr[this.size-1];
            this.size--;
            MinHeapify(0);
            return root;
        }
    }

    public void MinHeapify(int i){
        int l=getLeftChild(i);
        int r=getRightChild(i);
        int smallest=i;
        while(l<this.size && arr[l]<arr[i])
            smallest=l;
        while(r<this.size && arr[r]<arr[smallest])
            smallest=r;
        if(smallest!=i){
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
            MinHeapify(smallest);
        }
    }

    public void deleteKey(int i){
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String gg[]){

        BinaryHeap binaryHeap=new BinaryHeap(11);
        binaryHeap.insertKey(3);
        binaryHeap.insertKey(2);
        binaryHeap.deleteKey(1);
        binaryHeap.insertKey(15);
        binaryHeap.insertKey(5);
        binaryHeap.insertKey(4);
        binaryHeap.insertKey(45);
        System.out.println(binaryHeap.arr);
        System.out.println(binaryHeap.extractMin()+ " ");
        System.out.println(binaryHeap.getMin()+ " ");
        binaryHeap.decreaseKey(2, 1);
        System.out.println(binaryHeap.getMin());
    }
}
