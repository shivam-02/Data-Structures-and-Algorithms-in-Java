package Stack;

import java.util.Stack;

public class NextGreaterElement {

    static void printNGE(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int element;
        int next;
        for (int i = 1; i < n; i++) {
            next = arr[i];

            if (!stack.isEmpty()) {
                element = stack.pop();
                while (element < next) {
                    System.out.println(element + " ---> " + next);
                    if (stack.isEmpty())
                        break;
                    element = stack.pop();
                }
                if (element > next)
                    stack.push(element);
            }
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            next = -1;
            System.out.println(stack.pop() + " ---> " + next);
        }
    }

    static void printNGESameOrder(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i])
                    stack.pop();
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ---> " + nge[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        //printNGE(arr, n);
        printNGESameOrder(arr, n);
    }
}
