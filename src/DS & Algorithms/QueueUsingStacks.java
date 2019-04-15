import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public void enqueue(int n){
        s1.push(n);
    }

    public int dequeue(){
        if(s1.isEmpty() && s2.isEmpty()){
            System.out.println("Underflow condition");
            return -1;
        }
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
         int x=s2.peek();
         s2.pop();
         return x;
    }

    public int dequeueUsingRec(){
        int x;
        int res;
        if(s1.isEmpty()){
            System.out.println("Underflow condition");
            return -1;
        }
        if(s1.size()==1)
            return s1.pop();
        else {
             x=s1.pop();
            res=dequeueUsingRec();
            s1.push(x);
        }
        return res;
    }


    public static void main(String gg[]){
        QueueUsingStacks q=new QueueUsingStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
       /* System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());*/
        System.out.println(q.dequeueUsingRec());
        System.out.println(q.dequeueUsingRec());
        System.out.println(q.dequeueUsingRec());

    }
}
