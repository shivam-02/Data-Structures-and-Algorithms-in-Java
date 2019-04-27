import java.util.ListIterator;
import java.util.Stack;

public class SortStack {


    public static void sortedInsert(Stack<Integer> s, int x) {

        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
        } else {
            int temp = s.pop();
            sortedInsert(s, x);
            s.push(temp);
        }
    }


    public static void sort(Stack<Integer> s) {

        if (s.size() > 0) {
            int x = s.pop();
            sort(s);
            sortedInsert(s, x);
        }
    }

    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }

    // Driver method
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        sort(s);

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);

    }
}
