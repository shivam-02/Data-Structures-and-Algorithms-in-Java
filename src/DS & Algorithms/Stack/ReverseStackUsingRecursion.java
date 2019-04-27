package Stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    public static void main(String gg[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    public static void reverse(Stack<Integer> stack) {

        if (!stack.isEmpty()) {
            int x = stack.pop();
            reverse(stack);
            insertAtBottom(stack, x);
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int a = stack.pop();
            insertAtBottom(stack, x);
            stack.push(a);
        }
    }
}
