package BinaryTree;

public class PrintPostOrder {

    static int PreIndex = 0;

    static void printPost(int in[], int pre[], int start, int end) {
        if (start > end)
            return;

        int index = search(in, start, end, pre[PreIndex++]);

        printPost(in, pre, start, index - 1);
        printPost(in, pre, index + 1, end);

        System.out.print(in[index]);
    }

    static int search(int[] in, int startIn, int endIn, int data) {
        int i = 0;
        for (i = startIn; i < endIn; i++)
            if (in[i] == data)
                return i;
        return i;
    }

    // Driver code
    public static void main(String ars[]) {
        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        int len = in.length;
        printPost(in, pre, 0, len - 1);
    }
}
