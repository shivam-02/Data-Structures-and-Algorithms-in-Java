public class FindMaxSum {

    int findMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = 0;
        int excl_new;

        for (int i = 1; i < n; i++) {
            excl_new = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = excl_new;
        }
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        FindMaxSum sum = new FindMaxSum();
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(sum.findMaxSum(arr, arr.length));
    }
}
