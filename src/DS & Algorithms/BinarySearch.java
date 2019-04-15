public class BinarySearch {


    public static int binarySearch(int arr[],
                                   int l,
                                   int r,
                                   int x) {
        int mid = l + (r - l) / 2;
        if (x == arr[mid])
            return mid;
        if (x > arr[mid])
            return binarySearch(arr, mid + 1, r, x);
        else
            return binarySearch(arr, 0, mid - 1, x);
    }

    public static int bs(int arr[],
                         int l,
                         int r,
                         int x) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (x == arr[mid])
                return mid;
            if (x > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }


    public static void main(String gg[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int index = bs(arr, 0, n - 1, 2);
        System.out.print("Found at : " + index);
    }
}
