public class IB1 {

    public static void rotate(int arr[], int d, int n) {

        int i, j, k, temp;
        for (i = 0; i < gcd(n, d); i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String gg[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7,8,9,10,11};
        rotate(arr, 3, arr.length);
        printArray(arr, arr.length);
    }

    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

}
