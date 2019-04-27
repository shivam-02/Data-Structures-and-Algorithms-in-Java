public class Pivot {

    static int findPivot(int a[], int low, int high) {
        if (high < low)
            return -1;
        if (high == low)
            return low;
        int mid = low + (high - low) / 2;
        if (mid < high && a[mid] > a[mid + 1])
            return mid;
        else if (mid > low && a[mid - 1] > a[mid])
            return mid - 1;
        else if (a[low] >= a[mid])
            return findPivot(a, low, mid - 1);
        else
            return findPivot(a, mid + 1, high);
    }

    static int pivotedBinarySearch(int a[], int n, int key) {
        int pivot = findPivot(a, 0, n - 1);
        if (pivot == -1)
            binarySearch(a, 0, n - 1, key);

        if (a[pivot] == key)
            return pivot;

        if (a[0] <= key)
            return binarySearch(a, 0, pivot - 1, key);
        else
            return binarySearch(a, pivot + 1, n - 1, key);

    }

    static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    // main function
    public static void main(String args[]) {
        // Let us search 3 in below array
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is : "
                + pivotedBinarySearch(arr1, n, key));
    }
}
