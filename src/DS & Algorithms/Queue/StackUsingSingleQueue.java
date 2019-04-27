package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {

    Queue<Integer> q = new LinkedList<>();


    public void push(int i) {
        int size = q.size();
        int count = 0;
        q.add(i);
        while (count < size) {
            q.add(q.remove());
            count++;
        }
        System.out.println(i + " pushed to stack");
    }

    public int pop() {
        if (!q.isEmpty())
            return q.poll();
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public static void main(String gg[]) {
        StackUsingSingleQueue s = new StackUsingSingleQueue();
        s.push(5);
        s.push(9);
        s.push(1);
        s.push(3);
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.pop() + " popped from stack");
    }
}
