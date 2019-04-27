package Stack;

public class Stack {
    int arr[];
    int capacity;
    int top = -1;
    int size = 0;

    Stack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public int peek() {
        return arr[top];
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = item;
        this.size++;
        System.out.println(item + " pushed to stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        int item = arr[top];
        this.top--;
        this.size--;
        return item;
    }

    public static void main(String gg[]) {
        Stack s = new Stack(4);
        s.push(5);
        s.push(1);
        s.push(3);
        s.push(0);
        s.push(10);
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.pop() + " popped from stack");
        System.out.println(s.pop() + " popped from stack");
    }
}
