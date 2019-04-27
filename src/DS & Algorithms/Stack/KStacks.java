package Stack;

public class KStacks {
    int arr[];
    int top[];
    int next[];
    int free = 0;

    KStacks(int k, int n) {
        arr = new int[n];
        top = new int[k];
        next = new int[n];
        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;
        next[n - 1] = -1;
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }
    }

    public boolean isFull() {
        return free == -1;
    }

    public boolean isEmpty(int sn) {
        return top[sn] == -1;
    }

    public void push(int item, int sn) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        int i = free;

        free = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = item;
    }

    public int pop(int sn) {

        if (isEmpty(sn)) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int i = top[sn];

        top[sn] = next[i];

        next[i] = free;
        free = i;

        return arr[i];
    }

    public static void main(String[] args) {
        // Let us create 3 stacks in an array of size 10
        int k = 3, n = 10;

        KStacks ks = new KStacks(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}
