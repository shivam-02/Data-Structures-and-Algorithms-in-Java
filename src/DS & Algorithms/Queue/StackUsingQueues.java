package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int item) {
        q1.offer(item);
        System.out.println(item + " pushed to stack");
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
        }
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
        int item = q1.poll();
        Queue<Integer> temp;
        temp = q1;
        q1 = q2;
        q2 = temp;
        System.out.println(item + " popped from stack");
        return item;
    }

    public static void main(String gg[]) {
        StackUsingQueues s = new StackUsingQueues();
        s.push(5);
        s.push(3);
        s.push(7);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
}
