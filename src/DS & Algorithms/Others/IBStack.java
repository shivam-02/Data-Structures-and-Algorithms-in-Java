public class IBStack {

    int top;
    int a[];
    int MAX = 100;

    IBStack() {
        top = -1;
        a=new int[MAX];

    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int x) {
        if (top >= MAX - 1) {
            System.out.println("Overflow condition");
            return;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return;
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Underflow condition");
            return Integer.MIN_VALUE;
        } else {
            int x = a[top--];
            return x;
        }
    }

    public static void main(String args[]) {
        IBStack s = new IBStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }

}

