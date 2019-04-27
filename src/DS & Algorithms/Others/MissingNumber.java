public class MissingNumber {

    static int getMissingNumber(int a[], int n) {
        int x1 = a[0];
        int x2 = 1;

        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];

        for (int j = 2; j <= n + 1; j++)
            x2 = x2 ^ j;

        return x1 ^ x2;
    }

    public static void main(String args[]) {
        int a[] = {1, 2, 4, 5, 6};
        int miss = getMissingNumber(a, 5);
        System.out.println(miss);
    }
}
