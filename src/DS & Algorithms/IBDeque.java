public class IBDeque {
    public int front, rear;
    public int arr[];
    public int size;

    public IBDeque(int size) {
        this.front = -1;
        this.rear = 0;
        this.arr = new int[size];
        this.size = size;
    }

    boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    boolean isEmpty() {
        return front == -1;
    }

    void insertFront(int key) {
        if (isFull())
            return;
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0)
            front = this.size - 1;
        else
            front = front - 1;
        arr[front] = key;
    }

    void insertRear(int key) {
        if (isFull()) return;

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == this.size - 1)
            rear = 0;
        else
            rear = rear + 1;

        arr[rear] = key;

    }

    void deleteFront() {
        if (isEmpty()) {
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        }
        if (front == size - 1) {
            front = 0;
        } else
            front = front + 1;

    }

    void deleteRear(){
        if(isEmpty()){
            return;
        }
        if(front==rear){
            front=-1;
            rear=-1;
        }
        if(rear==0){
            rear=this.size-1;
        } else
            rear=rear-1;
    }

    int getFront()
    {
        // check whether Deque is empty or not
        if (isEmpty())
        {
            System.out.println(" Underflow");
            return -1 ;
        }
        return arr[front];
    }

    // function return rear element of Deque
    int getRear()
    {
        // check whether Deque is empty or not
        if(isEmpty() || rear < 0)
        {
            System.out.println(" Underflow\n");
            return -1 ;
        }
        return arr[rear];
    }

    // Driver program to test above function
    public static void main(String[] args)
    {

        IBDeque dq = new IBDeque(5);

        System.out.println("Insert element at rear end  : 5 ");
        dq.insertRear(5);

        System.out.println("insert element at rear end : 10 ");
        dq.insertRear(10);

        System.out.println("get rear element : "+ dq.getRear());

        dq.deleteRear();
        System.out.println("After delete rear element new rear become : " +
                dq.getRear());

        System.out.println("inserting element at front end");
        dq.insertFront(15);

        System.out.println("get front element: " +dq.getFront());

        dq.deleteFront();

        System.out.println("After delete front element new front become : " +
                +  dq.getFront());

    }
}