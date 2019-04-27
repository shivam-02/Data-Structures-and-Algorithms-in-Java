package Stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    static void calculateSpan(int price[], int n, int s[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        s[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                s[i] = i + 1;
            } else {
                s[i] = i - stack.peek();
            }
            stack.push(i);
        }
    }

    static void printArray(int arr[]) {
        System.out.print(Arrays.toString(arr));
    }

    // Driver method
    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        // print the calculated span values
        printArray(S);
    }
}
