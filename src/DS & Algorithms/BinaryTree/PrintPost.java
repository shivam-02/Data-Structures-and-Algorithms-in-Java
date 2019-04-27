package BinaryTree;

public class PrintPost {
    static int preIndex = 0;

    static void printPost(int pre[], int n, int minVal, int maxVal) {

        if (preIndex == n)
            return;

        if (pre[preIndex] < minVal || pre[preIndex] > maxVal) {
            return;
        }
        int val = pre[preIndex++];
        printPost(pre, n, minVal, val);
        printPost(pre, n, val, maxVal);
        System.out.print(val + " ");
    }

    public static void main(String args[]) {
        int pre[] = {40, 30, 35, 80, 100};

        int n = pre.length;

        // Calling function
        printPost(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
