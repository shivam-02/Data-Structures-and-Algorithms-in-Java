public class kadane {

    static int maxSubArray(int arr[], int n) {
        int max_so_far = 0;
        int max_ending = 0;

        for (int i = 0; i < n; i++) {
            max_ending = max_ending + arr[i];
            if (max_ending < 0)
                max_ending = 0;
            else if (max_so_far < max_ending)
                max_so_far = max_ending;
        }

        return max_so_far;
    }

    static int maxSubArrayWithAllNegative(int arr[],int n){
        int max_so_far=arr[0];
        int curr_max=arr[0];
        for(int i=1;i<n;i++){
            curr_max=Math.max(arr[i],curr_max+arr[i]);
            max_so_far=Math.max(max_so_far,curr_max);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArray(a,a.length));
    }
}
