import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {


    public static void reverse(Queue<Integer> queue){

        if(queue.isEmpty()) return;
        int x= queue.poll();
        int res=0;
        reverse(queue);
        queue.add(x);

    }

    public static void main(String gg[]){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        reverse(queue);
        System.out.print(queue);

    }
}
