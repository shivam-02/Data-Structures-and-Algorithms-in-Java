import java.util.Stack;

public class ReverseStack {
    static Stack<Character> stack = new Stack<>();

    static void insertAtBottom(char x) {
        if (stack.empty()) {
            stack.push(x);
        } else {
            char a = stack.peek();
            stack.pop();
            insertAtBottom(x);
            stack.push(a);
        }
    }


    static void reverse() {
        if (!stack.empty()) {
            char x = stack.peek();
            stack.pop();
            reverse();
            insertAtBottom(x);
        }
    }

    public static void main(String[] args) {

        // push elements into
        // the stack
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');

        System.out.println("Original Stack");

        System.out.println(stack);

        // function to reverse
        // the stack
        reverse();

        System.out.println("Reversed Stack");

        System.out.println(stack);
    }
}
