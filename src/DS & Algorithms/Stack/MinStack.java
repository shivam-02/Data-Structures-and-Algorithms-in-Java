package Stack;


import java.util.Stack;

public class MinStack extends Stack<Integer> {

    Stack<Integer> min = new Stack<>();

    public void push(int item) {
        if (isEmpty()) {
            super.push(item);
            min.push(item);
        } else {
            super.push(item);
            int prevMin = min.pop();
            min.push(prevMin);
            if (prevMin > item) {
                min.push(item);
            }
        }
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        int item = super.pop();
        if (item == min.peek()) {
            min.pop();
        }
        return item;
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
}
